package io.github.mmm.value.observable.number.floats;

import java.math.BigInteger;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalBinding;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;
import io.github.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import io.github.mmm.value.observable.number.bytes.ObservableByteValue;
import io.github.mmm.value.observable.number.doubles.DoubleBinding;
import io.github.mmm.value.observable.number.doubles.DoubleExpression;
import io.github.mmm.value.observable.number.doubles.ObservableDoubleValue;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.longs.ObservableLongValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link Float} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface FloatExpression extends ObservableFloatValue, NumberExpression<Float> {

  @Override
  default FloatExpression expNegate() {

    return FloatBinding.negate(this);
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
  default FloatExpression expAdd(ObservableFloatValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression expAdd(ObservableLongValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression expAdd(ObservableIntegerValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression expAdd(ObservableShortValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression expAdd(ObservableByteValue other) {

    return FloatBinding.add(this, other);
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
  default FloatExpression expAdd(float constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression expAdd(long constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression expAdd(int constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression expAdd(short constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression expAdd(byte constant) {

    return FloatBinding.add(this, constant);
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
  default FloatExpression expSub(ObservableFloatValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression expSub(ObservableLongValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression expSub(ObservableIntegerValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression expSub(ObservableShortValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression expSub(ObservableByteValue other) {

    return FloatBinding.subtract(this, other);
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
  default FloatExpression expSub(float constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression expSub(long constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression expSub(int constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression expSub(short constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression expSub(byte constant) {

    return FloatBinding.subtract(this, constant);
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
  default FloatExpression expMul(ObservableFloatValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression expMul(ObservableLongValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression expMul(ObservableIntegerValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression expMul(ObservableShortValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression expMul(ObservableByteValue other) {

    return FloatBinding.multiply(this, other);
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
  default FloatExpression expMul(float constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression expMul(long constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression expMul(int constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression expMul(short constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression expMul(byte constant) {

    return FloatBinding.multiply(this, constant);
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
  default FloatExpression expDiv(ObservableFloatValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression expDiv(ObservableLongValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression expDiv(ObservableIntegerValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression expDiv(ObservableShortValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression expDiv(ObservableByteValue other) {

    return FloatBinding.divide(this, other);
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
  default FloatExpression expDiv(float constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression expDiv(long constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression expDiv(int constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression expDiv(short constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression expDiv(byte constant) {

    return FloatBinding.divide(this, constant);
  }

}
