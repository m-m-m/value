package net.sf.mmm.value.observable.numbers.bigintegers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigdecimals.BigDecimalExpression;

/**
 * {@link net.sf.mmm.value.observable.Binding} with {@link BigInteger} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class BigIntegerBinding extends NumberBinding<BigInteger> implements BigIntegerExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public BigIntegerBinding(Supplier<BigInteger> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link BigIntegerExpression} to negate.
   * @return a new {@link BigIntegerExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression}.
   * @see #negate()
   */
  public static BigIntegerExpression negate(BigIntegerExpression expression) {

    return new BigIntegerBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link BigDecimalExpression}.
   */
  public static BigIntegerExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof BigIntegerExpression) {
      return (BigIntegerExpression) expression;
    } else {
      return new BigIntegerBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link NumberExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link BigIntegerExpression} holding the sum of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #add(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link BigIntegerExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} with the given {@code constant}.
   * @see #add(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression add(NumberExpression<?> expression, Number constant) {

    return add(expression, to(constant));
  }

  /**
   * @param expression the {@link NumberExpression} to add.
   * @param constant the constant {@code BigInteger} to add.
   * @return a new {@link BigIntegerExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} with the given {@code constant}.
   * @see #add(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression add(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link BigIntegerExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigIntegerExpression addAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link BigIntegerExpression} holding the difference of the {@link #getValue() value}s of the first
   *         and the second given {@link ObservableValue}s.
   * @see #subtract(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link BigIntegerExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} with the given {@code constant}.
   * @see #subtract(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression subtract(NumberExpression<?> expression, Number constant) {

    return subtract(expression, to(constant));
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@code BigInteger} to subtract.
   * @return a new {@link BigIntegerExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} with the given {@code constant}.
   * @see #subtract(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression subtract(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> minus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link BigIntegerExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigIntegerExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link BigIntegerExpression} holding the product of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #multiply(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link BigIntegerExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression multiply(NumberExpression<?> expression, Number constant) {

    return multiply(expression, to(constant));
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@code BigInteger} to multiply.
   * @return a new {@link BigIntegerExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression multiply(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> mul(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link BigIntegerExpression} holding the product of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigIntegerExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link BigIntegerExpression} holding the quotient of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #divide(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigIntegerBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link BigIntegerExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} divided by the given {@code constant}.
   * @see #divide(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression divide(NumberExpression<?> expression, Number constant) {

    return divide(expression, to(constant));
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@code BigInteger} to divide.
   * @return a new {@link BigIntegerExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link BigIntegerExpression} divided by the given {@code constant}.
   * @see #divide(ObservableBigIntegerValue)
   */
  public static BigIntegerExpression divide(NumberExpression<?> expression, BigInteger constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigIntegerBinding(() -> div(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link BigIntegerExpression} holding the quotient of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
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
        sum = to(ReadableValue.unwrap(observable));
      } else if (observable != null) {
        Number value = observable.getValue();
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

    return plus(to(ReadableValue.unwrap(v1)), ReadableValue.unwrap(v2));
  }

  private static BigInteger plus(BigInteger v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return v1;
    }
    return v1.add(to(v2));
  }

  @SafeVarargs
  private static BigInteger minusAll(ReadableValue<? extends Number>... observables) {

    BigInteger difference = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (difference == null) {
        difference = to(ReadableValue.unwrap(observable));
      } else if (observable != null) {
        Number value = observable.getValue();
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

    return minus(to(ReadableValue.unwrap(v1)), ReadableValue.unwrap(v2));
  }

  private static BigInteger minus(BigInteger v1, Number v2) {

    if (v1 == null) {
      return to(v2).negate();
    } else if (v2 == null) {
      return v1;
    }
    return v1.subtract(to(v2));
  }

  @SafeVarargs
  private static BigInteger mulAll(ReadableValue<? extends Number>... observables) {

    BigInteger product = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return BigInteger.ZERO;
      }
      Number value = observable.getValue();
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

    return mul(to(ReadableValue.unwrap(v1)), ReadableValue.unwrap(v2));
  }

  private static BigInteger mul(BigInteger v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return BigInteger.ZERO;
    }
    return v1.multiply(to(v2));
  }

  @SafeVarargs
  private static BigInteger divAll(ReadableValue<? extends Number>... observables) {

    BigInteger quotient = null;
    for (ReadableValue<? extends Number> observable : observables) {
      BigInteger arg = BigInteger.ZERO;
      if (observable != null) {
        Number value = observable.getValue();
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

    return div(to(ReadableValue.unwrap(v1)), ReadableValue.unwrap(v2));
  }

  private static BigInteger div(BigInteger v1, Number v2) {

    if (v1 == null) {
      v1 = BigInteger.ZERO;
    }
    return v1.divide(to(v2));
  }

}
