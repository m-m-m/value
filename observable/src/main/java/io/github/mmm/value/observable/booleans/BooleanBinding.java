/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.booleans;

import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [Binding] for a [Boolean] [value][#get()].
///
/// @see Binding
/// @see BooleanExpression
///
/// @since 1.0.0
public class BooleanBinding extends Binding<Boolean> implements BooleanExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#get()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public BooleanBinding(Supplier<? extends Boolean> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /// @param expression the [BooleanExpression].
  /// @return a new `BooleanExpression` holding the negation of this [value][#get()].
  public static BooleanExpression expNot(BooleanExpression expression) {

    return new BooleanBinding(() -> not(ReadableValue.get(expression)), expression);
  }

  /// @param expression the [BooleanExpression].
  /// @param other the `ObservableValue`.
  /// @return a new `BooleanExpression` holding the logical AND of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  /// @see #expAnd(ObservableValue)
  public static BooleanExpression expAnd(BooleanExpression expression, ObservableValue<Boolean> other) {

    if (other == null) {
      return expression;
    }
    return new BooleanBinding(() -> and(ReadableValue.get(expression), ReadableValue.get(other)), expression,
        other);
  }

  /// @param expression the [BooleanExpression].
  /// @param constant the constant [Boolean] value.
  /// @return a new `BooleanExpression` holding the logical AND of the [value][#get()] from the given
  ///         [BooleanExpression] and the given `constant` value.
  public static BooleanExpression expAnd(BooleanExpression expression, Boolean constant) {

    if (constant == null) {
      return expression;
    }
    return new BooleanBinding(() -> and(ReadableValue.get(expression), constant), expression);
  }

  /// @param expression the [BooleanExpression].
  /// @param other the other `ObservableValue`.
  /// @return a new `BooleanExpression` holding the logical OR of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  public static BooleanExpression expOr(BooleanExpression expression, ObservableValue<Boolean> other) {

    if (other == null) {
      return expression;
    }
    return new BooleanBinding(() -> or(ReadableValue.get(expression), ReadableValue.get(other)), expression,
        other);
  }

  /// @param expression the [BooleanExpression].
  /// @param other the constant [Boolean] value.
  /// @return a new `BooleanExpression` holding the logical OR of the [value][#get()] from the given
  ///         [BooleanExpression] and the given `constant` value.
  public static BooleanExpression expOr(BooleanExpression expression, Boolean other) {

    if (other == null) {
      return expression;
    }
    return new BooleanBinding(() -> or(ReadableValue.get(expression), other), expression);
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
