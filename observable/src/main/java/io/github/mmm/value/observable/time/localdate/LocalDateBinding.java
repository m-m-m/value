/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdate;

import java.time.LocalDate;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link io.github.mmm.value.observable.Binding} for an {@link LocalDate} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class LocalDateBinding extends Binding<LocalDate> implements LocalDateExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public LocalDateBinding(Supplier<LocalDate> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
