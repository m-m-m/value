package io.github.mmm.value.observable.string;

import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link Binding} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class StringBinding extends Binding<String> implements StringExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public StringBinding(Supplier<String> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
