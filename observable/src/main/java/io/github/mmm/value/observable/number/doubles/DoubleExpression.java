package io.github.mmm.value.observable.number.doubles;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalBinding;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;
import io.github.mmm.value.observable.number.bigdecimal.ObservableBigDecimalValue;
import io.github.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import io.github.mmm.value.observable.number.bytes.ObservableByteValue;
import io.github.mmm.value.observable.number.floats.ObservableFloatValue;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.longs.ObservableLongValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;

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
  default BigDecimalExpression add(ObservableBigIntegerValue other) {

    return BigDecimalBinding.add(this, other);
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
  default BigDecimalExpression add(BigInteger constant) {

    return BigDecimalBinding.add(this, constant);
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
  default BigDecimalExpression subtract(ObservableBigIntegerValue other) {

    return BigDecimalBinding.subtract(this, other);
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
  default BigDecimalExpression subtract(BigInteger constant) {

    return BigDecimalBinding.subtract(this, constant);
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
  default BigDecimalExpression multiply(ObservableBigIntegerValue other) {

    return BigDecimalBinding.multiply(this, other);
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
  default BigDecimalExpression multiply(BigInteger constant) {

    return BigDecimalBinding.multiply(this, constant);
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
  default BigDecimalExpression divide(ObservableBigIntegerValue other) {

    return BigDecimalBinding.divide(this, other);
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
  default BigDecimalExpression divide(BigInteger constant) {

    return BigDecimalBinding.divide(this, constant);
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
