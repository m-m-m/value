package net.sf.mmm.value.observable.numbers.bigintegers;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigdecimals.BigDecimalBinding;
import net.sf.mmm.value.observable.numbers.bigdecimals.ObservableBigDecimalValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} for {@link BigInteger}.
 *
 * @since 1.0.0
 */
public interface BigIntegerExpression extends ObservableBigIntegerValue, NumberExpression<BigInteger> {

  @Override
  default BigIntegerExpression negate() {

    return BigIntegerBinding.negate(this);
  }

  @Override
  default NumberExpression<?> add(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.add(this, other);
    } else {
      return BigIntegerBinding.add(this, other);
    }
  }

  @Override
  default BigIntegerExpression add(ObservableBigIntegerValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression add(ObservableDoubleValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression add(ObservableFloatValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression add(ObservableLongValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression add(ObservableIntegerValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression add(ObservableShortValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default BigIntegerExpression add(ObservableByteValue other) {

    return BigIntegerBinding.add(this, other);
  }

  @Override
  default NumberExpression<?> add(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return add((BigDecimal) constant);
    } else {
      return BigIntegerBinding.add(this, constant);
    }
  }

  @Override
  default BigIntegerExpression add(BigInteger constant) {

    return BigIntegerBinding.add(this, constant);
  }

  @Override
  default BigIntegerExpression add(double constant) {

    return add((long) constant);
  }

  @Override
  default BigIntegerExpression add(float constant) {

    return add((long) constant);
  }

  @Override
  default BigIntegerExpression add(long constant) {

    return add(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression add(int constant) {

    return add(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression add(short constant) {

    return add(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression add(byte constant) {

    return add(BigInteger.valueOf(constant));
  }

  @Override
  default NumberExpression<?> subtract(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.subtract(this, other);
    } else {
      return BigIntegerBinding.subtract(this, other);
    }
  }

  @Override
  default BigIntegerExpression subtract(ObservableBigIntegerValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression subtract(ObservableDoubleValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression subtract(ObservableFloatValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression subtract(ObservableLongValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression subtract(ObservableIntegerValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression subtract(ObservableShortValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default BigIntegerExpression subtract(ObservableByteValue other) {

    return BigIntegerBinding.subtract(this, other);
  }

  @Override
  default NumberExpression<?> subtract(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return subtract((BigDecimal) constant);
    } else {
      return BigIntegerBinding.subtract(this, constant);
    }
  }

  @Override
  default BigIntegerExpression subtract(BigInteger constant) {

    return BigIntegerBinding.subtract(this, constant);
  }

  @Override
  default BigIntegerExpression subtract(double constant) {

    return subtract((long) constant);
  }

  @Override
  default BigIntegerExpression subtract(float constant) {

    return subtract((long) constant);
  }

  @Override
  default BigIntegerExpression subtract(long constant) {

    return subtract(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression subtract(int constant) {

    return subtract(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression subtract(short constant) {

    return subtract(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression subtract(byte constant) {

    return subtract(BigInteger.valueOf(constant));
  }

  @Override
  default NumberExpression<?> multiply(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.multiply(this, other);
    } else {
      return BigIntegerBinding.multiply(this, other);
    }
  }

  @Override
  default BigIntegerExpression multiply(ObservableBigIntegerValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression multiply(ObservableDoubleValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression multiply(ObservableFloatValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression multiply(ObservableLongValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression multiply(ObservableIntegerValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression multiply(ObservableShortValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default BigIntegerExpression multiply(ObservableByteValue other) {

    return BigIntegerBinding.multiply(this, other);
  }

  @Override
  default NumberExpression<?> multiply(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return multiply((BigDecimal) constant);
    } else {
      return BigIntegerBinding.multiply(this, constant);
    }
  }

  @Override
  default BigIntegerExpression multiply(BigInteger constant) {

    return BigIntegerBinding.multiply(this, constant);
  }

  @Override
  default BigIntegerExpression multiply(double constant) {

    return multiply((long) constant);
  }

  @Override
  default BigIntegerExpression multiply(float constant) {

    return multiply((long) constant);
  }

  @Override
  default BigIntegerExpression multiply(long constant) {

    return multiply(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression multiply(int constant) {

    return multiply(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression multiply(short constant) {

    return multiply(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression multiply(byte constant) {

    return multiply(BigInteger.valueOf(constant));
  }
}
