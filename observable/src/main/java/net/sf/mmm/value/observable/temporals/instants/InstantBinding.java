package net.sf.mmm.value.observable.temporals.instants;

import java.time.Instant;
import java.util.function.Supplier;

import net.sf.mmm.value.observable.Binding;
import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link net.sf.mmm.value.observable.Binding} for an {@link Instant} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class InstantBinding extends Binding<Instant> implements InstantExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public InstantBinding(Supplier<Instant> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
