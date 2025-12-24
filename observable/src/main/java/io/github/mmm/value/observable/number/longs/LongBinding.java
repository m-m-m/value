package io.github.mmm.value.observable.number.longs;

import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;

/**
 * {@link NumberBinding} with {@link Long} {@link #get() value}.
 *
 * @since 1.0.0
 */
public class LongBinding extends NumberBinding<Long> implements LongExpression {

  private static final Long ZERO = Long.valueOf(0);

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #get() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public LongBinding(Supplier<Long> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link LongExpression} to negate.
   * @return a new {@link LongExpression} holding the negation of the {@link #get() value} from the given
   *         {@link LongExpression}.
   * @see #expNegate()
   */
  public static LongExpression negate(LongExpression expression) {

    return new LongBinding(() -> negate(expression.get()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link LongExpression}.
   */
  public static LongExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof LongExpression) {
      return (LongExpression) expression;
    } else {
      return new LongBinding(() -> to(expression.get()), expression);
    }
  }

  /**
   * @param expression the {@link LongExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #get() value}s of the first and the second given
   *         {@link ObservableValue}s.
   * @see #expAdd(ObservableLongValue)
   */
  public static LongExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new LongBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link LongExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #get() value} from the given
   *         {@link LongExpression} with the given {@code constant}.
   * @see #expAdd(ObservableLongValue)
   */
  public static LongExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.longValue());
  }

  /**
   * @param expression the {@link LongExpression} to add.
   * @param constant the constant {@code long} to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #get() value} from the given
   *         {@link LongExpression} with the given {@code constant}.
   * @see #expAdd(ObservableLongValue)
   */
  public static LongExpression add(NumberExpression<?> expression, long constant) {

    return new LongBinding(() -> plus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static LongExpression addAll(ObservableValue<? extends Number>... observables) {

    return new LongBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link LongExpression} holding the difference of the {@link #get() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #expSub(ObservableLongValue)
   */
  public static LongExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new LongBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link LongExpression} holding the difference of the {@link #get() value} from the given
   *         {@link LongExpression} with the given {@code constant}.
   * @see #expSub(ObservableLongValue)
   */
  public static LongExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.longValue());
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param constant the constant {@code long} to subtract.
   * @return a new {@link LongExpression} holding the difference of the {@link #get() value} from the given
   *         {@link LongExpression} with the given {@code constant}.
   * @see #expSub(ObservableLongValue)
   */
  public static LongExpression subtract(NumberExpression<?> expression, long constant) {

    return new LongBinding(() -> minus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link LongExpression} holding the difference of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static LongExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new LongBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link LongExpression} holding the product of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expMul(ObservableLongValue)
   */
  public static LongExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new LongBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link LongExpression} holding the product of the {@link #get() value} from the given
   *         {@link LongExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableLongValue)
   */
  public static LongExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.longValue());
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param constant the constant {@code long} to multiply.
   * @return a new {@link LongExpression} holding the product of the {@link #get() value} from the given
   *         {@link LongExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableLongValue)
   */
  public static LongExpression multiply(NumberExpression<?> expression, long constant) {

    return new LongBinding(() -> mul(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link LongExpression} holding the product of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static LongExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new LongBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link LongExpression} holding the quotient of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expDiv(ObservableLongValue)
   */
  public static LongExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new LongBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link LongExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link LongExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableLongValue)
   */
  public static LongExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.longValue());
  }

  /**
   * @param expression the {@link LongExpression}.
   * @param constant the constant {@code long} to divide.
   * @return a new {@link LongExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link LongExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableLongValue)
   */
  public static LongExpression divide(NumberExpression<?> expression, long constant) {

    return new LongBinding(() -> div(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link LongExpression} holding the quotient of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static LongExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new LongBinding(() -> divAll(observables), observables);
  }

  private static Long to(Number value) {

    if (value == null) {
      return ZERO;
    } else if (value instanceof Long) {
      return (Long) value;
    } else {
      return Long.valueOf(value.longValue());
    }
  }

  private static Long negate(Long value) {

    if (value == null) {
      return null;
    }
    return Long.valueOf(-value.longValue());
  }

  @SafeVarargs
  private static Long plusAll(ReadableValue<? extends Number>... observables) {

    long sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          sum = sum + value.longValue();
        }
      }
    }
    return Long.valueOf(sum);
  }

  private static Long plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Long plus(Number v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return to(v1);
    }
    return Long.valueOf(v1.longValue() + v2.longValue());
  }

  private static Long plus(Number v1, long v2) {

    if (v1 != null) {
      v2 = v1.longValue() + v2;
    }
    return Long.valueOf(v2);
  }

  @SafeVarargs
  private static Long minusAll(ReadableValue<? extends Number>... observables) {

    long difference = 0;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          if (first) {
            difference = value.longValue();
          } else {
            difference = difference - value.longValue();
          }
        }
      }
      first = false;
    }
    return Long.valueOf(difference);
  }

  private static Long minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Long minus(Number v1, Number v2) {

    if (v1 == null) {
      if (v2 == null) {
        return ZERO;
      }
      return Long.valueOf(-v2.longValue());
    } else if (v2 == null) {
      return to(v1);
    }
    return Long.valueOf(v1.longValue() - v2.longValue());
  }

  private static Long minus(Number v1, long v2) {

    long l1 = 0;
    if (v1 != null) {
      l1 = v1.longValue();
    }
    return Long.valueOf(l1 - v2);
  }

  @SafeVarargs
  private static Long mulAll(ReadableValue<? extends Number>... observables) {

    long product = 1;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return ZERO;
      }
      Number value = observable.get();
      if (value == null) {
        return ZERO;
      }
      product = product * value.longValue();
    }
    return Long.valueOf(product);
  }

  private static Long mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Long mul(Number v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return ZERO;
    }
    return Long.valueOf(v1.longValue() * v2.longValue());
  }

  private static Long mul(Number v1, long v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Long.valueOf(v2 * v1.longValue());
  }

  @SafeVarargs
  private static Long divAll(ReadableValue<? extends Number>... observables) {

    long quotient = 1;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          if (first) {
            quotient = value.longValue();
          } else {
            quotient = quotient / value.longValue();
          }
        }
      }
      first = false;
    }
    return Long.valueOf(quotient);
  }

  private static Long div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Long div(Number v1, Number v2) {

    if (v1 == null) {
      return ZERO;
    }
    long l2 = 0;
    if (v2 != null) {
      l2 = v2.longValue();
    }
    return Long.valueOf(v1.longValue() / l2);
  }

  private static Long div(Number v1, long v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Long.valueOf(v1.longValue() / v2);
  }

}
