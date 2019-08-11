package net.sf.mmm.value.observable.numbers.shorts;

import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerBinding;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ByteBinding;
import net.sf.mmm.value.observable.numbers.bytes.ByteExpression;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
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

/**
 * {@link NumberExpression} with {@link Short} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ShortExpression extends ObservableShortValue, NumberExpression<Short> {

  @Override
  default ShortExpression negate() {

    return ShortBinding.negate(this);
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
  default ShortExpression add(ObservableByteValue other) {

    return ShortBinding.add(this, other);
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
  default ShortExpression subtract(ObservableByteValue other) {

    return ShortBinding.subtract(this, other);
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

}
