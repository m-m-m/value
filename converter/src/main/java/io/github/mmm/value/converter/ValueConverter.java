package io.github.mmm.value.converter;

/// Interface to [convert][#toTarget(Object)] a value from a source type to a target type.
///
/// @param <S> type of the source value.
/// @param <T> type of the target value.
/// @since 1.0.0
public interface ValueConverter<S, T> {

  /// @param sourceValue the source value to convert. May be `null`.
  /// @return the given `sourceValue` converted to the target type.
  T toTarget(S sourceValue);

}
