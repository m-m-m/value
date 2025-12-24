package io.github.mmm.value.observable.number.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;

/**
 * {@link io.github.mmm.value.observable.Binding} with {@link BigDecimal} {@link #get() value}.
 *
 * @since 1.0.0
 */
public class BigDecimalBinding extends NumberBinding<BigDecimal> implements BigDecimalExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #get() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public BigDecimalBinding(Supplier<BigDecimal> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link BigDecimalExpression} to negate.
   * @return a new {@link BigDecimalExpression} holding the negation of the {@link #get() value} from the given
   *         {@link BigDecimalExpression}.
   * @see #expNegate()
   */
  public static BigDecimalExpression negate(BigDecimalExpression expression) {

    return new BigDecimalBinding(() -> negate(expression.get()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link BigDecimalExpression}.
   */
  public static BigDecimalExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof BigDecimalExpression) {
      return (BigDecimalExpression) expression;
    } else {
      return new BigDecimalBinding(() -> to(expression.get()), expression);
    }
  }

  /**
   * @param expression the {@link BigDecimalExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expAdd(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expAdd(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> plusAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #expAdd(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression add(NumberExpression<?> expression, Number constant) {

    return expAdd(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression} to add.
   * @param constant the constant {@code BigDecimal} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #expAdd(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expAdd(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> plus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression addAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #get() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #expSub(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expSub(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> minusAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #expSub(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression subtract(NumberExpression<?> expression, Number constant) {

    return expSub(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param constant the constant {@code BigDecimal} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #expSub(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expSub(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> minus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #get() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #expMul(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expMul(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> mulAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression multiply(NumberExpression<?> expression, Number constant) {

    return expMul(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param constant the constant {@code BigDecimal} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expMul(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> mul(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link BigDecimalExpression} holding the quotient of the {@link #get() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #expDiv(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expDiv(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> divAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link BigDecimalExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression divide(NumberExpression<?> expression, Number constant) {

    return expDiv(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param constant the constant {@code BigDecimal} to divide.
   * @return a new {@link BigDecimalExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link BigDecimalExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression expDiv(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> div(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link BigDecimalExpression} holding the quotient of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> divAll(observables), observables);
  }

  private static BigDecimal to(Number value) {

    if (value == null) {
      return BigDecimal.ZERO;
    } else if (value instanceof BigDecimal) {
      return (BigDecimal) value;
    } else if (value instanceof BigInteger) {
      return new BigDecimal((BigInteger) value);
    } else if (value instanceof Long) {
      return BigDecimal.valueOf(value.longValue());
    } else {
      return BigDecimal.valueOf(value.doubleValue());
    }
  }

  private static BigDecimal negate(BigDecimal value) {

    if (value == null) {
      return null;
    }
    return value.negate();
  }

  @SafeVarargs
  private static BigDecimal plusAll(ReadableValue<? extends Number>... observables) {

    BigDecimal sum = BigDecimal.ZERO;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          sum = sum.add(to(value));
        }
      }
    }
    return sum;
  }

  private static BigDecimal plus(Number v1, BigDecimal v2) {

    if (v2 == null) {
      return to(v1);
    } else if (v1 == null) {
      return v2;
    }
    return to(v1).add(v2);
  }

  @SafeVarargs
  private static BigDecimal minusAll(ReadableValue<? extends Number>... observables) {

    BigDecimal difference = null;
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
      difference = BigDecimal.ZERO;
    }
    return difference;
  }

  private static BigDecimal minus(Number v1, BigDecimal v2) {

    if (v2 == null) {
      return to(v1);
    } else if (v1 == null) {
      return v2.negate();
    }
    return to(v1).subtract(v2);
  }

  @SafeVarargs
  private static BigDecimal mulAll(ReadableValue<? extends Number>... observables) {

    BigDecimal product = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return BigDecimal.ZERO;
      }
      Number value = observable.get();
      if (value == null) {
        return BigDecimal.ZERO;
      }
      if (product == null) {
        product = to(value);
      } else {
        product = product.multiply(to(value));
      }
    }
    if (product == null) {
      product = BigDecimal.ONE;
    }
    return product;
  }

  private static BigDecimal mul(Number v1, BigDecimal v2) {

    if ((v2 == null) || (v1 == null)) {
      return BigDecimal.ZERO;
    }
    return to(v1).multiply(v2);
  }

  @SafeVarargs
  private static BigDecimal divAll(ReadableValue<? extends Number>... observables) {

    BigDecimal quotient = null;
    for (ReadableValue<? extends Number> observable : observables) {
      BigDecimal arg = BigDecimal.ZERO;
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
      quotient = BigDecimal.ONE;
    }
    return quotient;
  }

  private static BigDecimal div(Number v1, BigDecimal v2) {

    if (v1 == null) {
      return BigDecimal.ZERO;
    }
    if (v2 == null) {
      v2 = BigDecimal.ZERO;
    }
    return to(v1).divide(v2);
  }

}
