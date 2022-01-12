package io.github.mmm.value.converter;

/**
 * {@link ValueConverter} with {@link #getTargetType() target type}.
 *
 * @param <S> type of the source value.
 * @param <T> type of the target value.
 * @since 1.0.0
 */
public interface TypedValueConverter<S, T> extends ValueConverter<S, T> {

  /**
   * @return the {@link Class} reflecting the target type to convert to.
   */
  Class<? extends T> getTargetType();

}
