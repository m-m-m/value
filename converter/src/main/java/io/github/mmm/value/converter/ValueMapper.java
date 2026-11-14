package io.github.mmm.value.converter;

/// Extends [TypedValueConverter] for bidirectional converting.
///
/// @param <S> type of the source value.
/// @param <T> type of the target value.
/// @since 1.0.0
public interface ValueMapper<S, T> extends TypedValueConverter<S, T> {

  /// Inverse operation of [#toTarget(Object)].
  ///
  /// @param targetValue the target value to convert. May be `null`.
  /// @return the given `targetValue` converted to the source type.
  S toSource(T targetValue);

}
