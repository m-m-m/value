package io.github.mmm.value.converter;

/**
 * Extends {@link TypedValueConverter} for bidirectional converting.
 *
 * @param <S> type of the source value.
 * @param <T> type of the target value.
 * @since 1.0.0
 */
public interface ValueMapper<S, T> extends TypedValueConverter<S, T> {

  /**
   * Inverse operation of {@link #toTarget(Object)}.
   *
   * @param targetValue the target value to convert. May be {@code null}.
   * @return the given {@code targetValue} converted to the source type.
   */
  S toSource(T targetValue);

}
