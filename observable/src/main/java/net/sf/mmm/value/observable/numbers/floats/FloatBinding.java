package net.sf.mmm.value.observable.numbers.floats;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link NumberBinding} with {@link Float} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class FloatBinding extends NumberBinding<Float> implements FloatExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public FloatBinding(Supplier<Float> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link FloatExpression} to negate.
   * @return a new {@link FloatExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link FloatExpression}.
   * @see #negate()
   */
  public static FloatExpression negate(FloatExpression expression) {

    return new FloatBinding(() -> negate(expression.getValue()), expression);
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
      return new FloatBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link FloatExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link FloatExpression} holding the sum of the {@link #getValue() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #add(ObservableFloatValue)
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
   * @return a new {@link FloatExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #add(ObservableFloatValue)
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
   * @return a new {@link FloatExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #add(ObservableFloatValue)
   */
  public static FloatExpression add(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link FloatExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression addAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link FloatExpression} holding the difference of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #subtract(ObservableFloatValue)
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
   * @return a new {@link FloatExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #subtract(ObservableFloatValue)
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
   * @return a new {@link FloatExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link FloatExpression} with the given {@code constant}.
   * @see #subtract(ObservableFloatValue)
   */
  public static FloatExpression subtract(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> minus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link FloatExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link FloatExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link FloatExpression} holding the product of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #multiply(ObservableFloatValue)
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
   * @return a new {@link FloatExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link FloatExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableFloatValue)
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
   * @return a new {@link FloatExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link FloatExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableFloatValue)
   */
  public static FloatExpression multiply(NumberExpression<?> expression, float constant) {

    return new FloatBinding(() -> mul(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link FloatExpression} holding the product of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static FloatExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new FloatBinding(() -> mulAll(observables), observables);
  }

  private static Float to(Number value) {

    if (value == null) {
      return null;
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
        Number value = observable.getValue();
        if (value != null) {
          sum = sum + value.floatValue();
        }
      }
    }
    return Float.valueOf(sum);
  }

  private static Float plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Float plus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Float.valueOf(v1.floatValue() + v2.floatValue());
  }

  private static Float plus(float v1, Number v2) {

    if (v2 != null) {
      return v1 = v1 + v2.floatValue();
    }
    return Float.valueOf(v1);
  }

  @SafeVarargs
  private static Float minusAll(ReadableValue<? extends Number>... observables) {

    float difference = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          difference = difference - value.floatValue();
        }
      }
    }
    return Float.valueOf(difference);
  }

  private static Float minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Float minus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Float.valueOf(v1.floatValue() - v2.floatValue());
  }

  private static Float minus(float v1, Number v2) {

    if (v2 != null) {
      return v1 = v1 - v2.floatValue();
    }
    return Float.valueOf(v1);
  }

  @SafeVarargs
  private static Float mulAll(ReadableValue<? extends Number>... observables) {

    float product = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          product = product * value.floatValue();
        }
      }
    }
    return Float.valueOf(product);
  }

  private static Float mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Float mul(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Float.valueOf(v1.floatValue() * v2.floatValue());
  }

  private static Float mul(float v1, Number v2) {

    if (v2 != null) {
      return v1 = v1 * v2.floatValue();
    }
    return Float.valueOf(v1);
  }

}
