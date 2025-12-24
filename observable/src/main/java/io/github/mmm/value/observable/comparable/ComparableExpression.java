/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.comparable;

import io.github.mmm.value.observable.Expression;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.booleans.BooleanBinding;

/**
 * {@link Expression} with {@link Comparable} {@link #get() value}.
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface ComparableExpression<V extends Comparable<? super V>> extends Expression<V> {

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is
   *         greater than the {@link #get() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding expGt(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) > 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is
   *         greater than the given {@link String}.
   */
  default BooleanBinding expGt(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(get(), other) > 0), this);
  }

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is less
   *         than the {@link #get() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding expLt(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) < 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is less
   *         than the given {@link String}.
   */
  default BooleanBinding expLt(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(get(), other) < 0), this);
  }

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is
   *         greater than or equal to the {@link #get() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding expGe(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) >= 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is
   *         greater than or equal to the given {@link String}.
   */
  default BooleanBinding expGe(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(get(), other) >= 0), this);
  }

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is less
   *         than the {@link #get() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding expLe(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) <= 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is less
   *         than or equal to the given {@link String}.
   */
  default BooleanBinding expLe(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(get(), other) <= 0), this);
  }

}
