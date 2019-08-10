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
 * {@link ComparableExpression} for {@link Number}.
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
      return add((ObservableShortValue) other);
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

  //
  // default NumberBinding subtract(ObservableNumberValue other) {
  //
  // return Bindings.subtract(this, other);
  // }
  //
  // default DoubleBinding subtract(double other) {
  //
  // return Bindings.subtract(this, other);
  // }
  //
  // default NumberBinding subtract(float other) {
  //
  // return Bindings.subtract(this, other);
  // }
  //
  // default NumberBinding subtract(long other) {
  //
  // return Bindings.subtract(this, other);
  // }
  //
  // default NumberBinding subtract(int other) {
  //
  // return Bindings.subtract(this, other);
  // }
  //
  // default NumberBinding multiply(ObservableNumberValue other) {
  //
  // return Bindings.multiply(this, other);
  // }
  //
  // default DoubleBinding multiply(double other) {
  //
  // return Bindings.multiply(this, other);
  // }
  //
  // default NumberBinding multiply(float other) {
  //
  // return Bindings.multiply(this, other);
  // }
  //
  // default NumberBinding multiply(long other) {
  //
  // return Bindings.multiply(this, other);
  // }
  //
  // default NumberBinding multiply(int other) {
  //
  // return Bindings.multiply(this, other);
  // }
  //
  // default NumberBinding divide(ObservableNumberValue other) {
  //
  // return Bindings.divide(this, other);
  // }
  //
  // default DoubleBinding divide(double other) {
  //
  // return Bindings.divide(this, other);
  // }
  //
  // default NumberBinding divide(float other) {
  //
  // return Bindings.divide(this, other);
  // }
  //
  // default NumberBinding divide(long other) {
  //
  // return Bindings.divide(this, other);
  // }
  //
  // default NumberBinding divide(int other) {
  //
  // return Bindings.divide(this, other);
  // }
  //
  // default BooleanBinding isEqualTo(ObservableNumberValue other) {
  //
  // return Bindings.equal(this, other);
  // }
  //
  // default BooleanBinding isEqualTo(ObservableNumberValue other, double epsilon) {
  //
  // return Bindings.equal(this, other);
  // }
  //
  // default BooleanBinding isEqualTo(double other, double epsilon) {
  //
  // return Bindings.equal(this, other, epsilon);
  // }
  //
  // default BooleanBinding isEqualTo(float other, double epsilon) {
  //
  // return Bindings.equal(this, other, epsilon);
  // }
  //
  // default BooleanBinding isEqualTo(long other) {
  //
  // return Bindings.equal(this, other);
  // }
  //
  // default BooleanBinding isEqualTo(long other, double epsilon) {
  //
  // return Bindings.equal(this, other, epsilon);
  // }
  //
  // default BooleanBinding isEqualTo(int other) {
  //
  // return Bindings.equal(this, other);
  // }
  //
  // default BooleanBinding isEqualTo(int other, double epsilon) {
  //
  // return Bindings.equal(this, other, epsilon);
  // }
  //
  // default BooleanBinding isNotEqualTo(ObservableNumberValue other) {
  //
  // return Bindings.notEqual(this, other);
  // }
  //
  // default BooleanBinding isNotEqualTo(ObservableNumberValue other, double epsilon) {
  //
  // return Bindings.notEqual(this, other, epsilon);
  // }
  //
  // default BooleanBinding isNotEqualTo(double other, double epsilon) {
  //
  // return Bindings.notEqual(this, other, epsilon);
  // }
  //
  // default BooleanBinding isNotEqualTo(float other, double epsilon) {
  //
  // return Bindings.notEqual(this, other, epsilon);
  // }
  //
  // default BooleanBinding isNotEqualTo(long other) {
  //
  // return Bindings.notEqual(this, other);
  // }
  //
  // default BooleanBinding isNotEqualTo(long other, double epsilon) {
  //
  // return Bindings.notEqual(this, other, epsilon);
  // }
  //
  // default BooleanBinding isNotEqualTo(int other) {
  //
  // return Bindings.notEqual(this, other);
  // }
  //
  // default BooleanBinding isNotEqualTo(int other, double epsilon) {
  //
  // return Bindings.notEqual(this, other, epsilon);
  // }
  //
  // default BooleanBinding greaterThan(ObservableNumberValue other) {
  //
  // return Bindings.greaterThan(this, other);
  // }
  //
  // default BooleanBinding greaterThan(double other) {
  //
  // return Bindings.greaterThan(this, other);
  // }
  //
  // default BooleanBinding greaterThan(float other) {
  //
  // return Bindings.greaterThan(this, other);
  // }
  //
  // default BooleanBinding greaterThan(long other) {
  //
  // return Bindings.greaterThan(this, other);
  // }
  //
  // default BooleanBinding greaterThan(int other) {
  //
  // return Bindings.greaterThan(this, other);
  // }
  //
  // default BooleanBinding lessThan(ObservableNumberValue other) {
  //
  // return Bindings.lessThan(this, other);
  // }
  //
  // default BooleanBinding lessThan(double other) {
  //
  // return Bindings.lessThan(this, other);
  // }
  //
  // default BooleanBinding lessThan(float other) {
  //
  // return Bindings.lessThan(this, other);
  // }
  //
  // default BooleanBinding lessThan(long other) {
  //
  // return Bindings.lessThan(this, other);
  // }
  //
  // default BooleanBinding lessThan(int other) {
  //
  // return Bindings.lessThan(this, other);
  // }
  //
  // default BooleanBinding greaterThanOrEqualTo(ObservableNumberValue other) {
  //
  // return Bindings.greaterThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding greaterThanOrEqualTo(double other) {
  //
  // return Bindings.greaterThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding greaterThanOrEqualTo(float other) {
  //
  // return Bindings.greaterThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding greaterThanOrEqualTo(long other) {
  //
  // return Bindings.greaterThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding greaterThanOrEqualTo(int other) {
  //
  // return Bindings.greaterThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding lessThanOrEqualTo(ObservableNumberValue other) {
  //
  // return Bindings.lessThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding lessThanOrEqualTo(double other) {
  //
  // return Bindings.lessThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding lessThanOrEqualTo(float other) {
  //
  // return Bindings.lessThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding lessThanOrEqualTo(long other) {
  //
  // return Bindings.lessThanOrEqual(this, other);
  // }
  //
  // default BooleanBinding lessThanOrEqualTo(int other) {
  //
  // return Bindings.lessThanOrEqual(this, other);
  // }
  //
  // @SuppressWarnings("restriction")
  //
  // default StringBinding asString() {
  //
  // return (StringBinding) com.sun.javafx.binding.StringFormatter.convert(this);
  // }
  //
  // default StringBinding asString(String format) {
  //
  // return (StringBinding) Bindings.format(format, this);
  // }
  //
  // default StringBinding asString(Locale locale, String format) {
  //
  // return (StringBinding) Bindings.format(locale, format, this);
  // }

}
