/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.comparables.ComparableExpression;
import net.sf.mmm.value.observable.numbers.bigdecimals.BigDecimalBinding;
import net.sf.mmm.value.observable.numbers.bigdecimals.BigDecimalExpression;
import net.sf.mmm.value.observable.numbers.bigdecimals.ObservableBigDecimalValue;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.doubles.DoubleBinding;
import net.sf.mmm.value.observable.numbers.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link ComparableExpression} with {@link Number} {@link #getValue() value}.
 *
 * @param <N> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public interface NumberExpression<N extends Number & Comparable<? super N>>
    extends ObservableNumberValue<N>, ComparableExpression<N> {

  /**
   * @return a {@link NumberExpression} holding the negative {@link #getValue() value}.
   */
  NumberExpression<N> negate();

  /**
   * @param other the {@link ObservableValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableValue}.
   */
  default NumberExpression<?> add(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return add((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return add((ObservableBigIntegerValue) other);
    } else if (other instanceof ObservableDoubleValue) {
      return add((ObservableDoubleValue) other);
    } else if (other instanceof ObservableFloatValue) {
      return add((ObservableFloatValue) other);
    } else if (other instanceof ObservableLongValue) {
      return add((ObservableLongValue) other);
    } else if (other instanceof ObservableIntegerValue) {
      return add((ObservableIntegerValue) other);
    } else if (other instanceof ObservableShortValue) {
      return add((ObservableShortValue) other);
    } else if (other instanceof ObservableByteValue) {
      return add((ObservableByteValue) other);
    } else {
      return DoubleBinding.add(this, other);
    }
  }

  /**
   * @param other the {@link ObservableBigDecimalValue} holding the {@link Number} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigDecimalValue}.
   */
  default BigDecimalExpression add(ObservableBigDecimalValue other) {

    return BigDecimalBinding.add(this, other);
  }

  /**
   * @param other the {@link ObservableBigIntegerValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigIntegerValue}.
   */
  NumberExpression<?> add(ObservableBigIntegerValue other);

  /**
   * @param other the {@link ObservableDoubleValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableDoubleValue}.
   */
  NumberExpression<?> add(ObservableDoubleValue other);

  /**
   * @param other the {@link ObservableFloatValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableFloatValue}.
   */
  NumberExpression<?> add(ObservableFloatValue other);

  /**
   * @param other the {@link ObservableLongValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableLongValue}.
   */
  NumberExpression<?> add(ObservableLongValue other);

  /**
   * @param other the {@link ObservableIntegerValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableIntegerValue}.
   */
  NumberExpression<?> add(ObservableIntegerValue other);

  /**
   * @param other the {@link ObservableShortValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableShortValue}.
   */
  NumberExpression<?> add(ObservableShortValue other);

  /**
   * @param other the {@link ObservableByteValue} holding the {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableByteValue}.
   */
  NumberExpression<?> add(ObservableByteValue other);

  /**
   * @param constant the constant {@link Number} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  default NumberExpression<?> add(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return add((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return add((BigInteger) constant);
    } else if (constant instanceof Double) {
      return add(constant.doubleValue());
    } else if (constant instanceof Float) {
      return add(constant.floatValue());
    } else if (constant instanceof Long) {
      return add(constant.longValue());
    } else if (constant instanceof Integer) {
      return add(constant.intValue());
    } else if (constant instanceof Short) {
      return add(constant.shortValue());
    } else if (constant instanceof Byte) {
      return add(constant.byteValue());
    } else {
      return add(constant.doubleValue());
    }
  }

  /**
   * @param constant the constant {@link BigDecimal} to add.
   * @return a new {@link BigDecimalExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  default BigDecimalExpression add(BigDecimal constant) {

    return BigDecimalBinding.add(this, constant);
  }

  /**
   * @param constant the constant {@link BigInteger} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(BigInteger constant);

  /**
   * @param constant the constant {@code double} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(double constant);

  /**
   * @param constant the constant {@code float} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(float constant);

  /**
   * @param constant the constant {@code long} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(long constant);

  /**
   * @param constant the constant {@code int} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(int constant);

  /**
   * @param constant the constant {@code short} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(short constant);

  /**
   * @param constant the constant {@code byte} to add.
   * @return a new {@link NumberExpression} holding the sum of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> add(byte constant);

  /**
   * @param other the {@link ObservableValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableValue}.
   */
  default NumberExpression<?> subtract(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return subtract((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return subtract((ObservableBigIntegerValue) other);
    } else if (other instanceof ObservableDoubleValue) {
      return subtract((ObservableDoubleValue) other);
    } else if (other instanceof ObservableFloatValue) {
      return subtract((ObservableFloatValue) other);
    } else if (other instanceof ObservableLongValue) {
      return subtract((ObservableLongValue) other);
    } else if (other instanceof ObservableIntegerValue) {
      return subtract((ObservableIntegerValue) other);
    } else if (other instanceof ObservableShortValue) {
      return subtract((ObservableShortValue) other);
    } else if (other instanceof ObservableByteValue) {
      return subtract((ObservableByteValue) other);
    } else {
      return DoubleBinding.subtract(this, other);
    }
  }

  /**
   * @param other the {@link ObservableBigDecimalValue} holding the {@link Number} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigDecimalValue}.
   */
  default BigDecimalExpression subtract(ObservableBigDecimalValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  /**
   * @param other the {@link ObservableBigIntegerValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigIntegerValue}.
   */
  NumberExpression<?> subtract(ObservableBigIntegerValue other);

  /**
   * @param other the {@link ObservableDoubleValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableDoubleValue}.
   */
  NumberExpression<?> subtract(ObservableDoubleValue other);

  /**
   * @param other the {@link ObservableFloatValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableFloatValue}.
   */
  NumberExpression<?> subtract(ObservableFloatValue other);

  /**
   * @param other the {@link ObservableLongValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableLongValue}.
   */
  NumberExpression<?> subtract(ObservableLongValue other);

  /**
   * @param other the {@link ObservableIntegerValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableIntegerValue}.
   */
  NumberExpression<?> subtract(ObservableIntegerValue other);

  /**
   * @param other the {@link ObservableShortValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableShortValue}.
   */
  NumberExpression<?> subtract(ObservableShortValue other);

  /**
   * @param other the {@link ObservableByteValue} holding the {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableByteValue}.
   */
  NumberExpression<?> subtract(ObservableByteValue other);

  /**
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  default NumberExpression<?> subtract(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return subtract((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return subtract((BigInteger) constant);
    } else if (constant instanceof Double) {
      return subtract(constant.doubleValue());
    } else if (constant instanceof Float) {
      return subtract(constant.floatValue());
    } else if (constant instanceof Long) {
      return subtract(constant.longValue());
    } else if (constant instanceof Integer) {
      return subtract(constant.intValue());
    } else if (constant instanceof Short) {
      return subtract(constant.shortValue());
    } else if (constant instanceof Byte) {
      return subtract(constant.byteValue());
    } else {
      return subtract(constant.doubleValue());
    }
  }

  /**
   * @param constant the constant {@link BigDecimal} to subtract.
   * @return a new {@link BigDecimalExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  default BigDecimalExpression subtract(BigDecimal constant) {

    return BigDecimalBinding.subtract(this, constant);
  }

  /**
   * @param constant the constant {@link BigInteger} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(BigInteger constant);

  /**
   * @param constant the constant {@code double} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(double constant);

  /**
   * @param constant the constant {@code float} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(float constant);

  /**
   * @param constant the constant {@code long} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(long constant);

  /**
   * @param constant the constant {@code int} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(int constant);

  /**
   * @param constant the constant {@code short} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(short constant);

  /**
   * @param constant the constant {@code byte} to subtract.
   * @return a new {@link NumberExpression} holding the difference of this {@link #getValue() value} with the given
   *         {@code constant}.
   */
  NumberExpression<?> subtract(byte constant);

  /**
   * @param other the {@link ObservableValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableValue}.
   */
  default NumberExpression<?> multiply(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return multiply((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return multiply((ObservableBigIntegerValue) other);
    } else if (other instanceof ObservableDoubleValue) {
      return multiply((ObservableDoubleValue) other);
    } else if (other instanceof ObservableFloatValue) {
      return multiply((ObservableFloatValue) other);
    } else if (other instanceof ObservableLongValue) {
      return multiply((ObservableLongValue) other);
    } else if (other instanceof ObservableIntegerValue) {
      return multiply((ObservableIntegerValue) other);
    } else if (other instanceof ObservableShortValue) {
      return multiply((ObservableShortValue) other);
    } else if (other instanceof ObservableByteValue) {
      return multiply((ObservableByteValue) other);
    } else {
      return DoubleBinding.multiply(this, other);
    }
  }

  /**
   * @param other the {@link ObservableBigDecimalValue} holding the {@link Number} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigDecimalValue}.
   */
  default BigDecimalExpression multiply(ObservableBigDecimalValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  /**
   * @param other the {@link ObservableBigIntegerValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigIntegerValue}.
   */
  NumberExpression<?> multiply(ObservableBigIntegerValue other);

  /**
   * @param other the {@link ObservableDoubleValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableDoubleValue}.
   */
  NumberExpression<?> multiply(ObservableDoubleValue other);

  /**
   * @param other the {@link ObservableFloatValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableFloatValue}.
   */
  NumberExpression<?> multiply(ObservableFloatValue other);

  /**
   * @param other the {@link ObservableLongValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableLongValue}.
   */
  NumberExpression<?> multiply(ObservableLongValue other);

  /**
   * @param other the {@link ObservableIntegerValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableIntegerValue}.
   */
  NumberExpression<?> multiply(ObservableIntegerValue other);

  /**
   * @param other the {@link ObservableShortValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableShortValue}.
   */
  NumberExpression<?> multiply(ObservableShortValue other);

  /**
   * @param other the {@link ObservableByteValue} holding the {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableByteValue}.
   */
  NumberExpression<?> multiply(ObservableByteValue other);

  /**
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  default NumberExpression<?> multiply(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return multiply((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return multiply((BigInteger) constant);
    } else if (constant instanceof Double) {
      return multiply(constant.doubleValue());
    } else if (constant instanceof Float) {
      return multiply(constant.floatValue());
    } else if (constant instanceof Long) {
      return multiply(constant.longValue());
    } else if (constant instanceof Integer) {
      return multiply(constant.intValue());
    } else if (constant instanceof Short) {
      return multiply(constant.shortValue());
    } else if (constant instanceof Byte) {
      return multiply(constant.byteValue());
    } else {
      return multiply(constant.doubleValue());
    }
  }

  /**
   * @param constant the constant {@link BigDecimal} to multiply.
   * @return a new {@link BigDecimalExpression} holding the product of this {@link #getValue() value} multiplied with
   *         the given {@code constant}.
   */
  default BigDecimalExpression multiply(BigDecimal constant) {

    return BigDecimalBinding.multiply(this, constant);
  }

  /**
   * @param constant the constant {@link BigInteger} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(BigInteger constant);

  /**
   * @param constant the constant {@code double} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(double constant);

  /**
   * @param constant the constant {@code float} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(float constant);

  /**
   * @param constant the constant {@code long} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(long constant);

  /**
   * @param constant the constant {@code int} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(int constant);

  /**
   * @param constant the constant {@code short} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(short constant);

  /**
   * @param constant the constant {@code byte} to multiply.
   * @return a new {@link NumberExpression} holding the product of this {@link #getValue() value} multiplied with the
   *         given {@code constant}.
   */
  NumberExpression<?> multiply(byte constant);

  /**
   * @param other the {@link ObservableValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableValue}.
   */
  default NumberExpression<?> divide(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return divide((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return divide((ObservableBigIntegerValue) other);
    } else if (other instanceof ObservableDoubleValue) {
      return divide((ObservableDoubleValue) other);
    } else if (other instanceof ObservableFloatValue) {
      return divide((ObservableFloatValue) other);
    } else if (other instanceof ObservableLongValue) {
      return divide((ObservableLongValue) other);
    } else if (other instanceof ObservableIntegerValue) {
      return divide((ObservableIntegerValue) other);
    } else if (other instanceof ObservableShortValue) {
      return divide((ObservableShortValue) other);
    } else if (other instanceof ObservableByteValue) {
      return divide((ObservableShortValue) other);
    } else {
      return DoubleBinding.divide(this, other);
    }
  }

  /**
   * @param other the {@link ObservableBigDecimalValue} holding the {@link Number} to divide.
   * @return a new {@link BigDecimalExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigDecimalValue}.
   */
  default BigDecimalExpression divide(ObservableBigDecimalValue other) {

    return BigDecimalBinding.divide(this, other);
  }

  /**
   * @param other the {@link ObservableBigIntegerValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableBigIntegerValue}.
   */
  NumberExpression<?> divide(ObservableBigIntegerValue other);

  /**
   * @param other the {@link ObservableDoubleValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableDoubleValue}.
   */
  NumberExpression<?> divide(ObservableDoubleValue other);

  /**
   * @param other the {@link ObservableFloatValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableFloatValue}.
   */
  NumberExpression<?> divide(ObservableFloatValue other);

  /**
   * @param other the {@link ObservableLongValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableLongValue}.
   */
  NumberExpression<?> divide(ObservableLongValue other);

  /**
   * @param other the {@link ObservableIntegerValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableIntegerValue}.
   */
  NumberExpression<?> divide(ObservableIntegerValue other);

  /**
   * @param other the {@link ObservableShortValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableShortValue}.
   */
  NumberExpression<?> divide(ObservableShortValue other);

  /**
   * @param other the {@link ObservableByteValue} holding the {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} with the
   *         {@link #getValue() value} of the given {@link ObservableByteValue}.
   */
  NumberExpression<?> divide(ObservableByteValue other);

  /**
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  default NumberExpression<?> divide(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return divide((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return divide((BigInteger) constant);
    } else if (constant instanceof Double) {
      return divide(constant.doubleValue());
    } else if (constant instanceof Float) {
      return divide(constant.floatValue());
    } else if (constant instanceof Long) {
      return divide(constant.longValue());
    } else if (constant instanceof Integer) {
      return divide(constant.intValue());
    } else if (constant instanceof Short) {
      return divide(constant.shortValue());
    } else if (constant instanceof Byte) {
      return divide(constant.byteValue());
    } else {
      return divide(constant.doubleValue());
    }
  }

  /**
   * @param constant the constant {@link BigDecimal} to divide.
   * @return a new {@link BigDecimalExpression} holding the quotient of this {@link #getValue() value} divided by the
   *         given {@code constant}.
   */
  default BigDecimalExpression divide(BigDecimal constant) {

    return BigDecimalBinding.divide(this, constant);
  }

  /**
   * @param constant the constant {@link BigInteger} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(BigInteger constant);

  /**
   * @param constant the constant {@code double} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(double constant);

  /**
   * @param constant the constant {@code float} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(float constant);

  /**
   * @param constant the constant {@code long} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(long constant);

  /**
   * @param constant the constant {@code int} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(int constant);

  /**
   * @param constant the constant {@code short} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(short constant);

  /**
   * @param constant the constant {@code byte} to divide.
   * @return a new {@link NumberExpression} holding the quotient of this {@link #getValue() value} divided by the given
   *         {@code constant}.
   */
  NumberExpression<?> divide(byte constant);

}
