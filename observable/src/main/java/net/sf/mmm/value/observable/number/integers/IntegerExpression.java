package net.sf.mmm.value.observable.number.integers;

import java.math.BigInteger;

import net.sf.mmm.value.observable.number.NumberExpression;
import net.sf.mmm.value.observable.number.biginteger.BigIntegerBinding;
import net.sf.mmm.value.observable.number.biginteger.BigIntegerExpression;
import net.sf.mmm.value.observable.number.biginteger.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.number.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.number.doubles.DoubleBinding;
import net.sf.mmm.value.observable.number.doubles.DoubleExpression;
import net.sf.mmm.value.observable.number.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.number.floats.FloatBinding;
import net.sf.mmm.value.observable.number.floats.FloatExpression;
import net.sf.mmm.value.observable.number.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.number.longs.LongBinding;
import net.sf.mmm.value.observable.number.longs.LongExpression;
import net.sf.mmm.value.observable.number.longs.ObservableLongValue;
import net.sf.mmm.value.observable.number.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link Integer} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface IntegerExpression extends ObservableIntegerValue, NumberExpression<Integer> {

  @Override
  default IntegerExpression negate() {

    return IntegerBinding.negate(this);
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
  default IntegerExpression add(ObservableShortValue other) {

    return IntegerBinding.add(this, other);
  }

  @Override
  default IntegerExpression add(ObservableByteValue other) {

    return IntegerBinding.add(this, other);
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
  default IntegerExpression add(short constant) {

    return IntegerBinding.add(this, constant);
  }

  @Override
  default IntegerExpression add(byte constant) {

    return IntegerBinding.add(this, constant);
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
  default IntegerExpression subtract(ObservableShortValue other) {

    return IntegerBinding.subtract(this, other);
  }

  @Override
  default IntegerExpression subtract(ObservableByteValue other) {

    return IntegerBinding.subtract(this, other);
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
  default IntegerExpression subtract(short constant) {

    return IntegerBinding.subtract(this, constant);
  }

  @Override
  default IntegerExpression subtract(byte constant) {

    return IntegerBinding.subtract(this, constant);
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
  default IntegerExpression multiply(ObservableShortValue other) {

    return IntegerBinding.multiply(this, other);
  }

  @Override
  default IntegerExpression multiply(ObservableByteValue other) {

    return IntegerBinding.multiply(this, other);
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
  default IntegerExpression multiply(short constant) {

    return IntegerBinding.multiply(this, constant);
  }

  @Override
  default IntegerExpression multiply(byte constant) {

    return IntegerBinding.multiply(this, constant);
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
  default IntegerExpression divide(ObservableShortValue other) {

    return IntegerBinding.divide(this, other);
  }

  @Override
  default IntegerExpression divide(ObservableByteValue other) {

    return IntegerBinding.divide(this, other);
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
  default IntegerExpression divide(short constant) {

    return IntegerBinding.divide(this, constant);
  }

  @Override
  default IntegerExpression divide(byte constant) {

    return IntegerBinding.divide(this, constant);
  }

}
