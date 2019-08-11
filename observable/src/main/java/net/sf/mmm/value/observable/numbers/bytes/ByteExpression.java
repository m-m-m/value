package net.sf.mmm.value.observable.numbers.bytes;

import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerBinding;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.doubles.DoubleBinding;
import net.sf.mmm.value.observable.numbers.doubles.DoubleExpression;
import net.sf.mmm.value.observable.numbers.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.numbers.floats.FloatBinding;
import net.sf.mmm.value.observable.numbers.floats.FloatExpression;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.IntegerBinding;
import net.sf.mmm.value.observable.numbers.integers.IntegerExpression;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.LongBinding;
import net.sf.mmm.value.observable.numbers.longs.LongExpression;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;
import net.sf.mmm.value.observable.numbers.shorts.ShortBinding;
import net.sf.mmm.value.observable.numbers.shorts.ShortExpression;

/**
 * {@link NumberExpression} with {@link Byte} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ByteExpression extends ObservableByteValue, NumberExpression<Byte> {

  @Override
  default ByteExpression negate() {

    return ByteBinding.negate(this);
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
  default FloatExpression add(ObservableFloatValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default LongExpression add(ObservableLongValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default IntegerExpression add(ObservableIntegerValue other) {

    return IntegerBinding.add(this, other);
  }

  @Override
  default ShortExpression add(ObservableShortValue other) {

    return ShortBinding.add(this, other);
  }

  @Override
  default ByteExpression add(ObservableByteValue other) {

    return ByteBinding.add(this, other);
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
  default FloatExpression add(float constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default LongExpression add(long constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default IntegerExpression add(int constant) {

    return IntegerBinding.add(this, constant);
  }

  @Override
  default ShortExpression add(short constant) {

    return ShortBinding.add(this, constant);
  }

  @Override
  default ByteExpression add(byte constant) {

    return ByteBinding.add(this, constant);
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
  default FloatExpression subtract(ObservableFloatValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default LongExpression subtract(ObservableLongValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default IntegerExpression subtract(ObservableIntegerValue other) {

    return IntegerBinding.subtract(this, other);
  }

  @Override
  default ShortExpression subtract(ObservableShortValue other) {

    return ShortBinding.subtract(this, other);
  }

  @Override
  default ByteExpression subtract(ObservableByteValue other) {

    return ByteBinding.subtract(this, other);
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
  default FloatExpression subtract(float constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default LongExpression subtract(long constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default IntegerExpression subtract(int constant) {

    return IntegerBinding.subtract(this, constant);
  }

  @Override
  default ShortExpression subtract(short constant) {

    return ShortBinding.subtract(this, constant);
  }

  @Override
  default ByteExpression subtract(byte constant) {

    return ByteBinding.subtract(this, constant);
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
  default FloatExpression multiply(ObservableFloatValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default LongExpression multiply(ObservableLongValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default IntegerExpression multiply(ObservableIntegerValue other) {

    return IntegerBinding.multiply(this, other);
  }

  @Override
  default ShortExpression multiply(ObservableShortValue other) {

    return ShortBinding.multiply(this, other);
  }

  @Override
  default ByteExpression multiply(ObservableByteValue other) {

    return ByteBinding.multiply(this, other);
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
  default FloatExpression multiply(float constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default LongExpression multiply(long constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default IntegerExpression multiply(int constant) {

    return IntegerBinding.multiply(this, constant);
  }

  @Override
  default ShortExpression multiply(short constant) {

    return ShortBinding.multiply(this, constant);
  }

  @Override
  default ByteExpression multiply(byte constant) {

    return ByteBinding.multiply(this, constant);
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
  default FloatExpression divide(ObservableFloatValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default LongExpression divide(ObservableLongValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default IntegerExpression divide(ObservableIntegerValue other) {

    return IntegerBinding.divide(this, other);
  }

  @Override
  default ShortExpression divide(ObservableShortValue other) {

    return ShortBinding.divide(this, other);
  }

  @Override
  default ByteExpression divide(ObservableByteValue other) {

    return ByteBinding.divide(this, other);
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
  default FloatExpression divide(float constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default LongExpression divide(long constant) {

    return LongBinding.divide(this, constant);
  }

  @Override
  default IntegerExpression divide(int constant) {

    return IntegerBinding.divide(this, constant);
  }

  @Override
  default ShortExpression divide(short constant) {

    return ShortBinding.divide(this, constant);
  }

  @Override
  default ByteExpression divide(byte constant) {

    return ByteBinding.divide(this, constant);
  }

}
