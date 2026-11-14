package io.github.mmm.value.observable.number.bytes;

import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;

/// [io.github.mmm.value.observable.Binding] with [Byte] [value][#get()].
///
/// @since 1.0.0
public class ByteBinding extends NumberBinding<Byte> implements ByteExpression {

  private static final Byte ZERO = Byte.valueOf((byte) 0);

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#get()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public ByteBinding(Supplier<Byte> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /// @param expression the [ByteExpression] to negate.
  /// @return a new [ByteExpression] holding the negation of the [value][#get()] from the given
  ///         [ByteExpression].
  /// @see #expNegate()
  public static ByteExpression negate(ByteExpression expression) {

    return new ByteBinding(() -> negate(expression.get()), expression);
  }

  /// @param expression the [NumberExpression] to convert.
  /// @return the given [NumberExpression] converted to a [ByteExpression].
  public static ByteExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof ByteExpression) {
      return (ByteExpression) expression;
    } else {
      return new ByteBinding(() -> to(expression.get()), expression);
    }
  }

  /// @param expression the [ByteExpression] to add.
  /// @param other the [ObservableValue] to add.
  /// @return a new [ByteExpression] holding the sum of the [value][#get()]s of the first and the second given
  ///         [ObservableValue]s.
  /// @see #expAdd(ObservableByteValue)
  public static ByteExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> plus(expression, other), expression, other);
  }

  /// @param expression the [ByteExpression] to add.
  /// @param constant the constant [Number] to add.
  /// @return a new [ByteExpression] holding the sum of the [value][#get()] from the given
  ///         [ByteExpression] with the given `constant`.
  /// @see #expAdd(ObservableByteValue)
  public static ByteExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.byteValue());
  }

  /// @param expression the [ByteExpression] to add.
  /// @param constant the constant `byte` to add.
  /// @return a new [ByteExpression] holding the sum of the [value][#get()] from the given
  ///         [ByteExpression] with the given `constant`.
  /// @see #expAdd(ObservableByteValue)
  public static ByteExpression add(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> plus(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to add.
  /// @return a new [ByteExpression] holding the sum of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static ByteExpression addAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> plusAll(observables), observables);
  }

  /// @param expression the [ByteExpression].
  /// @param other the [ObservableValue] to subtract.
  /// @return a new [ByteExpression] holding the difference of the [value][#get()]s of the first and the
  ///         second given [ObservableValue]s.
  /// @see #expSub(ObservableByteValue)
  public static ByteExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> minus(expression, other), expression, other);
  }

  /// @param expression the [ByteExpression].
  /// @param constant the constant [Number] to subtract.
  /// @return a new [ByteExpression] holding the difference of the [value][#get()] from the given
  ///         [ByteExpression] with the given `constant`.
  /// @see #expSub(ObservableByteValue)
  public static ByteExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.byteValue());
  }

  /// @param expression the [ByteExpression].
  /// @param constant the constant `byte` to subtract.
  /// @return a new [ByteExpression] holding the difference of the [value][#get()] from the given
  ///         [ByteExpression] with the given `constant`.
  /// @see #expSub(ObservableByteValue)
  public static ByteExpression subtract(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> minus(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to subtract.
  /// @return a new [ByteExpression] holding the difference of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static ByteExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> minusAll(observables), observables);
  }

  /// @param expression the [ByteExpression].
  /// @param other the [ObservableValue] to multiply.
  /// @return a new [ByteExpression] holding the product of the [value][#get()]s of the first and the second
  ///         given [ObservableValue]s.
  /// @see #expMul(ObservableByteValue)
  public static ByteExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> mul(expression, other), expression, other);
  }

  /// @param expression the [ByteExpression].
  /// @param constant the constant [Number] to multiply.
  /// @return a new [ByteExpression] holding the product of the [value][#get()] from the given
  ///         [ByteExpression] multiplied with the given `constant`.
  /// @see #expMul(ObservableByteValue)
  public static ByteExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.byteValue());
  }

  /// @param expression the [ByteExpression].
  /// @param constant the constant `byte` to multiply.
  /// @return a new [ByteExpression] holding the product of the [value][#get()] from the given
  ///         [ByteExpression] multiplied with the given `constant`.
  /// @see #expMul(ObservableByteValue)
  public static ByteExpression multiply(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> mul(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to multiply.
  /// @return a new [ByteExpression] holding the product of the [value][#get()]s from the given
  ///         [ObservableValue]s.
  @SafeVarargs
  public static ByteExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new ByteBinding(() -> mulAll(observables), observables);
  }

  /// @param expression the [ByteExpression].
  /// @param other the [ObservableValue] to divide.
  /// @return a new [ByteExpression] holding the quotient of the [value][#get()]s of the first and the second
  ///         given [ObservableValue]s.
  /// @see #expDiv(ObservableByteValue)
  public static ByteExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ByteBinding(() -> div(expression, other), expression, other);
  }

  /// @param expression the [ByteExpression].
  /// @param constant the constant [Number] to divide.
  /// @return a new [ByteExpression] holding the quotient of the [value][#get()] from the given
  ///         [ByteExpression] divided by the given `constant`.
  /// @see #expDiv(ObservableByteValue)
  public static ByteExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.byteValue());
  }

  /// @param expression the [ByteExpression].
  /// @param constant the constant `byte` to divide.
  /// @return a new [ByteExpression] holding the quotient of the [value][#get()] from the given
  ///         [ByteExpression] divided by the given `constant`.
  /// @see #expDiv(ObservableByteValue)
  public static ByteExpression divide(NumberExpression<?> expression, byte constant) {

    return new ByteBinding(() -> div(expression.get(), constant), expression);
  }

  /// @param observables the [ObservableValue]s to divide.
  /// @return a new [ByteExpression] holding the quotient of the [value][#get()]s from the given
  ///         [ObservableValue]s.
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
