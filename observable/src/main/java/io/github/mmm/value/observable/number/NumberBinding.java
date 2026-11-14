/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number;

import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [Binding] for a [Number] [value][#get()].
///
/// @see Binding
/// @see NumberExpression
///
/// @param <N> type of the observable [value][#get()].
/// @since 1.0.0
public abstract class NumberBinding<N extends Number & Comparable<? super N>> extends Binding<N>
    implements NumberExpression<N> {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#get()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public NumberBinding(Supplier<? extends N> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
