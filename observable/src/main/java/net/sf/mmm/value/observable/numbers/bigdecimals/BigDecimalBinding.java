package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link net.sf.mmm.value.observable.Binding} with {@link BigDecimal} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class BigDecimalBinding extends NumberBinding<BigDecimal> implements BigDecimalExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public BigDecimalBinding(Supplier<BigDecimal> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link BigDecimalExpression} to negate.
   * @return a new {@link BigDecimalExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression}.
   * @see #negate()
   */
  public static BigDecimalExpression negate(BigDecimalExpression expression) {

    return new BigDecimalBinding(() -> negate(expression.getValue()), expression);
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
      return new BigDecimalBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link BigDecimalExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #add(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> plusAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #add(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression add(NumberExpression<?> expression, Number constant) {

    return add(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression} to add.
   * @param constant the constant {@code BigDecimal} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #add(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression add(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link BigDecimalExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression addAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #getValue() value}s of the first
   *         and the second given {@link ObservableValue}s.
   * @see #subtract(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> minusAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #subtract(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression subtract(NumberExpression<?> expression, Number constant) {

    return subtract(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param constant the constant {@code BigDecimal} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression} with the given {@code constant}.
   * @see #subtract(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression subtract(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> minus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #multiply(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new BigDecimalBinding(() -> mulAll(expression, other), expression, other);
  }

  /**
   * @param expression the {@link NumberExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression multiply(NumberExpression<?> expression, Number constant) {

    return multiply(expression, to(constant));
  }

  /**
   * @param expression the {@link BigDecimalExpression}.
   * @param constant the constant {@code BigDecimal} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link BigDecimalExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableBigDecimalValue)
   */
  public static BigDecimalExpression multiply(NumberExpression<?> expression, BigDecimal constant) {

    if (constant == null) {
      return cast(expression);
    }
    Objects.requireNonNull(expression, "expression");
    return new BigDecimalBinding(() -> mul(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static BigDecimalExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new BigDecimalBinding(() -> mulAll(observables), observables);
  }

  private static BigDecimal to(Number value) {

    if (value == null) {
      return null;
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

    BigDecimal sum = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (sum == null) {
            sum = to(value);
          } else {
            sum = sum.add(to(value));
          }
        }
      }
    }
    return sum;
  }

  private static BigDecimal plus(BigDecimal v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return v1;
    }
    return v1.add(to(v2));
  }

  @SafeVarargs
  private static BigDecimal minusAll(ReadableValue<? extends Number>... observables) {

    BigDecimal difference = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (difference == null) {
            difference = BigDecimal.ZERO;
          }
          difference = difference.subtract(to(value));
        }
      }
    }
    return difference;
  }

  private static BigDecimal minus(BigDecimal v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return v1;
    }
    return v1.subtract(to(v2));
  }

  @SafeVarargs
  private static BigDecimal mulAll(ReadableValue<? extends Number>... observables) {

    BigDecimal product = null;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (product == null) {
            product = BigDecimal.ONE;
          }
          product = product.multiply(to(value));
        }
      }
    }
    return product;
  }

  private static BigDecimal mul(BigDecimal v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return v1;
    }
    return v1.multiply(to(v2));
  }

}
