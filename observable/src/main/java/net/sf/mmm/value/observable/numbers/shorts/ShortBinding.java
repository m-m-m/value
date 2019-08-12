package net.sf.mmm.value.observable.numbers.shorts;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link NumberBinding} with {@link Short} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class ShortBinding extends NumberBinding<Short> implements ShortExpression {

  private static final Short ZERO = Short.valueOf((short) 0);

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public ShortBinding(Supplier<Short> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link ShortExpression} to negate.
   * @return a new {@link ShortExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link ShortExpression}.
   * @see #negate()
   */
  public static ShortExpression negate(ShortExpression expression) {

    return new ShortBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link ShortExpression}.
   */
  public static ShortExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof ShortExpression) {
      return (ShortExpression) expression;
    } else {
      return new ShortBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link ShortExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #add(ObservableShortValue)
   */
  public static ShortExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ShortBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ShortExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link ShortExpression} with the given {@code constant}.
   * @see #add(ObservableShortValue)
   */
  public static ShortExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.shortValue());
  }

  /**
   * @param expression the {@link ShortExpression} to add.
   * @param constant the constant {@code short} to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link ShortExpression} with the given {@code constant}.
   * @see #add(ObservableShortValue)
   */
  public static ShortExpression add(NumberExpression<?> expression, short constant) {

    return new ShortBinding(() -> plus(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ShortExpression addAll(ObservableValue<? extends Number>... observables) {

    return new ShortBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link ShortExpression} holding the difference of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #subtract(ObservableShortValue)
   */
  public static ShortExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ShortBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link ShortExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link ShortExpression} with the given {@code constant}.
   * @see #subtract(ObservableShortValue)
   */
  public static ShortExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.shortValue());
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param constant the constant {@code short} to subtract.
   * @return a new {@link ShortExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link ShortExpression} with the given {@code constant}.
   * @see #subtract(ObservableShortValue)
   */
  public static ShortExpression subtract(NumberExpression<?> expression, short constant) {

    return new ShortBinding(() -> minus(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link ShortExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ShortExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new ShortBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link ShortExpression} holding the product of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #multiply(ObservableShortValue)
   */
  public static ShortExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ShortBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link ShortExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link ShortExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableShortValue)
   */
  public static ShortExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.shortValue());
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param constant the constant {@code short} to multiply.
   * @return a new {@link ShortExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link ShortExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableShortValue)
   */
  public static ShortExpression multiply(NumberExpression<?> expression, short constant) {

    return new ShortBinding(() -> mul(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link ShortExpression} holding the product of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ShortExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new ShortBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link ShortExpression} holding the quotient of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #divide(ObservableShortValue)
   */
  public static ShortExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ShortBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link ShortExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link ShortExpression} divided by the given {@code constant}.
   * @see #divide(ObservableShortValue)
   */
  public static ShortExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.shortValue());
  }

  /**
   * @param expression the {@link ShortExpression}.
   * @param constant the constant {@code short} to divide.
   * @return a new {@link ShortExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link ShortExpression} divided by the given {@code constant}.
   * @see #divide(ObservableShortValue)
   */
  public static ShortExpression divide(NumberExpression<?> expression, short constant) {

    return new ShortBinding(() -> div(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link ShortExpression} holding the quotient of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ShortExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new ShortBinding(() -> divAll(observables), observables);
  }

  private static Short to(Number value) {

    if (value == null) {
      return ZERO;
    } else {
      return Short.valueOf(value.shortValue());
    }
  }

  private static Short negate(Short value) {

    if (value == null) {
      return null;
    }
    return Short.valueOf((short) -value.shortValue());
  }

  @SafeVarargs
  private static Short plusAll(ReadableValue<? extends Number>... observables) {

    short sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = (short) (sum + value.shortValue());
        }
      }
    }
    return Short.valueOf(sum);
  }

  private static Short plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Short plus(Number v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return to(v1);
    }
    return Short.valueOf((short) (v1.shortValue() + v2.shortValue()));
  }

  private static Short plus(Number v1, short v2) {

    if (v1 != null) {
      v2 = (short) (v1.shortValue() + v2);
    }
    return Short.valueOf(v2);
  }

  @SafeVarargs
  private static Short minusAll(ReadableValue<? extends Number>... observables) {

    short difference = 0;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (first) {
            difference = value.shortValue();
          } else {
            difference = (short) (difference - value.shortValue());
          }
        }
      }
      first = false;
    }
    return Short.valueOf(difference);
  }

  private static Short minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Short minus(Number v1, Number v2) {

    if (v1 == null) {
      if (v2 == null) {
        return ZERO;
      }
      return Short.valueOf((short) -v2.shortValue());
    } else if (v2 == null) {
      return to(v1);
    }
    return Short.valueOf((short) (v1.shortValue() - v2.shortValue()));
  }

  private static Short minus(Number v1, short v2) {

    short s1 = 0;
    if (v1 != null) {
      s1 = v1.shortValue();
    }
    return Short.valueOf((short) (s1 - v2));
  }

  @SafeVarargs
  private static Short mulAll(ReadableValue<? extends Number>... observables) {

    short product = 1;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return ZERO;
      }
      Number value = observable.getValue();
      if (value == null) {
        return ZERO;
      }
      product = (short) (product * value.shortValue());
    }
    return Short.valueOf(product);
  }

  private static Short mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Short mul(Number v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return ZERO;
    }
    return Short.valueOf((short) (v1.shortValue() * v2.shortValue()));
  }

  private static Short mul(Number v1, short v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Short.valueOf((short) (v1.shortValue() * v2));
  }

  @SafeVarargs
  private static Short divAll(ReadableValue<? extends Number>... observables) {

    short quotient = 1;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (first) {
            quotient = value.shortValue();
          } else {
            quotient = (short) (quotient / value.shortValue());
          }
        }
      }
      first = false;
    }
    return Short.valueOf(quotient);
  }

  private static Short div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Short div(Number v1, Number v2) {

    if (v1 == null) {
      return ZERO;
    }
    short s2 = 0;
    if (v2 != null) {
      s2 = v2.shortValue();
    }
    return Short.valueOf((short) (v1.shortValue() / s2));
  }

  private static Short div(Number v1, short v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Short.valueOf((short) (v1.shortValue() / v2));
  }

}
