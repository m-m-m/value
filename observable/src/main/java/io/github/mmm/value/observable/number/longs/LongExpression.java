package io.github.mmm.value.observable.number.longs;

import java.math.BigInteger;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.biginteger.BigIntegerBinding;
import io.github.mmm.value.observable.number.biginteger.BigIntegerExpression;
import io.github.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import io.github.mmm.value.observable.number.bytes.ObservableByteValue;
import io.github.mmm.value.observable.number.doubles.DoubleBinding;
import io.github.mmm.value.observable.number.doubles.DoubleExpression;
import io.github.mmm.value.observable.number.doubles.ObservableDoubleValue;
import io.github.mmm.value.observable.number.floats.FloatBinding;
import io.github.mmm.value.observable.number.floats.FloatExpression;
import io.github.mmm.value.observable.number.floats.ObservableFloatValue;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link Long} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface LongExpression extends ObservableLongValue, NumberExpression<Long> {

  @Override
  default LongExpression expNegate() {

    return LongBinding.negate(this);
  }

  @Override
  default BigIntegerExpression expAdd(ObservableBigIntegerValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default DoubleExpression expAdd(ObservableDoubleValue other) {

    return DoubleBinding.expAdd(this, other);
  }

  @Override
  default FloatExpression expAdd(ObservableFloatValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default LongExpression expAdd(ObservableLongValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default LongExpression expAdd(ObservableIntegerValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default LongExpression expAdd(ObservableShortValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default LongExpression expAdd(ObservableByteValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression expAdd(BigInteger constant) {

    return BigIntegerBinding.add(this, constant);
  }

  @Override
  default DoubleExpression expAdd(double constant) {

    return DoubleBinding.add(this, constant);
  }

  @Override
  default FloatExpression expAdd(float constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default LongExpression expAdd(long constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default LongExpression expAdd(int constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default LongExpression expAdd(short constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default LongExpression expAdd(byte constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default BigIntegerExpression expSub(ObservableBigIntegerValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default DoubleExpression expSub(ObservableDoubleValue other) {

    return DoubleBinding.expSub(this, other);
  }

  @Override
  default FloatExpression expSub(ObservableFloatValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default LongExpression expSub(ObservableLongValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default LongExpression expSub(ObservableIntegerValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default LongExpression expSub(ObservableShortValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default LongExpression expSub(ObservableByteValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression expSub(BigInteger constant) {

    return BigIntegerBinding.subtract(this, constant);
  }

  @Override
  default DoubleExpression expSub(double constant) {

    return DoubleBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression expSub(float constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default LongExpression expSub(long constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default LongExpression expSub(int constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default LongExpression expSub(short constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default LongExpression expSub(byte constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default BigIntegerExpression expMul(ObservableBigIntegerValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default DoubleExpression expMul(ObservableDoubleValue other) {

    return DoubleBinding.expMul(this, other);
  }

  @Override
  default FloatExpression expMul(ObservableFloatValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default LongExpression expMul(ObservableLongValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default LongExpression expMul(ObservableIntegerValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default LongExpression expMul(ObservableShortValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default LongExpression expMul(ObservableByteValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression expMul(BigInteger constant) {

    return BigIntegerBinding.multiply(this, constant);
  }

  @Override
  default DoubleExpression expMul(double constant) {

    return DoubleBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression expMul(float constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default LongExpression expMul(long constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default LongExpression expMul(int constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default LongExpression expMul(short constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default LongExpression expMul(byte constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default BigIntegerExpression expDiv(ObservableBigIntegerValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default DoubleExpression expDiv(ObservableDoubleValue other) {

    return DoubleBinding.expDiv(this, other);
  }

  @Override
  default FloatExpression expDiv(ObservableFloatValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default LongExpression expDiv(ObservableLongValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default LongExpression expDiv(ObservableIntegerValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default LongExpression expDiv(ObservableShortValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default LongExpression expDiv(ObservableByteValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression expDiv(BigInteger constant) {

    return BigIntegerBinding.divide(this, constant);
  }

  @Override
  default DoubleExpression expDiv(double constant) {

    return DoubleBinding.divide(this, constant);
  }

  @Override
  default FloatExpression expDiv(float constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default LongExpression expDiv(long constant) {

    return LongBinding.divide(this, constant);
  }

  @Override
  default LongExpression expDiv(int constant) {

    return LongBinding.divide(this, constant);
  }

  @Override
  default LongExpression expDiv(short constant) {

    return LongBinding.divide(this, constant);
  }

  @Override
  default LongExpression expDiv(byte constant) {

    return LongBinding.divide(this, constant);
  }

}
