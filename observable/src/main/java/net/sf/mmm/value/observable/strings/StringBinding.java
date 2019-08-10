package net.sf.mmm.value.observable.strings;

import java.util.function.Supplier;

import net.sf.mmm.value.observable.Binding;
import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link net.sf.mmm.value.observable.Binding} for a {@link String} {@link #getValue() value}.
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
