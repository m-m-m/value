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

  /** The default separator for {@link #mapName(String) name mapping}. */
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
   * @param name the name of the value to convert (e.g. property name).
   * @return the original {@code name} or a mapped variant. See {@link #mapName(String, String)} for details.
   * @see #mapName(String, String)
   */
  default String mapName(String name) {

    return mapName(name, DEFAULT_SEPARATOR);
  }

  /**
   * @param name the name of the value to convert (e.g. property name).
   * @param separator the separator to use. Should typically be {@link #DEFAULT_SEPARATOR}.
   * @return the original {@code name} or a mapped variant. In case of {@link #next() decomposition of composite types}
   *         the name for each decomposed segment has to be unique in some contexts (e.g. as database column). Therefore
   *         if you create a {@link #next() decomposing} {@link TypeMapper} each segment map to a unique name. We
   *         strongly recommend to append a suffix starting with the given separator followed by a short but expressive
   *         segment name. A {@link TypeMapper} for {@code MonetaryAmount} could map the {@code name} "price" to
   *         "price$value" with a {@link #getTargetType() target type} of {@link Number} or {@link java.math.BigDecimal}
   *         having a {@link #next() next}
   */
  default String mapName(String name, String separator) {

    return name;
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
   * @param source the Java value to decompose.
   * @return the SQL value to store in the column represented by this type.
   */
  T toTarget(S source);

  /**
   * This method converts back from the {@link #getTargetType() target type} to the {@link #getSourceType() source
   * type}.<br>
   * <b>ATTENTION:</b> This method may only be used for atomic {@link TypeMapper}s. For {@link #next() composite}
   * {@link TypeMapper} use {@link #with(Builder, Object)} or {@link #toSource(Object...)}.
   *
   * @param target the value of the {@link #getTargetType() target type} to convert.
   * @return the converted {@link #getSourceType() source} value.
   */
  @SuppressWarnings("unchecked")
  default S toSource(T target) {

    return (S) target;
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

}
