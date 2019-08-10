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
 * {@link net.sf.mmm.value.observable.Binding} for a {@link BigInteger} {@link #getValue() value}.
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
  public static BigIntegerExpression sum(ObservableValue<? extends Number>... observables) {

    return new BigIntegerBinding(() -> plusAll(observables), observables);
  }

  private static BigInteger to(Number value) {

    if (value == null) {
      return null;
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

  private static BigInteger plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(to(ReadableValue.unwrap(v1)), ReadableValue.unwrap(v2));
  }

  private static BigInteger plus(BigInteger v1, Number v2) {

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

}
