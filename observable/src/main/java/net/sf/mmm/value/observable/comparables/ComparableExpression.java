/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.comparables;

import net.sf.mmm.value.observable.Expression;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.booleans.BooleanBinding;

/**
 * {@link Expression} with {@link Comparable} {@link #getValue() value}.
 *
 * @param <V> is the generic type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ComparableExpression<V extends Comparable<? super V>> extends Expression<V> {

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         greater than the {@link #getValue() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding greaterThan(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) > 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         greater than the given {@link String}.
   */
  default BooleanBinding greaterThan(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(getValue(), other) > 0), this);
  }

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         less than the {@link #getValue() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding lessThan(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) < 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         less than the given {@link String}.
   */
  default BooleanBinding lessThan(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(getValue(), other) < 0), this);
  }

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         greater than or equal to the {@link #getValue() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding greaterThanOrEqualTo(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) >= 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         greater than or equal to the given {@link String}.
   */
  default BooleanBinding greaterThanOrEqualTo(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(getValue(), other) >= 0), this);
  }

  /**
   * @param other the {@code ObservableValue<V>} to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         less than the {@link #getValue() value} of another the given {@link ObservableValue}.
   */
  default BooleanBinding lessThanOrEqualTo(ObservableValue<V> other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(this, other) <= 0), this, other);
  }

  /**
   * @param other the constant value to compare.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         less than or equal to the given {@link String}.
   */
  default BooleanBinding lessThanOrEqualTo(V other) {

    return new BooleanBinding(() -> (ComparableHelper.compare(getValue(), other) <= 0), this);
  }

}
