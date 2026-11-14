/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdatetime;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [io.github.mmm.value.observable.Binding] for an [LocalDateTime] [value][#getValue()].
///
/// @since 1.0.0
public class LocalDateTimeBinding extends Binding<LocalDateTime> implements LocalDateTimeExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#getValue()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public LocalDateTimeBinding(Supplier<LocalDateTime> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
