/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdate;

import java.time.LocalDate;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [io.github.mmm.value.observable.Binding] for an [LocalDate] [value][#getValue()].
///
/// @since 1.0.0
public class LocalDateBinding extends Binding<LocalDate> implements LocalDateExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#getValue()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public LocalDateBinding(Supplier<LocalDate> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
