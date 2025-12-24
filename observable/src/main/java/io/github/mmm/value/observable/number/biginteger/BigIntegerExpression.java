package io.github.mmm.value.observable.number.biginteger;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalBinding;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;
import io.github.mmm.value.observable.number.bigdecimal.ObservableBigDecimalValue;
import io.github.mmm.value.observable.number.bytes.ObservableByteValue;
import io.github.mmm.value.observable.number.doubles.ObservableDoubleValue;
import io.github.mmm.value.observable.number.floats.ObservableFloatValue;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.longs.ObservableLongValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} for {@link BigInteger}.
 *
 * @since 1.0.0
 */
public interface BigIntegerExpression extends ObservableBigIntegerValue, NumberExpression<BigInteger> {

  @Override
  default BigIntegerExpression expNegate() {

    return BigIntegerBinding.negate(this);
  }

  @Override
  default NumberExpression<?> expAdd(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.expAdd(this, other);
    } else {
      return BigIntegerBinding.add(this, other);
    }
  }

  @Override
  default BigIntegerExpression expAdd(ObservableBigIntegerValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableDoubleValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableFloatValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigIntegerExpression expAdd(ObservableLongValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression expAdd(ObservableIntegerValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression expAdd(ObservableShortValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression expAdd(ObservableByteValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default NumberExpression<?> expAdd(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expAdd((BigDecimal) constant);
    } else {
      return BigIntegerBinding.add(this, constant);
    }
  }

  @Override
  default BigIntegerExpression expAdd(BigInteger constant) {

    return BigIntegerBinding.add(this, constant);
  }

  @Override
  default BigDecimalExpression expAdd(double constant) {

    return BigDecimalBinding.expAdd(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expAdd(float constant) {

    return expAdd((double) constant);
  }

  @Override
  default BigIntegerExpression expAdd(long constant) {

    return expAdd(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expAdd(int constant) {

    return expAdd(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expAdd(short constant) {

    return expAdd(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expAdd(byte constant) {

    return expAdd(BigInteger.valueOf(constant));
  }

  @Override
  default NumberExpression<?> expSub(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.expSub(this, other);
    } else {
      return BigIntegerBinding.subtract(this, other);
    }
  }

  @Override
  default BigIntegerExpression expSub(ObservableBigIntegerValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression expSub(ObservableDoubleValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigDecimalExpression expSub(ObservableFloatValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigIntegerExpression expSub(ObservableLongValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression expSub(ObservableIntegerValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression expSub(ObservableShortValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression expSub(ObservableByteValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default NumberExpression<?> expSub(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expSub((BigDecimal) constant);
    } else {
      return BigIntegerBinding.subtract(this, constant);
    }
  }

  @Override
  default BigIntegerExpression expSub(BigInteger constant) {

    return BigIntegerBinding.subtract(this, constant);
  }

  @Override
  default BigDecimalExpression expSub(double constant) {

    return BigDecimalBinding.expSub(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expSub(float constant) {

    return expSub((double) constant);
  }

  @Override
  default BigIntegerExpression expSub(long constant) {

    return expSub(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expSub(int constant) {

    return expSub(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expSub(short constant) {

    return expSub(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expSub(byte constant) {

    return expSub(BigInteger.valueOf(constant));
  }

  @Override
  default NumberExpression<?> expMul(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.expMul(this, other);
    } else {
      return BigIntegerBinding.multiply(this, other);
    }
  }

  @Override
  default BigIntegerExpression expMul(ObservableBigIntegerValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression expMul(ObservableDoubleValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigDecimalExpression expMul(ObservableFloatValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigIntegerExpression expMul(ObservableLongValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression expMul(ObservableIntegerValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression expMul(ObservableShortValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression expMul(ObservableByteValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default NumberExpression<?> expMul(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expMul((BigDecimal) constant);
    } else {
      return BigIntegerBinding.multiply(this, constant);
    }
  }

  @Override
  default BigIntegerExpression expMul(BigInteger constant) {

    return BigIntegerBinding.multiply(this, constant);
  }

  @Override
  default BigDecimalExpression expMul(double constant) {

    return BigDecimalBinding.expMul(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expMul(float constant) {

    return expMul((double) constant);
  }

  @Override
  default BigIntegerExpression expMul(long constant) {

    return expMul(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expMul(int constant) {

    return expMul(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expMul(short constant) {

    return expMul(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expMul(byte constant) {

    return expMul(BigInteger.valueOf(constant));
  }

  @Override
  default NumberExpression<?> expDiv(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.expDiv(this, other);
    } else {
      return BigIntegerBinding.divide(this, other);
    }
  }

  @Override
  default BigIntegerExpression expDiv(ObservableBigIntegerValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableDoubleValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableFloatValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigIntegerExpression expDiv(ObservableLongValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression expDiv(ObservableIntegerValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression expDiv(ObservableShortValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression expDiv(ObservableByteValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default NumberExpression<?> expDiv(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return expDiv((BigDecimal) constant);
    } else {
      return BigIntegerBinding.divide(this, constant);
    }
  }

  @Override
  default BigIntegerExpression expDiv(BigInteger constant) {

    return BigIntegerBinding.divide(this, constant);
  }

  @Override
  default BigDecimalExpression expDiv(double constant) {

    return BigDecimalBinding.expDiv(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expDiv(float constant) {

    return expDiv((double) constant);
  }

  @Override
  default BigIntegerExpression expDiv(long constant) {

    return expDiv(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expDiv(int constant) {

    return expDiv(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expDiv(short constant) {

    return expDiv(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression expDiv(byte constant) {

    return expDiv(BigInteger.valueOf(constant));
  }
}
