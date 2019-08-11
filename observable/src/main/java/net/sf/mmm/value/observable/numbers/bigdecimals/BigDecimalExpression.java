package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} with {@link BigDecimal} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface BigDecimalExpression extends ObservableBigDecimalValue, NumberExpression<BigDecimal> {

  @Override
  default BigDecimalExpression negate() {

    return BigDecimalBinding.negate(this);
  }

  @Override
  default BigDecimalExpression add(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableBigIntegerValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableDoubleValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableFloatValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableLongValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableIntegerValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableShortValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableByteValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(Number constant) {

    return BigDecimalBinding.add(this, constant);
  }

  @Override
  default BigDecimalExpression add(BigInteger constant) {

    return add(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression add(double constant) {

    return add(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression add(float constant) {

    return add((double) constant);
  }

  @Override
  default BigDecimalExpression add(long constant) {

    return add((double) constant);
  }

  @Override
  default BigDecimalExpression add(int constant) {

    return add((double) constant);
  }

  @Override
  default BigDecimalExpression add(short constant) {

    return add((double) constant);
  }

  @Override
  default BigDecimalExpression add(byte constant) {

    return add((double) constant);
  }

  @Override
  default BigDecimalExpression subtract(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableBigIntegerValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableDoubleValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableFloatValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableLongValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableIntegerValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableShortValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableByteValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(Number constant) {

    return BigDecimalBinding.subtract(this, constant);
  }

  @Override
  default BigDecimalExpression subtract(BigInteger constant) {

    return subtract(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression subtract(double constant) {

    return subtract(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression subtract(float constant) {

    return subtract((double) constant);
  }

  @Override
  default BigDecimalExpression subtract(long constant) {

    return subtract((double) constant);
  }

  @Override
  default BigDecimalExpression subtract(int constant) {

    return subtract((double) constant);
  }

  @Override
  default BigDecimalExpression subtract(short constant) {

    return subtract((double) constant);
  }

  @Override
  default BigDecimalExpression subtract(byte constant) {

    return subtract((double) constant);
  }

  @Override
  default BigDecimalExpression multiply(ObservableValue<? extends Number> other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableBigIntegerValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableDoubleValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableFloatValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableLongValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableIntegerValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableShortValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableByteValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(Number constant) {

    return BigDecimalBinding.multiply(this, constant);
  }

  @Override
  default BigDecimalExpression multiply(BigInteger constant) {

    return multiply(new BigDecimal(constant));
  }

  @Override
  default BigDecimalExpression multiply(double constant) {

    return multiply(BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression multiply(float constant) {

    return multiply((double) constant);
  }

  @Override
  default BigDecimalExpression multiply(long constant) {

    return multiply((double) constant);
  }

  @Override
  default BigDecimalExpression multiply(int constant) {

    return multiply((double) constant);
  }

  @Override
  default BigDecimalExpression multiply(short constant) {

    return multiply((double) constant);
  }

  @Override
  default BigDecimalExpression multiply(byte constant) {

    return multiply((double) constant);
  }

}
