package io.github.mmm.value.observable.number.bytes;

import java.math.BigInteger;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.biginteger.BigIntegerBinding;
import io.github.mmm.value.observable.number.biginteger.BigIntegerExpression;
import io.github.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import io.github.mmm.value.observable.number.doubles.DoubleBinding;
import io.github.mmm.value.observable.number.doubles.DoubleExpression;
import io.github.mmm.value.observable.number.doubles.ObservableDoubleValue;
import io.github.mmm.value.observable.number.floats.FloatBinding;
import io.github.mmm.value.observable.number.floats.FloatExpression;
import io.github.mmm.value.observable.number.floats.ObservableFloatValue;
import io.github.mmm.value.observable.number.integers.IntegerBinding;
import io.github.mmm.value.observable.number.integers.IntegerExpression;
import io.github.mmm.value.observable.number.integers.ObservableIntegerValue;
import io.github.mmm.value.observable.number.longs.LongBinding;
import io.github.mmm.value.observable.number.longs.LongExpression;
import io.github.mmm.value.observable.number.longs.ObservableLongValue;
import io.github.mmm.value.observable.number.shorts.ObservableShortValue;
import io.github.mmm.value.observable.number.shorts.ShortBinding;
import io.github.mmm.value.observable.number.shorts.ShortExpression;

/**
 * {@link NumberExpression} with {@link Byte} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ByteExpression extends ObservableByteValue, NumberExpression<Byte> {

  @Override
  default ByteExpression expNegate() {

    return ByteBinding.negate(this);
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
  default IntegerExpression expAdd(ObservableIntegerValue other) {

    return IntegerBinding.add(this, other);
  }

  @Override
  default ShortExpression expAdd(ObservableShortValue other) {

    return ShortBinding.add(this, other);
  }

  @Override
  default ByteExpression expAdd(ObservableByteValue other) {

    return ByteBinding.add(this, other);
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
  default IntegerExpression expAdd(int constant) {

    return IntegerBinding.add(this, constant);
  }

  @Override
  default ShortExpression expAdd(short constant) {

    return ShortBinding.add(this, constant);
  }

  @Override
  default ByteExpression expAdd(byte constant) {

    return ByteBinding.add(this, constant);
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
  default IntegerExpression expSub(ObservableIntegerValue other) {

    return IntegerBinding.subtract(this, other);
  }

  @Override
  default ShortExpression expSub(ObservableShortValue other) {

    return ShortBinding.subtract(this, other);
  }

  @Override
  default ByteExpression expSub(ObservableByteValue other) {

    return ByteBinding.subtract(this, other);
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
  default IntegerExpression expSub(int constant) {

    return IntegerBinding.subtract(this, constant);
  }

  @Override
  default ShortExpression expSub(short constant) {

    return ShortBinding.subtract(this, constant);
  }

  @Override
  default ByteExpression expSub(byte constant) {

    return ByteBinding.subtract(this, constant);
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
  default IntegerExpression expMul(ObservableIntegerValue other) {

    return IntegerBinding.multiply(this, other);
  }

  @Override
  default ShortExpression expMul(ObservableShortValue other) {

    return ShortBinding.multiply(this, other);
  }

  @Override
  default ByteExpression expMul(ObservableByteValue other) {

    return ByteBinding.multiply(this, other);
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
  default IntegerExpression expMul(int constant) {

    return IntegerBinding.multiply(this, constant);
  }

  @Override
  default ShortExpression expMul(short constant) {

    return ShortBinding.multiply(this, constant);
  }

  @Override
  default ByteExpression expMul(byte constant) {

    return ByteBinding.multiply(this, constant);
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
  default IntegerExpression expDiv(ObservableIntegerValue other) {

    return IntegerBinding.divide(this, other);
  }

  @Override
  default ShortExpression expDiv(ObservableShortValue other) {

    return ShortBinding.divide(this, other);
  }

  @Override
  default ByteExpression expDiv(ObservableByteValue other) {

    return ByteBinding.divide(this, other);
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
  default IntegerExpression expDiv(int constant) {

    return IntegerBinding.divide(this, constant);
  }

  @Override
  default ShortExpression expDiv(short constant) {

    return ShortBinding.divide(this, constant);
  }

  @Override
  default ByteExpression expDiv(byte constant) {

    return ByteBinding.divide(this, constant);
  }

}
