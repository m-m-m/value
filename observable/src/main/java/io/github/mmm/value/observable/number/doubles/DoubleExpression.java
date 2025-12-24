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
  default DoubleExpression expNegate() {

    return DoubleBinding.negate(this);
  }

  @Override
  default NumberExpression<?> expAdd(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return expAdd((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return expAdd((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.expAdd(this, other);
    }
  }

  @Override
  default BigDecimalExpression expAdd(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableDoubleValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableFloatValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableLongValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableIntegerValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableShortValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableByteValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default NumberExpression<?> expAdd(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expAdd((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return expAdd((BigInteger) constant);
    } else {
      return expAdd(constant.doubleValue());
    }
  }

  @Override
  default BigDecimalExpression expAdd(BigInteger constant) {

    return BigDecimalBinding.add(this, constant);
  }

  @Override
  default DoubleExpression expAdd(double constant) {

    return DoubleBinding.add(this, constant);
  }

  @Override
  default DoubleExpression expAdd(float constant) {

    return expAdd((double) constant);
  }

  @Override
  default DoubleExpression expAdd(long constant) {

    return expAdd((double) constant);
  }

  @Override
  default DoubleExpression expAdd(int constant) {

    return expAdd((double) constant);
  }

  @Override
  default DoubleExpression expAdd(short constant) {

    return expAdd((double) constant);
  }

  @Override
  default DoubleExpression expAdd(byte constant) {

    return expAdd((double) constant);
  }

  @Override
  default NumberExpression<?> expSub(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return expSub((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return expSub((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.expSub(this, other);
    }
  }

  @Override
  default BigDecimalExpression expSub(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableDoubleValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableFloatValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableLongValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableIntegerValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableShortValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableByteValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default NumberExpression<?> expSub(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expSub((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return expSub((BigInteger) constant);
    } else {
      return expSub(constant.doubleValue());
    }
  }

  @Override
  default BigDecimalExpression expSub(BigInteger constant) {

    return BigDecimalBinding.subtract(this, constant);
  }

  @Override
  default DoubleExpression expSub(double constant) {

    return DoubleBinding.subtract(this, constant);
  }

  @Override
  default DoubleExpression expSub(float constant) {

    return expSub((double) constant);
  }

  @Override
  default DoubleExpression expSub(long constant) {

    return expSub((double) constant);
  }

  @Override
  default DoubleExpression expSub(int constant) {

    return expSub((double) constant);
  }

  @Override
  default DoubleExpression expSub(short constant) {

    return expSub((double) constant);
  }

  @Override
  default DoubleExpression expSub(byte constant) {

    return expSub((double) constant);
  }

  @Override
  default NumberExpression<?> expMul(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return expMul((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return expMul((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.expMul(this, other);
    }
  }

  @Override
  default BigDecimalExpression expMul(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableDoubleValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableFloatValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableLongValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableIntegerValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableShortValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableByteValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default NumberExpression<?> expMul(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expMul((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return expMul((BigInteger) constant);
    } else {
      return expMul(constant.doubleValue());
    }
  }

  @Override
  default BigDecimalExpression expMul(BigInteger constant) {

    return BigDecimalBinding.multiply(this, constant);
  }

  @Override
  default DoubleExpression expMul(double constant) {

    return DoubleBinding.multiply(this, constant);
  }

  @Override
  default DoubleExpression expMul(float constant) {

    return expMul((double) constant);
  }

  @Override
  default DoubleExpression expMul(long constant) {

    return expMul((double) constant);
  }

  @Override
  default DoubleExpression expMul(int constant) {

    return expMul((double) constant);
  }

  @Override
  default DoubleExpression expMul(short constant) {

    return expMul((double) constant);
  }

  @Override
  default DoubleExpression expMul(byte constant) {

    return expMul((double) constant);
  }

  @Override
  default NumberExpression<?> expDiv(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return expDiv((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return expDiv((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.expDiv(this, other);
    }
  }

  @Override
  default BigDecimalExpression expDiv(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableDoubleValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableFloatValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableLongValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableIntegerValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableShortValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableByteValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default NumberExpression<?> expDiv(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expDiv((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return expDiv((BigInteger) constant);
    } else {
      return expDiv(constant.doubleValue());
    }
  }

  @Override
  default BigDecimalExpression expDiv(BigInteger constant) {

    return BigDecimalBinding.divide(this, constant);
  }

  @Override
  default DoubleExpression expDiv(double constant) {

    return DoubleBinding.divide(this, constant);
  }

  @Override
  default DoubleExpression expDiv(float constant) {

    return expDiv((double) constant);
  }

  @Override
  default DoubleExpression expDiv(long constant) {

    return expDiv((double) constant);
  }

  @Override
  default DoubleExpression expDiv(int constant) {

    return expDiv((double) constant);
  }

  @Override
  default DoubleExpression expDiv(short constant) {

    return expDiv((double) constant);
  }

  @Override
  default DoubleExpression expDiv(byte constant) {

    return expDiv((double) constant);
  }

}
