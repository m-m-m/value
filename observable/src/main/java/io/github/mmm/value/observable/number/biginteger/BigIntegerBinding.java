package io.github.mmm.value.observable.number.biginteger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;

/// [io.github.mmm.value.observable.Binding] with [BigInteger] [value][#get()].
///
/// @since 1.0.0
public class BigIntegerBinding extends NumberBinding<BigInteger> implements BigIntegerExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#get()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public BigIntegerBinding(Supplier<BigInteger> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /// @param expression the [BigIntegerExpression] to negate.
  /// @return a new [BigIntegerExpression] holding the negation of the [value][#get()] from the given
  ///         [BigIntegerExpression].
  /// @see #expNegate()
  public static BigIntegerExpression negate(BigIntegerExpression expression) {

    return new BigIntegerBinding(() -> negate(expression.get()), expression);
  }

  /// @param expression the [NumberExpression] to convert.
  /// @return the given [NumberExpression] converted to a [BigDecimalExpression].
  public static BigIntegerExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof BigIntegerExpression) {
      return (BigIntegerExpression) expression;
    } else {
      return new BigIntegerBinding(() -> to(expression.get()), expression);
    }
  }

  /// @param expression the [NumberExpression] to add.
  /// @param other the [ObservableValue] to add.
  /// @return a new [BigIntegerExpression] holding the sum of the [value][#get()]s of the first and the second
  ///         given [ObservableValue]s.
  /// @see #expAdd(ObservableBigIntegerValue)
  public static BigIntegerExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> plus(expression, other), expression, other);
  }

  /// @param expression the [NumberExpression] to add.
  /// @param constant the constant [Number] to add.
  /// @return a new [BigIntegerExpression] holding the sum of the [value][#get()] from the given
  ///         [BigIntegerExpression] with the given `constant`.
  /// @see #expAdd(ObservableBigIntegerValue)
  public static BigIntegerExpression add(NumberExpression<?> expression, Number constant) {

    return add(expression, to(constant));
  }

  /// @param expression the [NumberExpression] to add.
  /// @param constant the constant `BigInteger` to add.
  /// @return a new [BigIntegerExpression] holding the sum of the [value][#get()] from the given
  ///         [BigIntegerExpression] with the given `constant`.
  /// @see #expAdd(ObservableBigIntegerValue)
  public static BigIntegerExpression add(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> plus(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to add.
  /// @return a new [BigIntegerExpression] holding the sum of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static BigIntegerExpression addAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> plusAll(observables), observables);
  }

  /// @param expression the [NumberExpression].
  /// @param other the [ObservableValue] to subtract.
  /// @return a new [BigIntegerExpression] holding the difference of the [value][#get()]s of the first and the
  ///         second given [ObservableValue]s.
  /// @see #expSub(ObservableBigIntegerValue)
  public static BigIntegerExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> minus(expression, other), expression, other);
  }

  /// @param expression the [NumberExpression].
  /// @param constant the constant [Number] to subtract.
  /// @return a new [BigIntegerExpression] holding the difference of the [value][#get()] from the given
  ///         [BigIntegerExpression] with the given `constant`.
  /// @see #expSub(ObservableBigIntegerValue)
  public static BigIntegerExpression subtract(NumberExpression<?> expression, Number constant) {

    return subtract(expression, to(constant));
  }

  /// @param expression the [NumberExpression].
  /// @param constant the constant `BigInteger` to subtract.
  /// @return a new [BigIntegerExpression] holding the difference of the [value][#get()] from the given
  ///         [BigIntegerExpression] with the given `constant`.
  /// @see #expSub(ObservableBigIntegerValue)
  public static BigIntegerExpression subtract(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> minus(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to subtract.
  /// @return a new [BigIntegerExpression] holding the difference of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static BigIntegerExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> minusAll(observables), observables);
  }

  /// @param expression the [NumberExpression].
  /// @param other the [ObservableValue] to multiply.
  /// @return a new [BigIntegerExpression] holding the product of the [value][#get()]s of the first and the
  ///         second given [ObservableValue]s.
  /// @see #expMul(ObservableBigIntegerValue)
  public static BigIntegerExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> mul(expression, other), expression, other);
  }

  /// @param expression the [NumberExpression].
  /// @param constant the constant [Number] to multiply.
  /// @return a new [BigIntegerExpression] holding the product of the [value][#get()] from the given
  ///         [BigIntegerExpression] multiplied with the given `constant`.
  /// @see #expMul(ObservableBigIntegerValue)
  public static BigIntegerExpression multiply(NumberExpression<?> expression, Number constant) {

    return multiply(expression, to(constant));
  }

  /// @param expression the [NumberExpression].
  /// @param constant the constant `BigInteger` to multiply.
  /// @return a new [BigIntegerExpression] holding the product of the [value][#get()] from the given
  ///         [BigIntegerExpression] multiplied with the given `constant`.
  /// @see #expMul(ObservableBigIntegerValue)
  public static BigIntegerExpression multiply(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> mul(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to multiply.
  /// @return a new [BigIntegerExpression] holding the product of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static BigIntegerExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> mulAll(observables), observables);
  }

  /// @param expression the [NumberExpression].
  /// @param other the [ObservableValue] to divide.
  /// @return a new [BigIntegerExpression] holding the quotient of the [value][#get()]s of the first and the
  ///         second given [ObservableValue]s.
  /// @see #expDiv(ObservableBigIntegerValue)
  public static BigIntegerExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> div(expression, other), expression, other);
  }

  /// @param expression the [NumberExpression].
  /// @param constant the constant [Number] to divide.
  /// @return a new [BigIntegerExpression] holding the quotient of the [value][#get()] from the given
  ///         [BigIntegerExpression] divided by the given `constant`.
  /// @see #expDiv(ObservableBigIntegerValue)
  public static BigIntegerExpression divide(NumberExpression<?> expression, Number constant) {

    return divide(expression, to(constant));
  }

  /// @param expression the [NumberExpression].
  /// @param constant the constant `BigInteger` to divide.
  /// @return a new [BigIntegerExpression] holding the quotient of the [value][#get()] from the given
  ///         [BigIntegerExpression] divided by the given `constant`.
  /// @see #expDiv(ObservableBigIntegerValue)
  public static BigIntegerExpression divide(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> div(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to divide.
  /// @return a new [BigIntegerExpression] holding the quotient of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static BigIntegerExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> divAll(observables), observables);
  }

  private static BigInteger to(Number value) {

    if (value == null) {
      return BigInteger.ZERO;
    } else if (value instanceof BigDecimal) {
      return ((BigDecimal) value).toBigInteger();
    } else if (value instanceof BigInteger) {
      return (BigInteger) value;
    } else {
      return BigInteger.valueOf(value.longValue());
    }
  }

  private static BigInteger negate(BigInteger value) {

    if (value == null) {
      return null;
    }
    return value.negate();
  }

  @SafeVarargs
  private static BigInteger plusAll(ReadableValue<? extends Number>... observables) {

    BigInteger sum = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (sum == null) {
        sum = to(ReadableValue.get(observable));
      } else if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          sum = sum.add(to(value));
        }
      }
    }
    if (sum == null) {
      sum = BigInteger.ONE;
    }
    return sum;
  }

  private static BigInteger plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.get(v2), to(ReadableValue.get(v1)));
  }

  private static BigInteger plus(Number v1, BigInteger v2) {

    if (v2 == null) {
      return to(v1);
    } else if (v1 == null) {
      return v2;
    }
    return to(v1).add(v2);
  }

  @SafeVarargs
  private static BigInteger minusAll(ReadableValue<? extends Number>... observables) {

    BigInteger difference = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (difference == null) {
        difference = to(ReadableValue.get(observable));
      } else if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          difference = difference.subtract(to(value));
        }
      }
    }
    if (difference == null) {
      difference = BigInteger.ZERO;
    }
    return difference;
  }

  private static BigInteger minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.get(v1), to(ReadableValue.get(v2)));
  }

  private static BigInteger minus(Number v1, BigInteger v2) {

    if (v2 == null) {
      return to(v1);
    } else if (v1 == null) {
      return v2.negate();
    }
    return to(v1).subtract(v2);
  }

  @SafeVarargs
  private static BigInteger mulAll(ReadableValue<? extends Number>... observables) {

    BigInteger product = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return BigInteger.ZERO;
      }
      Number value = observable.get();
      if (value == null) {
        return BigInteger.ZERO;
      }
      if (product == null) {
        product = to(value);
      } else {
        product = product.multiply(to(value));
      }
    }
    if (product == null) {
      product = BigInteger.ONE;
    }
    return product;
  }

  private static BigInteger mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.get(v2), to(ReadableValue.get(v1)));
  }

  private static BigInteger mul(Number v1, BigInteger v2) {

    if ((v2 == null) || (v1 == null)) {
      return BigInteger.ZERO;
    }
    return to(v1).multiply(v2);
  }

  @SafeVarargs
  private static BigInteger divAll(ReadableValue<? extends Number>... observables) {

    BigInteger quotient = null;
    for (ReadableValue<? extends Number> observable : observables) {
      BigInteger arg = BigInteger.ZERO;
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          arg = to(value);
        }
      }
      if (quotient == null) {
        quotient = arg;
      } else {
        quotient = quotient.divide(arg);
      }
    }
    if (quotient == null) {
      quotient = BigInteger.ONE;
    }
    return quotient;
  }

  private static BigInteger div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.get(v1), to(ReadableValue.get(v2)));
  }

  private static BigInteger div(Number v1, BigInteger v2) {

    if (v1 == null) {
      return BigInteger.ZERO;
    } else if (v2 == null) {
      v2 = BigInteger.ZERO;
    }
    return to(v1).divide(v2);
  }

}
