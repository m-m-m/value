/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.booleans;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.Binding;
import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link Binding} for a {@link Boolean} {@link #getValue() value}.
 *
 * @see Binding
 * @see BooleanExpression
 *
 * @since 1.0.0
 */
public class BooleanBinding extends Binding<Boolean> implements BooleanExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public BooleanBinding(Supplier<? extends Boolean> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link BooleanExpression}.
   * @return a new {@code BooleanExpression} holding the negation of this {@link #getValue() value}.
   */
  public static BooleanExpression not(BooleanExpression expression) {

    return new BooleanBinding(() -> not(ReadableValue.unwrap(expression)), expression);
  }

  /**
   * @param expression the {@link BooleanExpression}.
   * @param other the {@code ObservableValue}.
   * @return a new {@code BooleanExpression} holding the logical AND of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   * @see #and(ObservableValue)
   */
  public static BooleanExpression and(BooleanExpression expression, ObservableValue<Boolean> other) {

    if (other == null) {
      return expression;
    }
    return new BooleanBinding(() -> and(ReadableValue.unwrap(expression), ReadableValue.unwrap(other)), expression,
        other);
  }

  /**
   * @param expression the {@link BooleanExpression}.
   * @param constant the constant {@link Boolean} value.
   * @return a new {@code BooleanExpression} holding the logical AND of the {@link #getValue() value} from the given
   *         {@link BooleanExpression} and the given {@code constant} value.
   */
  public static BooleanExpression and(BooleanExpression expression, Boolean constant) {

    if (constant == null) {
      return expression;
    }
    return new BooleanBinding(() -> and(ReadableValue.unwrap(expression), constant), expression);
  }

  /**
   * @param expression the {@link BooleanExpression}.
   * @param other the other {@code ObservableValue}.
   * @return a new {@code BooleanExpression} holding the logical OR of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  public static BooleanExpression or(BooleanExpression expression, ObservableValue<Boolean> other) {

    if (other == null) {
      return expression;
    }
    return new BooleanBinding(() -> or(ReadableValue.unwrap(expression), ReadableValue.unwrap(other)), expression,
        other);
  }

  /**
   * @param expression the {@link BooleanExpression}.
   * @param other the constant {@link Boolean} value.
   * @return a new {@code BooleanExpression} holding the logical OR of the {@link #getValue() value} from the given
   *         {@link BooleanExpression} and the given {@code constant} value.
   */
  public static BooleanExpression or(BooleanExpression expression, Boolean other) {

    if (other == null) {
      return expression;
    }
    return new BooleanBinding(() -> or(ReadableValue.unwrap(expression), other), expression);
  }

  private static boolean get(Boolean value) {

    if (value == null) {
      return false;
    }
    return value.booleanValue();
  }

  private static Boolean and(Boolean v1, Boolean v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    return Boolean.valueOf(get(v1) && get(v2));
  }

  private static Boolean or(Boolean v1, Boolean v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    return Boolean.valueOf(get(v1) || get(v2));
  }

  private static Boolean not(Boolean value) {

    if (value == null) {
      return null;
    }
    return Boolean.valueOf(!value.booleanValue());
  }
}
