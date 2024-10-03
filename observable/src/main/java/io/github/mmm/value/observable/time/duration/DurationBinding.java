package io.github.mmm.value.observable.time.duration;

import java.time.Duration;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link io.github.mmm.value.observable.Binding} for an {@link Duration} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class DurationBinding extends Binding<Duration> implements DurationExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public DurationBinding(Supplier<Duration> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
