/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers;

import java.util.function.Supplier;

import net.sf.mmm.value.observable.Binding;
import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link Binding} for a {@link Number} {@link #getValue() value}.
 *
 * @see Binding
 * @see NumberExpression
 *
 * @param <N> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class NumberBinding<N extends Number & Comparable<? super N>> extends Binding<N>
    implements NumberExpression<N> {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public NumberBinding(Supplier<? extends N> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
