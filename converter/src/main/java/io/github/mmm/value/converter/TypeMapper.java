package io.github.mmm.value.converter;

import io.github.mmm.base.lang.Builder;

/// Interface to convert or decompose a [source type][#getSourceType()] to a [target type][#getTargetType()] and
/// vice-versa.
///
/// @param <S> the [source type][#getSourceType()].
/// @param <T> the [target type][#getTargetType()].
/// @since 1.0.0
public interface TypeMapper<S, T> {

  /// The default separator for [name mapping][NameMode#format(String, String)]. It would be more natural to use "." but
  /// unfortunately this is not accepted in column names of common database products. Other common separators like "_"
  /// are likely to clash with other convenient naming. Therefore, we need to use something that is reserved or specific
  /// enough not to be used in regular names but is still accepted by all databases.
  String DEFAULT_SEPARATOR = "$";

  /// @return the [Class] reflecting the source type to convert or decompose.
  Class<? extends S> getSourceType();

  /// @return the [Class] reflecting the target type to convert to.
  Class<? extends T> getTargetType();

  /// @return the suffix to [append to the name][NameMode#format(String, String)]. Will be the empty [String] for
  ///         no suffix.
  default String getSuffix() {

    return "";
  }

  /// @return the [NameMode] of this mapper.
  default NameMode getNameMode() {

    return NameMode.NORMAL;
  }

  /// @return the (optional) declaration for this type [segment][#next()] (e.g. SQL type declaration such
  ///         as "NUMBER(30,10").
  default String getDeclaration() {

    return "";
  }

  /// @return `true` if a non-[empty][String#isEmpty()] [declaration][#getDeclaration()] is present, `false` otherwise.
  default boolean hasDeclaration() {

    String declaration = getDeclaration();
    return (declaration != null) && !declaration.isEmpty();
  }

  /// @param source the value of the [source type][#getSourceType()] to convert. Must not be `null`. For `null` values
  ///        use [#toTargetNull()] instead.
  /// @return the `source` value converted to the [target type][#getTargetType()].
  T toTarget(S source);

  /// @return the representation of `null` for the [target type][#getTargetType()] (typically `null`).
  default T toTargetNull() {

    return null;
  }

  /// This method converts back from the [target type][#getTargetType()] to the [source type][#getSourceType()].
  /// **ATTENTION:** This method may only be used for atomic [TypeMapper]s. For [composite][#next()] [TypeMapper] use
  /// [#with(Builder, Object)] or [#toSource(Object...)].
  ///
  /// @param target the value of the [target type][#getTargetType()] to convert. Must not be `null`. For `null` values
  ///        use [#toSourceNull()] instead.
  /// @return the `target` value converted to the [source type][#getSourceType()].
  @SuppressWarnings("unchecked")
  default S toSource(T target) {

    return (S) target;
  }

  /// @return the representation of `null` for the [source type][#getSourceType()] (typically `null`).
  default S toSourceNull() {

    return null;
  }

  /// @return a new [Builder] to [build][Builder#build()] the [source type][#getSourceType()].
  /// @see #with(Builder, Object)
  default Builder<S> sourceBuilder() {

    return null;
  }

  /// Applies a given `targetSegment` to the [source builder][#sourceBuilder()].
  ///
  /// @param builder the [source builder][#sourceBuilder()].
  /// @param targetSegment the [target][#getTargetType()] [segment][#next()] value.
  default void with(Builder<S> builder, T targetSegment) {

  }

  /// This method converts back from the [target type][#getTargetType()] to the [source type][#getSourceType()] with
  /// support for composition out of [segment][#next()]s. **ATTENTION:** Due to performance optimisation this method
  /// shall only be used for [composite][#next()] [TypeMapper]s. You may override this method to avoid
  /// [Builder] overhead. For atomic types use [#toSource(Object)].
  ///
  /// @param segments the [segment][#next()]s to compose.
  /// @return the converted or composed [source][#getSourceType()] value.
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

  /// @return the optional next [TypeMapper] in case of a composite [source type][#getSourceType()] that shall be
  ///         decomposed into individual [target][#getTargetType()] segments. For each segment you can iterate via this
  ///         method until the last segment that will return `null`. If already the first [TypeMapper] returns `null`
  ///         here, the [source type][#getSourceType()] will not be decomposed.
  default TypeMapper<S, ?> next() {

    return null;
  }

  public static enum NameMode {

    /// Use the name followed by [separator][TypeMapper#DEFAULT_SEPARATOR] and the [suffix][TypeMapper#getSuffix()]. If
    /// [suffix][TypeMapper#getSuffix()] is empty only use name.
    NORMAL() {

      @Override
      public String format(String name, String suffix, String separator) {

        if ((suffix == null) || suffix.isEmpty()) {
          return name;
        }
        return name + separator + suffix;
      }
    },

    /// Use the name only and ignore the [suffix][TypeMapper#getSuffix()].
    NAME() {

      @Override
      public String format(String name, String suffix, String separator) {

        return name;
      }
    },

    /// Use the [suffix][TypeMapper#getSuffix()] only and ignore the name.
    SUFFIX() {

      @Override
      public String format(String name, String suffix, String separator) {

        assert !suffix.isEmpty();
        return suffix;
      }
    };

    /// @param name the name to format (e.g. name of property or database column).
    /// @param suffix the [suffix][TypeMapper#getSuffix()].
    /// @return the original `name` or a mapped variant. E.g. for [#NORMAL] the result of
    ///         [format("Range", "Min")][#format(String, String)] would be "Range$Min".
    public String format(String name, String suffix) {

      return format(name, suffix, DEFAULT_SEPARATOR);
    }

    /// @param name the name to format (e.g. name of property or database column).
    /// @param suffix the [suffix][TypeMapper#getSuffix()].
    /// @param separator the explicit [separator][TypeMapper#DEFAULT_SEPARATOR] to use.
    /// @return the original `name` or a mapped variant. E.g. for [#NORMAL] the result of
    ///         [format("Range", "Min")][#format(String, String)] would be "Range$Min".
    public abstract String format(String name, String suffix, String separator);

  }

}
