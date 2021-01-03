package io.github.mmm.value.observable.pattern;

import java.util.function.Supplier;
import java.util.regex.Pattern;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link Binding} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class PatternBinding extends Binding<Pattern> implements PatternExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public PatternBinding(Supplier<Pattern> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
