package net.sf.mmm.value.observable.numbers.integers;

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
import net.sf.mmm.value.observable.numbers.longs.LongBinding;
import net.sf.mmm.value.observable.numbers.longs.LongExpression;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

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

}
