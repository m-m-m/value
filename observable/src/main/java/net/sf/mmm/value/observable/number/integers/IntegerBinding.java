package net.sf.mmm.value.observable.number.integers;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.number.NumberBinding;
import net.sf.mmm.value.observable.number.NumberExpression;

/**
 * {@link NumberBinding} with {@link Integer} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class IntegerBinding extends NumberBinding<Integer> implements IntegerExpression {

  private static final Integer ZERO = Integer.valueOf(0);

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public IntegerBinding(Supplier<Integer> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link IntegerExpression} to negate.
   * @return a new {@link IntegerExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link IntegerExpression}.
   * @see #negate()
   */
  public static IntegerExpression negate(IntegerExpression expression) {

    return new IntegerBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link IntegerExpression}.
   */
  public static IntegerExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof IntegerExpression) {
      return (IntegerExpression) expression;
    } else {
      return new IntegerBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link IntegerExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #add(ObservableIntegerValue)
   */
  public static IntegerExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new IntegerBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link IntegerExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #add(ObservableIntegerValue)
   */
  public static IntegerExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.intValue());
  }

  /**
   * @param expression the {@link IntegerExpression} to add.
   * @param constant the constant {@code int} to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #add(ObservableIntegerValue)
   */
  public static IntegerExpression add(NumberExpression<?> expression, int constant) {

    return new IntegerBinding(() -> plus(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static IntegerExpression addAll(ObservableValue<? extends Number>... observables) {

    return new IntegerBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #subtract(ObservableIntegerValue)
   */
  public static IntegerExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new IntegerBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #subtract(ObservableIntegerValue)
   */
  public static IntegerExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.intValue());
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@code int} to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #subtract(ObservableIntegerValue)
   */
  public static IntegerExpression subtract(NumberExpression<?> expression, int constant) {

    return new IntegerBinding(() -> minus(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static IntegerExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new IntegerBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link IntegerExpression} holding the product of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #multiply(ObservableIntegerValue)
   */
  public static IntegerExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new IntegerBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link IntegerExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableIntegerValue)
   */
  public static IntegerExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.intValue());
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@code int} to multiply.
   * @return a new {@link IntegerExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableIntegerValue)
   */
  public static IntegerExpression multiply(NumberExpression<?> expression, int constant) {

    return new IntegerBinding(() -> mul(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link IntegerExpression} holding the product of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static IntegerExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new IntegerBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link IntegerExpression} holding the quotient of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #divide(ObservableIntegerValue)
   */
  public static IntegerExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new IntegerBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link IntegerExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} divided by the given {@code constant}.
   * @see #divide(ObservableIntegerValue)
   */
  public static IntegerExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.intValue());
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@code int} to divide.
   * @return a new {@link IntegerExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} divided by the given {@code constant}.
   * @see #divide(ObservableIntegerValue)
   */
  public static IntegerExpression divide(NumberExpression<?> expression, int constant) {

    return new IntegerBinding(() -> div(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link IntegerExpression} holding the quotient of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static IntegerExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new IntegerBinding(() -> divAll(observables), observables);
  }

  private static Integer to(Number value) {

    if (value == null) {
      return ZERO;
    } else if (value instanceof Integer) {
      return (Integer) value;
    } else {
      return Integer.valueOf(value.intValue());
    }
  }

  private static Integer negate(Integer value) {

    if (value == null) {
      return null;
    }
    return Integer.valueOf(-value.intValue());
  }

  @SafeVarargs
  private static Integer plusAll(ReadableValue<? extends Number>... observables) {

    int sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = sum + value.intValue();
        }
      }
    }
    return Integer.valueOf(sum);
  }

  private static Integer plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Integer plus(Number v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return to(v1);
    }
    return Integer.valueOf(v1.intValue() + v2.intValue());
  }

  private static Integer plus(Number v1, int v2) {

    if (v1 != null) {
      v2 = v1.intValue() + v2;
    }
    return Integer.valueOf(v2);
  }

  @SafeVarargs
  private static Integer minusAll(ReadableValue<? extends Number>... observables) {

    int difference = 0;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (first) {
            difference = value.intValue();
          } else {
            difference = difference - value.intValue();
          }
        }
      }
      first = false;
    }
    return Integer.valueOf(difference);
  }

  private static Integer minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Integer minus(Number v1, Number v2) {

    if (v1 == null) {
      if (v2 == null) {
        return ZERO;
      }
      return Integer.valueOf(-v2.intValue());
    } else if (v2 == null) {
      return to(v1);
    }
    return Integer.valueOf(v1.intValue() - v2.intValue());
  }

  private static Integer minus(Number v1, int v2) {

    int i1 = 0;
    if (v1 != null) {
      i1 = v1.intValue();
    }
    return Integer.valueOf(i1 - v2);
  }

  @SafeVarargs
  private static Integer mulAll(ReadableValue<? extends Number>... observables) {

    int product = 1;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return ZERO;
      }
      Number value = observable.getValue();
      if (value == null) {
        return ZERO;
      }
      product = product * value.intValue();
    }
    return Integer.valueOf(product);
  }

  private static Integer mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Integer mul(Number v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return ZERO;
    }
    return Integer.valueOf(v1.intValue() * v2.intValue());
  }

  private static Integer mul(Number v1, int v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Integer.valueOf(v1.intValue() * v2);
  }

  @SafeVarargs
  private static Integer divAll(ReadableValue<? extends Number>... observables) {

    int quotient = 1;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (first) {
            quotient = value.intValue();
          } else {
            quotient = quotient / value.intValue();
          }
        }
      }
      first = false;
    }
    return Integer.valueOf(quotient);
  }

  private static Integer div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Integer div(Number v1, Number v2) {

    if (v1 == null) {
      return ZERO;
    }
    int i2 = 0;
    if (v2 != null) {
      i2 = v2.intValue();
    }
    return Integer.valueOf(v1.intValue() / i2);
  }

  private static Integer div(Number v1, int v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Integer.valueOf(v1.intValue() / v2);
  }

}
