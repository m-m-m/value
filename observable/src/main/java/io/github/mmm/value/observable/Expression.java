/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

import java.util.Objects;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.booleans.BooleanExpression;
import io.github.mmm.value.observable.string.StringBinding;
import io.github.mmm.value.observable.string.StringExpression;

/**
 * An {@link Expression} is an {@link ObservableValue} providing convenience methods to created dynamically computed
 * values.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface Expression<V> extends ObservableValue<V> {

  /**
   * @param other the {@link ObservableValue} to check.
   * @return a new {@link BooleanBinding} holding {@code true} if the {@link #getValue() value} of this
   *         {@link Expression} and the {@link ObservableValue#getValue() value} of the given {@link ObservableValue}
   *         are {@link Object#equals(Object) equal}.
   */
  default BooleanExpression isEqualTo(ObservableValue<V> other) {

    return new BooleanBinding(() -> Objects.equals(getValue(), other.getValue()), this, other);
  }

  /**
   * @param other the constant value to check.
   * @return a new {@link BooleanBinding} holding {@code true} if the {@link #getValue() value} of this property and the
   *         given {@code value} are {@link Object#equals(Object) equal}.
   */
  default BooleanExpression isEqualTo(V other) {

    return new BooleanBinding(() -> Objects.equals(getValue(), other), this);
  }

  /**
   * @param other the {@link ObservableValue} to check.
   * @return a new {@link BooleanBinding} holding {@code true} if the {@link #getValue() value} of this property and the
   *         {@link ObservableValue#getValue() value} of the given {@link ObservableValue} are NOT
   *         {@link Object#equals(Object) equal}.
   */
  default BooleanExpression isNotEqualTo(ObservableValue<V> other) {

    return new BooleanBinding(() -> !Objects.equals(getValue(), other.getValue()), this, other);
  }

  /**
   * @param other the constant value to check.
   * @return a new {@link BooleanBinding} holding {@code true} if the {@link #getValue() value} of this property and the
   *         given {@code value} are NOT {@link Object#equals(Object) equal}.
   */
  default BooleanExpression isNotEqualTo(V other) {

    return new BooleanBinding(() -> !Objects.equals(getValue(), other), this);
  }

  /**
   * @return a new {@link BooleanBinding} holding {@code true} if the {@link #getValue() value} of this property is
   *         {@code null}.
   */
  default BooleanExpression isNull() {

    return new BooleanBinding(() -> (getValue() == null), this);
  }

  /**
   * @return a new {@link BooleanBinding} holding {@code true} if the {@link #getValue() value} of this property is NOT
   *         {@code null}.
   */
  default BooleanExpression isNotNull() {

    return new BooleanBinding(() -> (getValue() != null), this);
  }

  /**
   * @return a new {@code StringBinding} holding the {@link Object#toString() String-repersentation} of the
   *         {@link #getValue() value}.
   */
  default StringExpression asString() {

    return new StringBinding(() -> Objects.toString(getValue()), this);
  }

  /**
   * Called if this {@code Expression} will not be used anymore and any references can be removed. Any
   * {@link ObservableEventListener} {@link ObservableValue#addListener(io.github.mmm.event.EventListener) added} to
   * dependent {@link ObservableValue}s will be {@link ObservableValue#removeListener(io.github.mmm.event.EventListener)
   * removed}.
   */
  default void dispose() {

  }

}
