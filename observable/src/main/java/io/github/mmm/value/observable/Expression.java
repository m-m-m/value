/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

import java.util.Objects;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.booleans.BooleanExpression;
import io.github.mmm.value.observable.string.StringBinding;
import io.github.mmm.value.observable.string.StringExpression;

/// An [Expression] is an [ObservableValue] providing convenience methods to created dynamically computed
/// values.
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface Expression<V> extends ObservableValue<V> {

  /// @param other the [ObservableValue] to check.
  /// @return a new [BooleanBinding] holding `true` if the [value][#get()] of this [Expression]
  ///         and the [value][ObservableValue#get()] of the given [ObservableValue] are
  ///         [equal][Object#equals(Object)].
  default BooleanExpression expEq(ObservableValue<V> other) {

    return new BooleanBinding(() -> Objects.equals(get(), other.get()), this, other);
  }

  /// @param other the constant value to check.
  /// @return a new [BooleanBinding] holding `true` if the [value][#get()] of this property and the
  ///         given `value` are [equal][Object#equals(Object)].
  default BooleanExpression expEq(V other) {

    return new BooleanBinding(() -> Objects.equals(get(), other), this);
  }

  /// @param other the [ObservableValue] to check.
  /// @return a new [BooleanBinding] holding `true` if the [value][#get()] of this property and the
  ///         [value][ObservableValue#get()] of the given [ObservableValue] are NOT
  ///         [equal][Object#equals(Object)].
  default BooleanExpression expNeq(ObservableValue<V> other) {

    return new BooleanBinding(() -> !Objects.equals(get(), other.get()), this, other);
  }

  /// @param other the constant value to check.
  /// @return a new [BooleanBinding] holding `true` if the [value][#get()] of this property and the
  ///         given `value` are NOT [equal][Object#equals(Object)].
  default BooleanExpression expNeq(V other) {

    return new BooleanBinding(() -> !Objects.equals(get(), other), this);
  }

  /// @return a new [BooleanBinding] holding `true` if the [value][#get()] of this property is
  ///         `null`.
  default BooleanExpression expNull() {

    return new BooleanBinding(() -> (get() == null), this);
  }

  /// @return a new [BooleanBinding] holding `true` if the [value][#get()] of this property is NOT
  ///         `null`.
  default BooleanExpression expNotNull() {

    return new BooleanBinding(() -> (get() != null), this);
  }

  /// @return a new `StringBinding` holding the [String-repersentation][Object#toString()] of the
  ///         [value][#get()].
  default StringExpression expString() {

    return new StringBinding(() -> Objects.toString(get()), this);
  }

  /// Called if this `Expression` will not be used anymore and any references can be removed. Any
  /// [ObservableEventListener] [added][ObservableValue#addListener(io.github.mmm.event.EventListener)] to
  /// dependent [ObservableValue]s will be [removed][ObservableValue#removeListener(io.github.mmm.event.EventListener)].
  default void dispose() {

  }

}
