package io.github.mmm.value.observable.number.floats;

import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;

/**
 * {@link NumberBinding} with {@link Float} {@link #get() value}.
 *
 * @since 1.0.0
 */
public class FloatBinding extends NumberBinding<Float> implements FloatExpression {

  private static final Float ZERO = Float.valueOf(0);

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #get() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public FloatBinding(Supplier<Float> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link FloatExpression} to negate.
   * @return a new {@link FloatExpression} holding the negation of the {@link #get() value} from the given
   *         {@link FloatExpression}.
   * @see #expNegate()
   */
  public static FloatExpression negate(FloatExpression expression) {

    return new FloatBinding(() -> negate(expression.get()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link FloatExpression}.
   */
  public static FloatExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof FloatExpression) {
      return (FloatExpression) expression;
    } else {
      return new FloatBinding(() -> to(expression.get()), expression);
    }
  }

  /**
   * @param expression the {@link FloatExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link FloatExpression} holding the sum of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expAdd(ObservableFloatValue)
   */
  public static FloatExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new FloatBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link FloatExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link FloatExpression} holding the sum of the {@link #get() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #expAdd(ObservableFloatValue)
   */
  public static FloatExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.floatValue());
  }

  /**
   * @param expression the {@link FloatExpression} to add.
   * @param constant the constant {@code float} to add.
   * @return a new {@link FloatExpression} holding the sum of the {@link #get() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #expAdd(ObservableFloatValue)
   */
  public static FloatExpression add(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> plus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link FloatExpression} holding the sum of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression addAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link FloatExpression} holding the difference of the {@link #get() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #expSub(ObservableFloatValue)
   */
  public static FloatExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new FloatBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link FloatExpression} holding the difference of the {@link #get() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #expSub(ObservableFloatValue)
   */
  public static FloatExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.floatValue());
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param constant the constant {@code float} to subtract.
   * @return a new {@link FloatExpression} holding the difference of the {@link #get() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #expSub(ObservableFloatValue)
   */
  public static FloatExpression subtract(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> minus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link FloatExpression} holding the difference of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link FloatExpression} holding the product of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expMul(ObservableFloatValue)
   */
  public static FloatExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new FloatBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link FloatExpression} holding the product of the {@link #get() value} from the given
   *         {@link FloatExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableFloatValue)
   */
  public static FloatExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.floatValue());
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param constant the constant {@code float} to multiply.
   * @return a new {@link FloatExpression} holding the product of the {@link #get() value} from the given
   *         {@link FloatExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableFloatValue)
   */
  public static FloatExpression multiply(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> mul(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link FloatExpression} holding the product of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link FloatExpression} holding the quotient of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expDiv(ObservableFloatValue)
   */
  public static FloatExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new FloatBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link FloatExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link FloatExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableFloatValue)
   */
  public static FloatExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.floatValue());
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param constant the constant {@code float} to divide.
   * @return a new {@link FloatExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link FloatExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableFloatValue)
   */
  public static FloatExpression divide(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> div(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link FloatExpression} holding the quotient of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> divAll(observables), observables);
  }

  private static Float to(Number value) {

    if (value == null) {
      return ZERO;
    } else if (value instanceof Float) {
      return (Float) value;
    } else {
      return Float.valueOf(value.floatValue());
    }
  }

  private static Float negate(Float value) {

    if (value == null) {
      return null;
    }
    return Float.valueOf(-value.floatValue());
  }

  @SafeVarargs
  private static Float plusAll(ReadableValue<? extends Number>... observables) {

    float sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          sum = sum + value.floatValue();
        }
      }
    }
    return Float.valueOf(sum);
  }

  private static Float plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Float plus(Number v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return to(v1);
    }
    return Float.valueOf(v1.floatValue() + v2.floatValue());
  }

  private static Float plus(Number v1, float v2) {

    if (v1 != null) {
      return v2 = v2 + v1.floatValue();
    }
    return Float.valueOf(v2);
  }

  @SafeVarargs
  private static Float minusAll(ReadableValue<? extends Number>... observables) {

    float difference = 0;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          if (first) {
            difference = value.floatValue();
          } else {
            difference = difference - value.floatValue();
          }
        }
      }
      first = false;
    }
    return Float.valueOf(difference);
  }

  private static Float minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Float minus(Number v1, Number v2) {

    if (v1 == null) {
      if (v2 == null) {
        return ZERO;
      }
      return Float.valueOf(-v2.floatValue());
    } else if (v2 == null) {
      return to(v1);
    }
    return Float.valueOf(v1.floatValue() - v2.floatValue());
  }

  private static Float minus(Number v1, float v2) {

    float f1 = 0;
    if (v1 != null) {
      f1 = v1.floatValue();
    }
    return Float.valueOf(f1 - v2);
  }

  @SafeVarargs
  private static Float mulAll(ReadableValue<? extends Number>... observables) {

    float product = 1;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return ZERO;
      }
      Number value = observable.get();
      if (value == null) {
        return ZERO;
      }
      product = product * value.floatValue();
    }
    return Float.valueOf(product);
  }

  private static Float mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Float mul(Number v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return ZERO;
    }
    return Float.valueOf(v1.floatValue() * v2.floatValue());
  }

  private static Float mul(Number v1, float v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Float.valueOf(v2 * v1.floatValue());
  }

  @SafeVarargs
  private static Float divAll(ReadableValue<? extends Number>... observables) {

    float quotient = 1;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          if (first) {
            quotient = value.floatValue();
          } else {
            quotient = quotient / value.floatValue();
          }
        }
      }
      first = false;
    }
    return Float.valueOf(quotient);
  }

  private static Float div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Float div(Number v1, Number v2) {

    if (v1 == null) {
      return ZERO;
    }
    float f2 = 0;
    if (v2 != null) {
      f2 = v2.floatValue();
    }
    return Float.valueOf(v1.floatValue() / f2);
  }

  private static Float div(Number v1, float v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Float.valueOf(v1.floatValue() / v2);
  }

}
