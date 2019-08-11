package net.sf.mmm.value.observable.numbers.doubles;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigdecimals.ObservableBigDecimalValue;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerBinding;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link Double} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface DoubleExpression extends ObservableDoubleValue, NumberExpression<Double> {

  @Override
  default DoubleExpression negate() {

    return DoubleBinding.negate(this);
  }

  @Override
  default NumberExpression<?> add(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return add((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return add((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.add(this, other);
    }
  }

  @Override
  default BigIntegerExpression add(ObservableBigIntegerValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableDoubleValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableFloatValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableLongValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableIntegerValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableShortValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableByteValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default NumberExpression<?> add(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return add((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return add((BigInteger) constant);
    } else {
      return add(constant.doubleValue());
    }
  }

  @Override
  default BigIntegerExpression add(BigInteger constant) {

    return BigIntegerBinding.add(this, constant);
  }

  @Override
  default DoubleExpression add(double constant) {

    return DoubleBinding.add(this, constant);
  }

  @Override
  default DoubleExpression add(float constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(long constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(int constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(short constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(byte constant) {

    return add((double) constant);
  }

  @Override
  default NumberExpression<?> subtract(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return subtract((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return subtract((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.subtract(this, other);
    }
  }

  @Override
  default BigIntegerExpression subtract(ObservableBigIntegerValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression subtract(ObservableDoubleValue other) {

    return DoubleBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression subtract(ObservableFloatValue other) {

    return DoubleBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression subtract(ObservableLongValue other) {

    return DoubleBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression subtract(ObservableIntegerValue other) {

    return DoubleBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression subtract(ObservableShortValue other) {

    return DoubleBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression subtract(ObservableByteValue other) {

    return DoubleBinding.subtract(this, other);
  }

  @Override
  default NumberExpression<?> subtract(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return subtract((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return subtract((BigInteger) constant);
    } else {
      return subtract(constant.doubleValue());
    }
  }

  @Override
  default BigIntegerExpression subtract(BigInteger constant) {

    return BigIntegerBinding.subtract(this, constant);
  }

  @Override
  default DoubleExpression subtract(double constant) {

    return DoubleBinding.subtract(this, constant);
  }

  @Override
  default DoubleExpression subtract(float constant) {

    return subtract((double) constant);
  }

  @Override
  default DoubleExpression subtract(long constant) {

    return subtract((double) constant);
  }

  @Override
  default DoubleExpression subtract(int constant) {

    return subtract((double) constant);
  }

  @Override
  default DoubleExpression subtract(short constant) {

    return subtract((double) constant);
  }

  @Override
  default DoubleExpression subtract(byte constant) {

    return subtract((double) constant);
  }

  @Override
  default NumberExpression<?> multiply(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return multiply((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return multiply((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.multiply(this, other);
    }
  }

  @Override
  default BigIntegerExpression multiply(ObservableBigIntegerValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression multiply(ObservableDoubleValue other) {

    return DoubleBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression multiply(ObservableFloatValue other) {

    return DoubleBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression multiply(ObservableLongValue other) {

    return DoubleBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression multiply(ObservableIntegerValue other) {

    return DoubleBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression multiply(ObservableShortValue other) {

    return DoubleBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression multiply(ObservableByteValue other) {

    return DoubleBinding.multiply(this, other);
  }

  @Override
  default NumberExpression<?> multiply(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return multiply((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return multiply((BigInteger) constant);
    } else {
      return multiply(constant.doubleValue());
    }
  }

  @Override
  default BigIntegerExpression multiply(BigInteger constant) {

    return BigIntegerBinding.multiply(this, constant);
  }

  @Override
  default DoubleExpression multiply(double constant) {

    return DoubleBinding.multiply(this, constant);
  }

  @Override
  default DoubleExpression multiply(float constant) {

    return multiply((double) constant);
  }

  @Override
  default DoubleExpression multiply(long constant) {

    return multiply((double) constant);
  }

  @Override
  default DoubleExpression multiply(int constant) {

    return multiply((double) constant);
  }

  @Override
  default DoubleExpression multiply(short constant) {

    return multiply((double) constant);
  }

  @Override
  default DoubleExpression multiply(byte constant) {

    return multiply((double) constant);
  }

  @Override
  default NumberExpression<?> divide(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return divide((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return divide((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.divide(this, other);
    }
  }

  @Override
  default BigIntegerExpression divide(ObservableBigIntegerValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default DoubleExpression divide(ObservableDoubleValue other) {

    return DoubleBinding.divide(this, other);
  }

  @Override
  default DoubleExpression divide(ObservableFloatValue other) {

    return DoubleBinding.divide(this, other);
  }

  @Override
  default DoubleExpression divide(ObservableLongValue other) {

    return DoubleBinding.divide(this, other);
  }

  @Override
  default DoubleExpression divide(ObservableIntegerValue other) {

    return DoubleBinding.divide(this, other);
  }

  @Override
  default DoubleExpression divide(ObservableShortValue other) {

    return DoubleBinding.divide(this, other);
  }

  @Override
  default DoubleExpression divide(ObservableByteValue other) {

    return DoubleBinding.divide(this, other);
  }

  @Override
  default NumberExpression<?> divide(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return divide((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return divide((BigInteger) constant);
    } else {
      return divide(constant.doubleValue());
    }
  }

  @Override
  default BigIntegerExpression divide(BigInteger constant) {

    return BigIntegerBinding.divide(this, constant);
  }

  @Override
  default DoubleExpression divide(double constant) {

    return DoubleBinding.divide(this, constant);
  }

  @Override
  default DoubleExpression divide(float constant) {

    return divide((double) constant);
  }

  @Override
  default DoubleExpression divide(long constant) {

    return divide((double) constant);
  }

  @Override
  default DoubleExpression divide(int constant) {

    return divide((double) constant);
  }

  @Override
  default DoubleExpression divide(short constant) {

    return divide((double) constant);
  }

  @Override
  default DoubleExpression divide(byte constant) {

    return divide((double) constant);
  }

}
