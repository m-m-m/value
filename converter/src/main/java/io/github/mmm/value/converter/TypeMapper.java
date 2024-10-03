package io.github.mmm.value.converter;

import io.github.mmm.base.lang.Builder;

/**
 * Interface to convert or decompose a {@link #getSourceType() source type} to a {@link #getTargetType() target type}
 * and vice-versa.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @param <T> the {@link #getTargetType() target type}.
 * @since 1.0.0
 */
public interface TypeMapper<S, T> {

  /**
   * The default separator for {@link NameMode#format(String, String) name mapping}. It would be more natural to use "."
   * but unfortunately this is not accepted in column names of common database products. Other common separators like
   * "_" are likely to clash with other convenient naming. Therefore, we need to use something that is reserved or
   * specific enough not to be used in regular names but is still accepted by all databases.
   */
  String DEFAULT_SEPARATOR = "$";

  /**
   * @return the {@link Class} reflecting the source type to convert or decompose.
   */
  Class<? extends S> getSourceType();

  /**
   * @return the {@link Class} reflecting the target type to convert to.
   */
  Class<? extends T> getTargetType();

  /**
   * @return the suffix to {@link NameMode#format(String, String) append to the name}. Will be the empty {@link String}
   *         for no suffix.
   */
  default String getSuffix() {

    return "";
  }

  /**
   * @return the {@link NameMode} of this mapper.
   */
  default NameMode getNameMode() {

    return NameMode.NORMAL;
  }

  /**
   * @return the (optional) declaration for this type {@link #next() segment} (e.g. SQL type declaration such as
   *         "NUMBER(30,10").
   */
  default String getDeclaration() {

    return "";
  }

  /**
   * @return {@code true} if a non-{@link String#isEmpty() empty} {@link #getDeclaration() declaration} is present,
   *         {@code false} otherwise.
   */
  default boolean hasDeclaration() {

    String declaration = getDeclaration();
    return (declaration != null) && !declaration.isEmpty();
  }

  /**
   * @param source the value of the {@link #getSourceType() source type} to convert. Must not be {@code null}. For
   *        {@code null} values use {@link #toTargetNull()} instead.
   * @return the {@code source} value converted to the {@link #getTargetType() target type}.
   */
  T toTarget(S source);

  /**
   * @return the representation of {@code null} for the {@link #getTargetType() target type} (typically {@code null}).
   */
  default T toTargetNull() {

    return null;
  }

  /**
   * This method converts back from the {@link #getTargetType() target type} to the {@link #getSourceType() source
   * type}.<br>
   * <b>ATTENTION:</b> This method may only be used for atomic {@link TypeMapper}s. For {@link #next() composite}
   * {@link TypeMapper} use {@link #with(Builder, Object)} or {@link #toSource(Object...)}.
   *
   * @param target the value of the {@link #getTargetType() target type} to convert. Must not be {@code null}. For
   *        {@code null} values use {@link #toSourceNull()} instead.
   * @return the {@code target} value converted to the {@link #getSourceType() source type}.
   */
  @SuppressWarnings("unchecked")
  default S toSource(T target) {

    return (S) target;
  }

  /**
   * @return the representation of {@code null} for the {@link #getSourceType() source type} (typically {@code null}).
   */
  default S toSourceNull() {

    return null;
  }

  /**
   * @return a new {@link Builder} to {@link Builder#build() build} the {@link #getSourceType() source type}.
   * @see #with(Builder, Object)
   */
  default Builder<S> sourceBuilder() {

    return null;
  }

  /**
   * Applies a given {@code targetSegment} to the {@link #sourceBuilder() source builder}.
   *
   * @param builder the {@link #sourceBuilder() source builder}.
   * @param targetSegment the {@link #getTargetType() target} {@link #next() segment} value.
   */
  default void with(Builder<S> builder, T targetSegment) {

  }

  /**
   * This method converts back from the {@link #getTargetType() target type} to the {@link #getSourceType() source type}
   * with support for composition out of {@link #next() segment}s.<br>
   * <b>ATTENTION:</b> Due to performance optimization this method shall only be used for {@link #next() composite}
   * {@link TypeMapper}s. You may override this method to avoid {@link Builder} overhead. For atomic types use
   * {@link #toSource(Object)}.
   *
   * @param segments the {@link #next() segment}s to compose.
   * @return the converted or composed {@link #getSourceType() source} value.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  default S toSource(Object... segments) {

    if (segments == null) {
      return null;
    } else if (segments.length == 0) {
      throw new IllegalArgumentException();
    } else if (segments.length == 1) {
      return toSource((T) segments[0]);
    } else {
      Builder<S> builder = sourceBuilder();
      TypeMapper mapper = this;
      int i = 0;
      do {
        if (i < segments.length) {
          mapper.with(builder, segments[i]);
        }
        i++;
        mapper = mapper.next();
      } while (mapper != null);
      if (i != segments.length) {
        throw new IllegalArgumentException(
            "Provided " + segments.length + " segments instead of " + i + " for composite TypeMapper: " + this);
      }
      return builder.build();
    }
  }

  /**
   * @return the optional next {@link TypeMapper} in case of a composite {@link #getSourceType() source type} that shall
   *         be decomposed into individual {@link #getTargetType() target} segments. For each segment you can iterate
   *         via this method until the last segment that will return {@code null}. If already the first
   *         {@link TypeMapper} returns {@code null} here, the {@link #getSourceType() source type} will not be
   *         decomposed.
   */
  default TypeMapper<S, ?> next() {

    return null;
  }

  public static enum NameMode {

    /**
     * Use the name followed by {@link TypeMapper#DEFAULT_SEPARATOR separator} and the {@link TypeMapper#getSuffix()
     * suffix}. If {@link TypeMapper#getSuffix() suffix} is empty only use name.
     */
    NORMAL() {

      @Override
      public String format(String name, String suffix, String separator) {

        if ((suffix == null) || suffix.isEmpty()) {
          return name;
        }
        return name + separator + suffix;
      }
    },

    /** Use the name only and ignore the {@link TypeMapper#getSuffix() suffix}. */
    NAME() {

      @Override
      public String format(String name, String suffix, String separator) {

        return name;
      }
    },

    /** Use the {@link TypeMapper#getSuffix() suffix} only and ignore the name. */
    SUFFIX() {

      @Override
      public String format(String name, String suffix, String separator) {

        assert !suffix.isEmpty();
        return suffix;
      }
    };

    /**
     * @param name the name to format (e.g. name of property or database column).
     * @param suffix the {@link TypeMapper#getSuffix() suffix}.
     * @return the original {@code name} or a mapped variant. E.g. for {@link #NORMAL} the result of
     *         {@link #format(String, String) format}("Range", "Min") would be "Range$Min".
     */
    public String format(String name, String suffix) {

      return format(name, suffix, DEFAULT_SEPARATOR);
    }

    /**
     * @param name the name to format (e.g. name of property or database column).
     * @param suffix the {@link TypeMapper#getSuffix() suffix}.
     * @param separator the explicit {@link TypeMapper#DEFAULT_SEPARATOR separator} to use.
     * @return the original {@code name} or a mapped variant. E.g. for {@link #NORMAL} the result of
     *         {@link #format(String, String) format}("Range", "Min") would be "Range$Min".
     */
    public abstract String format(String name, String suffix, String separator);

  }

}
