package io.github.mmm.value.observable.number.bytes;

import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;

/**
 * {@link io.github.mmm.value.observable.Binding} with {@link Byte} {@link #get() value}.
 *
 * @since 1.0.0
 */
public class ByteBinding extends NumberBinding<Byte> implements ByteExpression {

  private static final Byte ZERO = Byte.valueOf((byte) 0);

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #get() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public ByteBinding(Supplier<Byte> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link ByteExpression} to negate.
   * @return a new {@link ByteExpression} holding the negation of the {@link #get() value} from the given
   *         {@link ByteExpression}.
   * @see #expNegate()
   */
  public static ByteExpression negate(ByteExpression expression) {

    return new ByteBinding(() -> negate(expression.get()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link ByteExpression}.
   */
  public static ByteExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof ByteExpression) {
      return (ByteExpression) expression;
    } else {
      return new ByteBinding(() -> to(expression.get()), expression);
    }
  }

  /**
   * @param expression the {@link ByteExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link ByteExpression} holding the sum of the {@link #get() value}s of the first and the second given
   *         {@link ObservableValue}s.
   * @see #expAdd(ObservableByteValue)
   */
  public static ByteExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ByteExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link ByteExpression} holding the sum of the {@link #get() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #expAdd(ObservableByteValue)
   */
  public static ByteExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.byteValue());
  }

  /**
   * @param expression the {@link ByteExpression} to add.
   * @param constant the constant {@code byte} to add.
   * @return a new {@link ByteExpression} holding the sum of the {@link #get() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #expAdd(ObservableByteValue)
   */
  public static ByteExpression add(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> plus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link ByteExpression} holding the sum of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ByteExpression addAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link ByteExpression} holding the difference of the {@link #get() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #expSub(ObservableByteValue)
   */
  public static ByteExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link ByteExpression} holding the difference of the {@link #get() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #expSub(ObservableByteValue)
   */
  public static ByteExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.byteValue());
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param constant the constant {@code byte} to subtract.
   * @return a new {@link ByteExpression} holding the difference of the {@link #get() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #expSub(ObservableByteValue)
   */
  public static ByteExpression subtract(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> minus(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link ByteExpression} holding the difference of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ByteExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link ByteExpression} holding the product of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expMul(ObservableByteValue)
   */
  public static ByteExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link ByteExpression} holding the product of the {@link #get() value} from the given
   *         {@link ByteExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableByteValue)
   */
  public static ByteExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.byteValue());
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param constant the constant {@code byte} to multiply.
   * @return a new {@link ByteExpression} holding the product of the {@link #get() value} from the given
   *         {@link ByteExpression} multiplied with the given {@code constant}.
   * @see #expMul(ObservableByteValue)
   */
  public static ByteExpression multiply(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> mul(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link ByteExpression} holding the product of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ByteExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link ByteExpression} holding the quotient of the {@link #get() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #expDiv(ObservableByteValue)
   */
  public static ByteExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link ByteExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link ByteExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableByteValue)
   */
  public static ByteExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.byteValue());
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param constant the constant {@code byte} to divide.
   * @return a new {@link ByteExpression} holding the quotient of the {@link #get() value} from the given
   *         {@link ByteExpression} divided by the given {@code constant}.
   * @see #expDiv(ObservableByteValue)
   */
  public static ByteExpression divide(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> div(expression.get(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link ByteExpression} holding the quotient of the {@link #get() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ByteExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> divAll(observables), observables);
  }

  private static Byte to(Number value) {

    if (value == null) {
      return ZERO;
    } else {
      return Byte.valueOf(value.byteValue());
    }
  }

  private static Byte negate(Byte value) {

    if (value == null) {
      return null;
    }
    return Byte.valueOf((byte) -value.byteValue());
  }

  @SafeVarargs
  private static Byte plusAll(ReadableValue<? extends Number>... observables) {

    byte sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          sum = (byte) (sum + value.byteValue());
        }
      }
    }
    return Byte.valueOf(sum);
  }

  private static Byte plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Byte plus(Number v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return to(v1);
    }
    return Byte.valueOf((byte) (v1.byteValue() + v2.byteValue()));
  }

  private static Byte plus(Number v1, byte v2) {

    if (v1 != null) {
      v2 = (byte) (v2 + v1.byteValue());
    }
    return Byte.valueOf(v2);
  }

  @SafeVarargs
  private static Byte minusAll(ReadableValue<? extends Number>... observables) {

    byte difference = 0;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          if (first) {
            difference = value.byteValue();
          } else {
            difference = (byte) (difference - value.byteValue());
          }
        }
      }
      first = false;
    }
    return Byte.valueOf(difference);
  }

  private static Byte minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Byte minus(Number v1, Number v2) {

    if (v1 == null) {
      if (v2 == null) {
        return ZERO;
      } else {
        return Byte.valueOf((byte) -v2.byteValue());
      }
    } else if (v2 == null) {
      return to(v1);
    }
    return Byte.valueOf((byte) (v1.byteValue() - v2.byteValue()));
  }

  private static Byte minus(Number v1, byte v2) {

    byte b1 = 0;
    if (v1 != null) {
      b1 = v1.byteValue();
    }
    return Byte.valueOf((byte) (b1 - v2));
  }

  @SafeVarargs
  private static Byte mulAll(ReadableValue<? extends Number>... observables) {

    byte product = 1;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return ZERO;
      }
      Number value = observable.get();
      if (value == null) {
        return ZERO;
      }
      product = (byte) (product * value.byteValue());
    }
    return Byte.valueOf(product);
  }

  private static Byte mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Byte mul(Number v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return ZERO;
    }
    return Byte.valueOf((byte) (v1.byteValue() * v2.byteValue()));
  }

  private static Byte mul(Number v1, byte v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Byte.valueOf((byte) (v2 * v1.byteValue()));
  }

  @SafeVarargs
  private static Byte divAll(ReadableValue<? extends Number>... observables) {

    byte quotient = 1;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.get();
        if (value != null) {
          if (first) {
            quotient = value.byteValue();
          } else {
            quotient = (byte) (quotient / value.byteValue());
          }
        }
      }
      first = false;
    }
    return Byte.valueOf(quotient);
  }

  private static Byte div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.get(v1), ReadableValue.get(v2));
  }

  private static Byte div(Number v1, Number v2) {

    if (v1 == null) {
      return ZERO;
    }
    byte b2 = 0;
    if (v2 != null) {
      b2 = v2.byteValue();
    }
    return Byte.valueOf((byte) (v1.byteValue() / b2));
  }

  private static Byte div(Number v1, byte v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Byte.valueOf((byte) (v1.byteValue() / v2));
  }

}
