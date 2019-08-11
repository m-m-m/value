package net.sf.mmm.value.observable.numbers.floats;

import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerBinding;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.doubles.DoubleBinding;
import net.sf.mmm.value.observable.numbers.doubles.DoubleExpression;
import net.sf.mmm.value.observable.numbers.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link Float} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface FloatExpression extends ObservableFloatValue, NumberExpression<Float> {

  @Override
  default FloatExpression negate() {

    return FloatBinding.negate(this);
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
  default FloatExpression add(ObservableLongValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression add(ObservableIntegerValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression add(ObservableShortValue other) {

    return FloatBinding.add(this, other);
  }

  @Override
  default FloatExpression add(ObservableByteValue other) {

    return FloatBinding.add(this, other);
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
  default FloatExpression add(long constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression add(int constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression add(short constant) {

    return FloatBinding.add(this, constant);
  }

  @Override
  default FloatExpression add(byte constant) {

    return FloatBinding.add(this, constant);
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
  default FloatExpression subtract(ObservableLongValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression subtract(ObservableIntegerValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression subtract(ObservableShortValue other) {

    return FloatBinding.subtract(this, other);
  }

  @Override
  default FloatExpression subtract(ObservableByteValue other) {

    return FloatBinding.subtract(this, other);
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
  default FloatExpression subtract(long constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression subtract(int constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression subtract(short constant) {

    return FloatBinding.subtract(this, constant);
  }

  @Override
  default FloatExpression subtract(byte constant) {

    return FloatBinding.subtract(this, constant);
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
  default FloatExpression multiply(ObservableLongValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression multiply(ObservableIntegerValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression multiply(ObservableShortValue other) {

    return FloatBinding.multiply(this, other);
  }

  @Override
  default FloatExpression multiply(ObservableByteValue other) {

    return FloatBinding.multiply(this, other);
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
  default FloatExpression multiply(long constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression multiply(int constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression multiply(short constant) {

    return FloatBinding.multiply(this, constant);
  }

  @Override
  default FloatExpression multiply(byte constant) {

    return FloatBinding.multiply(this, constant);
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
  default FloatExpression divide(ObservableLongValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression divide(ObservableIntegerValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression divide(ObservableShortValue other) {

    return FloatBinding.divide(this, other);
  }

  @Override
  default FloatExpression divide(ObservableByteValue other) {

    return FloatBinding.divide(this, other);
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
  default FloatExpression divide(long constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression divide(int constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression divide(short constant) {

    return FloatBinding.divide(this, constant);
  }

  @Override
  default FloatExpression divide(byte constant) {

    return FloatBinding.divide(this, constant);
  }

}
