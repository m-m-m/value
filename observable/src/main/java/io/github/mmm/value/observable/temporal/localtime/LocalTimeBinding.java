/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localtime;

import java.time.LocalTime;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link io.github.mmm.value.observable.Binding} for an {@link LocalTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class LocalTimeBinding extends Binding<LocalTime> implements LocalTimeExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public LocalTimeBinding(Supplier<LocalTime> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
