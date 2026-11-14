/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.comparable.ComparableExpression;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalBinding;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;
import io.github.mmm.value.observable.number.bigdecimal.ObservableBigDecimalValue;
import io.github.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import io.github.mmm.value.observable.number.bytes.ObservableByteValue;
import io.github.mmm.value.observable.number.doubles.DoubleBinding;
import io.github.mmm.value.observable.number.doubles.ObservableDoubleValue;
import io.github.mmm.value.observable.number.floats.ObservableFloatValue;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.longs.ObservableLongValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;

/// [ComparableExpression] with [Number] [value][#get()].
///
/// @param <N> type of the observable [value][#get()].
/// @since 1.0.0
public interface NumberExpression<N extends Number & Comparable<? super N>>
    extends ObservableNumberValue<N>, ComparableExpression<N> {

  /// @return a [NumberExpression] holding the negative [value][#get()].
  NumberExpression<N> expNegate();

  /// @param other the [ObservableValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableValue].
  default NumberExpression<?> expAdd(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableBigIntegerValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableDoubleValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableFloatValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableLongValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableIntegerValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableShortValue v) {
      return expAdd(v);
    } else if (other instanceof ObservableByteValue v) {
      return expAdd(v);
    } else {
      return DoubleBinding.expAdd(this, other);
    }
  }

  /// @param other the [ObservableBigDecimalValue] holding the [Number] to add.
  /// @return a new [BigDecimalExpression] holding the sum of this [value][#get()] with the [value][#get()] of the given [ObservableBigDecimalValue].
  default BigDecimalExpression expAdd(ObservableBigDecimalValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  /// @param other the [ObservableBigIntegerValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableBigIntegerValue].
  NumberExpression<?> expAdd(ObservableBigIntegerValue other);

  /// @param other the [ObservableDoubleValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableDoubleValue].
  NumberExpression<?> expAdd(ObservableDoubleValue other);

  /// @param other the [ObservableFloatValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableFloatValue].
  NumberExpression<?> expAdd(ObservableFloatValue other);

  /// @param other the [ObservableLongValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableLongValue].
  NumberExpression<?> expAdd(ObservableLongValue other);

  /// @param other the [ObservableIntegerValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableIntegerValue].
  NumberExpression<?> expAdd(ObservableIntegerValue other);

  /// @param other the [ObservableShortValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableShortValue].
  NumberExpression<?> expAdd(ObservableShortValue other);

  /// @param other the [ObservableByteValue] holding the [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the [value][#get()]
  ///         of the given [ObservableByteValue].
  NumberExpression<?> expAdd(ObservableByteValue other);

  /// @param constant the constant [Number] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  default NumberExpression<?> expAdd(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal v) {
      return expAdd(v);
    } else if (constant instanceof BigInteger v) {
      return expAdd(v);
    } else if (constant instanceof Double) {
      return expAdd(constant.doubleValue());
    } else if (constant instanceof Float) {
      return expAdd(constant.floatValue());
    } else if (constant instanceof Long) {
      return expAdd(constant.longValue());
    } else if (constant instanceof Integer) {
      return expAdd(constant.intValue());
    } else if (constant instanceof Short) {
      return expAdd(constant.shortValue());
    } else if (constant instanceof Byte) {
      return expAdd(constant.byteValue());
    } else {
      return expAdd(constant.doubleValue());
    }
  }

  /// @param constant the constant [BigDecimal] to add.
  /// @return a new [BigDecimalExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  default BigDecimalExpression expAdd(BigDecimal constant) {

    return BigDecimalBinding.expAdd(this, constant);
  }

  /// @param constant the constant [BigInteger] to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(BigInteger constant);

  /// @param constant the constant `double` to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(double constant);

  /// @param constant the constant `float` to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(float constant);

  /// @param constant the constant `long` to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(long constant);

  /// @param constant the constant `int` to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(int constant);

  /// @param constant the constant `short` to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(short constant);

  /// @param constant the constant `byte` to add.
  /// @return a new [NumberExpression] holding the sum of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expAdd(byte constant);

  /// @param other the [ObservableValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableValue].
  default NumberExpression<?> expSub(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue v) {
      return expSub(v);
    } else if (other instanceof ObservableBigIntegerValue v) {
      return expSub(v);
    } else if (other instanceof ObservableDoubleValue v) {
      return expSub(v);
    } else if (other instanceof ObservableFloatValue v) {
      return expSub(v);
    } else if (other instanceof ObservableLongValue v) {
      return expSub(v);
    } else if (other instanceof ObservableIntegerValue v) {
      return expSub(v);
    } else if (other instanceof ObservableShortValue v) {
      return expSub(v);
    } else if (other instanceof ObservableByteValue v) {
      return expSub(v);
    } else {
      return DoubleBinding.expSub(this, other);
    }
  }

  /// @param other the [ObservableBigDecimalValue] holding the [Number] to subtract.
  /// @return a new [BigDecimalExpression] holding the difference of this [value][#get()] with the
  ///         [value][#get()] of the given [ObservableBigDecimalValue].
  default BigDecimalExpression expSub(ObservableBigDecimalValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  /// @param other the [ObservableBigIntegerValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableBigIntegerValue].
  NumberExpression<?> expSub(ObservableBigIntegerValue other);

  /// @param other the [ObservableDoubleValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableDoubleValue].
  NumberExpression<?> expSub(ObservableDoubleValue other);

  /// @param other the [ObservableFloatValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableFloatValue].
  NumberExpression<?> expSub(ObservableFloatValue other);

  /// @param other the [ObservableLongValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableLongValue].
  NumberExpression<?> expSub(ObservableLongValue other);

  /// @param other the [ObservableIntegerValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableIntegerValue].
  NumberExpression<?> expSub(ObservableIntegerValue other);

  /// @param other the [ObservableShortValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableShortValue].
  NumberExpression<?> expSub(ObservableShortValue other);

  /// @param other the [ObservableByteValue] holding the [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the [value][#get()] of the given [ObservableByteValue].
  NumberExpression<?> expSub(ObservableByteValue other);

  /// @param constant the constant [Number] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  default NumberExpression<?> expSub(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal v) {
      return expSub(v);
    } else if (constant instanceof BigInteger v) {
      return expSub(v);
    } else if (constant instanceof Double) {
      return expSub(constant.doubleValue());
    } else if (constant instanceof Float) {
      return expSub(constant.floatValue());
    } else if (constant instanceof Long) {
      return expSub(constant.longValue());
    } else if (constant instanceof Integer) {
      return expSub(constant.intValue());
    } else if (constant instanceof Short) {
      return expSub(constant.shortValue());
    } else if (constant instanceof Byte) {
      return expSub(constant.byteValue());
    } else {
      return expSub(constant.doubleValue());
    }
  }

  /// @param constant the constant [BigDecimal] to subtract.
  /// @return a new [BigDecimalExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  default BigDecimalExpression expSub(BigDecimal constant) {

    return BigDecimalBinding.expSub(this, constant);
  }

  /// @param constant the constant [BigInteger] to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(BigInteger constant);

  /// @param constant the constant `double` to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(double constant);

  /// @param constant the constant `float` to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(float constant);

  /// @param constant the constant `long` to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(long constant);

  /// @param constant the constant `int` to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(int constant);

  /// @param constant the constant `short` to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(short constant);

  /// @param constant the constant `byte` to subtract.
  /// @return a new [NumberExpression] holding the difference of this [value][#get()] with the given
  ///         `constant`.
  NumberExpression<?> expSub(byte constant);

  /// @param other the [ObservableValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableValue].
  default NumberExpression<?> expMul(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue v) {
      return expMul(v);
    } else if (other instanceof ObservableBigIntegerValue v) {
      return expMul(v);
    } else if (other instanceof ObservableDoubleValue v) {
      return expMul(v);
    } else if (other instanceof ObservableFloatValue v) {
      return expMul(v);
    } else if (other instanceof ObservableLongValue v) {
      return expMul(v);
    } else if (other instanceof ObservableIntegerValue v) {
      return expMul(v);
    } else if (other instanceof ObservableShortValue v) {
      return expMul(v);
    } else if (other instanceof ObservableByteValue v) {
      return expMul(v);
    } else {
      return DoubleBinding.expMul(this, other);
    }
  }

  /// @param other the [ObservableBigDecimalValue] holding the [Number] to multiply.
  /// @return a new [BigDecimalExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableBigDecimalValue].
  default BigDecimalExpression expMul(ObservableBigDecimalValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  /// @param other the [ObservableBigIntegerValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableBigIntegerValue].
  NumberExpression<?> expMul(ObservableBigIntegerValue other);

  /// @param other the [ObservableDoubleValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableDoubleValue].
  NumberExpression<?> expMul(ObservableDoubleValue other);

  /// @param other the [ObservableFloatValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableFloatValue].
  NumberExpression<?> expMul(ObservableFloatValue other);

  /// @param other the [ObservableLongValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableLongValue].
  NumberExpression<?> expMul(ObservableLongValue other);

  /// @param other the [ObservableIntegerValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableIntegerValue].
  NumberExpression<?> expMul(ObservableIntegerValue other);

  /// @param other the [ObservableShortValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableShortValue].
  NumberExpression<?> expMul(ObservableShortValue other);

  /// @param other the [ObservableByteValue] holding the [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] with the [value][#get()] of the given [ObservableByteValue].
  NumberExpression<?> expMul(ObservableByteValue other);

  /// @param constant the constant [Number] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  default NumberExpression<?> expMul(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal v) {
      return expMul(v);
    } else if (constant instanceof BigInteger v) {
      return expMul(v);
    } else if (constant instanceof Double) {
      return expMul(constant.doubleValue());
    } else if (constant instanceof Float) {
      return expMul(constant.floatValue());
    } else if (constant instanceof Long) {
      return expMul(constant.longValue());
    } else if (constant instanceof Integer) {
      return expMul(constant.intValue());
    } else if (constant instanceof Short) {
      return expMul(constant.shortValue());
    } else if (constant instanceof Byte) {
      return expMul(constant.byteValue());
    } else {
      return expMul(constant.doubleValue());
    }
  }

  /// @param constant the constant [BigDecimal] to multiply.
  /// @return a new [BigDecimalExpression] holding the product of this [value][#get()] multiplied with the
  ///         given `constant`.
  default BigDecimalExpression expMul(BigDecimal constant) {

    return BigDecimalBinding.expMul(this, constant);
  }

  /// @param constant the constant [BigInteger] to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(BigInteger constant);

  /// @param constant the constant `double` to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(double constant);

  /// @param constant the constant `float` to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(float constant);

  /// @param constant the constant `long` to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(long constant);

  /// @param constant the constant `int` to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(int constant);

  /// @param constant the constant `short` to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(short constant);

  /// @param constant the constant `byte` to multiply.
  /// @return a new [NumberExpression] holding the product of this [value][#get()] multiplied with the given
  ///         `constant`.
  NumberExpression<?> expMul(byte constant);

  /// @param other the [ObservableValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableValue].
  default NumberExpression<?> expDiv(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableBigIntegerValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableDoubleValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableFloatValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableLongValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableIntegerValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableShortValue v) {
      return expDiv(v);
    } else if (other instanceof ObservableByteValue v) {
      return expDiv(v);
    } else {
      return DoubleBinding.expDiv(this, other);
    }
  }

  /// @param other the [ObservableBigDecimalValue] holding the [Number] to divide.
  /// @return a new [BigDecimalExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableBigDecimalValue].
  default BigDecimalExpression expDiv(ObservableBigDecimalValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  /// @param other the [ObservableBigIntegerValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableBigIntegerValue].
  NumberExpression<?> expDiv(ObservableBigIntegerValue other);

  /// @param other the [ObservableDoubleValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableDoubleValue].
  NumberExpression<?> expDiv(ObservableDoubleValue other);

  /// @param other the [ObservableFloatValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableFloatValue].
  NumberExpression<?> expDiv(ObservableFloatValue other);

  /// @param other the [ObservableLongValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableLongValue].
  NumberExpression<?> expDiv(ObservableLongValue other);

  /// @param other the [ObservableIntegerValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableIntegerValue].
  NumberExpression<?> expDiv(ObservableIntegerValue other);

  /// @param other the [ObservableShortValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableShortValue].
  NumberExpression<?> expDiv(ObservableShortValue other);

  /// @param other the [ObservableByteValue] holding the [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] with the [value][#get()] of the given [ObservableByteValue].
  NumberExpression<?> expDiv(ObservableByteValue other);

  /// @param constant the constant [Number] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  default NumberExpression<?> expDiv(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal v) {
      return expDiv(v);
    } else if (constant instanceof BigInteger v) {
      return expDiv(v);
    } else if (constant instanceof Double) {
      return expDiv(constant.doubleValue());
    } else if (constant instanceof Float) {
      return expDiv(constant.floatValue());
    } else if (constant instanceof Long) {
      return expDiv(constant.longValue());
    } else if (constant instanceof Integer) {
      return expDiv(constant.intValue());
    } else if (constant instanceof Short) {
      return expDiv(constant.shortValue());
    } else if (constant instanceof Byte) {
      return expDiv(constant.byteValue());
    } else {
      return expDiv(constant.doubleValue());
    }
  }

  /// @param constant the constant [BigDecimal] to divide.
  /// @return a new [BigDecimalExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  default BigDecimalExpression expDiv(BigDecimal constant) {

    return BigDecimalBinding.expDiv(this, constant);
  }

  /// @param constant the constant [BigInteger] to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(BigInteger constant);

  /// @param constant the constant `double` to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(double constant);

  /// @param constant the constant `float` to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(float constant);

  /// @param constant the constant `long` to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(long constant);

  /// @param constant the constant `int` to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(int constant);

  /// @param constant the constant `short` to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(short constant);

  /// @param constant the constant `byte` to divide.
  /// @return a new [NumberExpression] holding the quotient of this [value][#get()] divided by the given
  ///         `constant`.
  NumberExpression<?> expDiv(byte constant);

}
