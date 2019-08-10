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

}
