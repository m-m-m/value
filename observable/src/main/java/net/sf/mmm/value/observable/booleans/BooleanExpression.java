/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.booleans;

import net.sf.mmm.value.observable.Expression;
import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link Expression} with {@link Boolean} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface BooleanExpression extends ObservableBooleanValue, Expression<Boolean> {

  /**
   * @return a new {@code BooleanExpression} holding the negation of this {@link #getValue() value}.
   */
  default BooleanExpression not() {

    return BooleanBinding.not(this);
  }

  /**
   * @param other the other {@code ObservableValue}.
   * @return the new {@code BooleanExpression} holding the logical AND of the {@link #getValue() value}s from this
   *         {@link BooleanExpression} and the given {@link ObservableValue}.
   */
  default BooleanExpression and(ObservableValue<Boolean> other) {

    return BooleanBinding.and(this, other);
  }

  /**
   * @param constant the constant {@link Boolean} value.
   * @return a new {@code BooleanExpression} holding the logical AND of this {@link #getValue() value} and the given
   *         {@code constant} value.
   */
  default BooleanExpression and(Boolean constant) {

    return BooleanBinding.and(this, constant);
  }

  /**
   * @param other the other {@code ObservableValue}.
   * @return the new {@code BooleanExpression} holding the logical OR of this {@link #getValue() value} and the given
   *         {@code other}s value.
   */
  default BooleanExpression or(ObservableValue<Boolean> other) {

    return BooleanBinding.or(this, other);
  }

  /**
   * @param constant the constant {@link Boolean} value.
   * @return the new {@code BooleanExpression} holding the logical OR of the {@link #getValue() value}s from this
   *         {@link BooleanExpression} and the given {@code constant} value.
   */
  default BooleanExpression or(Boolean constant) {

    return BooleanBinding.or(this, constant);
  }

}
