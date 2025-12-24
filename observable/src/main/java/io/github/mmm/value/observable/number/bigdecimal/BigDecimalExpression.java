package io.github.mmm.value.observable.number.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import io.github.mmm.value.observable.number.bytes.ObservableByteValue;
import io.github.mmm.value.observable.number.doubles.ObservableDoubleValue;
import io.github.mmm.value.observable.number.floats.ObservableFloatValue;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.longs.ObservableLongValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link BigDecimal} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface BigDecimalExpression extends ObservableBigDecimalValue, NumberExpression<BigDecimal> {

  @Override
  default BigDecimalExpression expNegate() {

    return BigDecimalBinding.negate(this);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expAdd(this, other);
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
  default BigDecimalExpression expAdd(ObservableLongValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableIntegerValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableShortValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(ObservableByteValue other) {

    return BigDecimalBinding.expAdd(this, other);
  }

  @Override
  default BigDecimalExpression expAdd(Number constant) {

    return BigDecimalBinding.add(this, constant);
  }

  @Override
  default BigDecimalExpression expAdd(BigInteger constant) {

    return expAdd(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression expAdd(double constant) {

    return expAdd(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expAdd(float constant) {

    return expAdd((double) constant);
  }

  @Override
  default BigDecimalExpression expAdd(long constant) {

    return expAdd((double) constant);
  }

  @Override
  default BigDecimalExpression expAdd(int constant) {

    return expAdd((double) constant);
  }

  @Override
  default BigDecimalExpression expAdd(short constant) {

    return expAdd((double) constant);
  }

  @Override
  default BigDecimalExpression expAdd(byte constant) {

    return expAdd((double) constant);
  }

  @Override
  default BigDecimalExpression expSub(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigDecimalExpression expSub(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expSub(this, other);
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
  default BigDecimalExpression expSub(ObservableLongValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigDecimalExpression expSub(ObservableIntegerValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigDecimalExpression expSub(ObservableShortValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigDecimalExpression expSub(ObservableByteValue other) {

    return BigDecimalBinding.expSub(this, other);
  }

  @Override
  default BigDecimalExpression expSub(Number constant) {

    return BigDecimalBinding.subtract(this, constant);
  }

  @Override
  default BigDecimalExpression expSub(BigInteger constant) {

    return expSub(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression expSub(double constant) {

    return expSub(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expSub(float constant) {

    return expSub((double) constant);
  }

  @Override
  default BigDecimalExpression expSub(long constant) {

    return expSub((double) constant);
  }

  @Override
  default BigDecimalExpression expSub(int constant) {

    return expSub((double) constant);
  }

  @Override
  default BigDecimalExpression expSub(short constant) {

    return expSub((double) constant);
  }

  @Override
  default BigDecimalExpression expSub(byte constant) {

    return expSub((double) constant);
  }

  @Override
  default BigDecimalExpression expMul(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigDecimalExpression expMul(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expMul(this, other);
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
  default BigDecimalExpression expMul(ObservableLongValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigDecimalExpression expMul(ObservableIntegerValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigDecimalExpression expMul(ObservableShortValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigDecimalExpression expMul(ObservableByteValue other) {

    return BigDecimalBinding.expMul(this, other);
  }

  @Override
  default BigDecimalExpression expMul(Number constant) {

    return BigDecimalBinding.multiply(this, constant);
  }

  @Override
  default BigDecimalExpression expMul(BigInteger constant) {

    return expMul(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression expMul(double constant) {

    return expMul(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expMul(float constant) {

    return expMul((double) constant);
  }

  @Override
  default BigDecimalExpression expMul(long constant) {

    return expMul((double) constant);
  }

  @Override
  default BigDecimalExpression expMul(int constant) {

    return expMul((double) constant);
  }

  @Override
  default BigDecimalExpression expMul(short constant) {

    return expMul((double) constant);
  }

  @Override
  default BigDecimalExpression expMul(byte constant) {

    return expMul((double) constant);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableBigIntegerValue other) {

    return BigDecimalBinding.expDiv(this, other);
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
  default BigDecimalExpression expDiv(ObservableLongValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableIntegerValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableShortValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(ObservableByteValue other) {

    return BigDecimalBinding.expDiv(this, other);
  }

  @Override
  default BigDecimalExpression expDiv(Number constant) {

    return BigDecimalBinding.divide(this, constant);
  }

  @Override
  default BigDecimalExpression expDiv(BigInteger constant) {

    return expDiv(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression expDiv(double constant) {

    return expDiv(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression expDiv(float constant) {

    return expDiv((double) constant);
  }

  @Override
  default BigDecimalExpression expDiv(long constant) {

    return expDiv((double) constant);
  }

  @Override
  default BigDecimalExpression expDiv(int constant) {

    return expDiv((double) constant);
  }

  @Override
  default BigDecimalExpression expDiv(short constant) {

    return expDiv((double) constant);
  }

  @Override
  default BigDecimalExpression expDiv(byte constant) {

    return expDiv((double) constant);
  }

}
