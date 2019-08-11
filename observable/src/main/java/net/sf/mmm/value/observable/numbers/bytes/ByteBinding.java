package net.sf.mmm.value.observable.numbers.bytes;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link net.sf.mmm.value.observable.Binding} with {@link Byte} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class ByteBinding extends NumberBinding<Byte> implements ByteExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public ByteBinding(Supplier<Byte> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link ByteExpression} to negate.
   * @return a new {@link ByteExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link ByteExpression}.
   * @see #negate()
   */
  public static ByteExpression negate(ByteExpression expression) {

    return new ByteBinding(() -> negate(expression.getValue()), expression);
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
      return new ByteBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link ByteExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link ByteExpression} holding the sum of the {@link #getValue() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #add(ObservableByteValue)
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
   * @return a new {@link ByteExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #add(ObservableByteValue)
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
   * @return a new {@link ByteExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #add(ObservableByteValue)
   */
  public static ByteExpression add(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link ByteExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ByteExpression addAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link ByteExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link ByteExpression} holding the difference of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #subtract(ObservableByteValue)
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
   * @return a new {@link ByteExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #subtract(ObservableByteValue)
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
   * @return a new {@link ByteExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link ByteExpression} with the given {@code constant}.
   * @see #subtract(ObservableByteValue)
   */
  public static ByteExpression subtract(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> minus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link ByteExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ByteExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> minusAll(observables), observables);
  }

  private static Byte to(Number value) {

    if (value == null) {
      return null;
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
        Number value = observable.getValue();
        if (value != null) {
          sum = (byte) (sum + value.byteValue());
        }
      }
    }
    return Byte.valueOf(sum);
  }

  private static Byte plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Byte plus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Byte.valueOf((byte) (v1.byteValue() + v2.byteValue()));
  }

  private static Byte plus(byte v1, Number v2) {

    if (v2 != null) {
      v1 = (byte) (v1 + v2.byteValue());
    }
    return Byte.valueOf(v1);
  }

  @SafeVarargs
  private static Byte minusAll(ReadableValue<? extends Number>... observables) {

    byte difference = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          difference = (byte) (difference - value.byteValue());
        }
      }
    }
    return Byte.valueOf(difference);
  }

  private static Byte minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Byte minus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Byte.valueOf((byte) (v1.byteValue() - v2.byteValue()));
  }

  private static Byte minus(byte v1, Number v2) {

    if (v2 != null) {
      v1 = (byte) (v1 - v2.byteValue());
    }
    return Byte.valueOf(v1);
  }

}
