package net.sf.mmm.value.observable.numbers.longs;

import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerBinding;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.doubles.DoubleBinding;
import net.sf.mmm.value.observable.numbers.doubles.DoubleExpression;
import net.sf.mmm.value.observable.numbers.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.numbers.floats.FloatBinding;
import net.sf.mmm.value.observable.numbers.floats.FloatExpression;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link Long} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface LongExpression extends ObservableLongValue, NumberExpression<Long> {

  @Override
  default LongExpression negate() {

    return LongBinding.negate(this);
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
  default LongExpression add(ObservableIntegerValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default LongExpression add(ObservableShortValue other) {

    return LongBinding.add(this, other);
  }

  @Override
  default LongExpression add(ObservableByteValue other) {

    return LongBinding.add(this, other);
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
  default LongExpression add(int constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default LongExpression add(short constant) {

    return LongBinding.add(this, constant);
  }

  @Override
  default LongExpression add(byte constant) {

    return LongBinding.add(this, constant);
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
  default LongExpression subtract(ObservableIntegerValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default LongExpression subtract(ObservableShortValue other) {

    return LongBinding.subtract(this, other);
  }

  @Override
  default LongExpression subtract(ObservableByteValue other) {

    return LongBinding.subtract(this, other);
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
  default LongExpression subtract(int constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default LongExpression subtract(short constant) {

    return LongBinding.subtract(this, constant);
  }

  @Override
  default LongExpression subtract(byte constant) {

    return LongBinding.subtract(this, constant);
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
  default LongExpression multiply(ObservableIntegerValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default LongExpression multiply(ObservableShortValue other) {

    return LongBinding.multiply(this, other);
  }

  @Override
  default LongExpression multiply(ObservableByteValue other) {

    return LongBinding.multiply(this, other);
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
  default LongExpression multiply(int constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default LongExpression multiply(short constant) {

    return LongBinding.multiply(this, constant);
  }

  @Override
  default LongExpression multiply(byte constant) {

    return LongBinding.multiply(this, constant);
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
  default LongExpression divide(ObservableIntegerValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default LongExpression divide(ObservableShortValue other) {

    return LongBinding.divide(this, other);
  }

  @Override
  default LongExpression divide(ObservableByteValue other) {

    return LongBinding.divide(this, other);
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
  default LongExpression divide(int constant) {

    return LongBinding.divide(this, constant);
  }

  @Override
  default LongExpression divide(short constant) {

    return LongBinding.divide(this, constant);
  }

  @Override
  default LongExpression divide(byte constant) {

    return LongBinding.divide(this, constant);
  }

}
