package net.sf.mmm.value.observable.number.biginteger;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.number.NumberExpression;
import net.sf.mmm.value.observable.number.bigdecimal.BigDecimalBinding;
import net.sf.mmm.value.observable.number.bigdecimal.BigDecimalExpression;
import net.sf.mmm.value.observable.number.bigdecimal.ObservableBigDecimalValue;
import net.sf.mmm.value.observable.number.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.number.doubles.ObservableDoubleValue;
import net.sf.mmm.value.observable.number.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.number.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.number.longs.ObservableLongValue;
import net.sf.mmm.value.observable.number.shorts.ObservableShortValue;

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
  default BigDecimalExpression add(ObservableDoubleValue other) {

    return BigDecimalBinding.add(this, other);
  }

  @Override
  default BigDecimalExpression add(ObservableFloatValue other) {

    return BigDecimalBinding.add(this, other);
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
  default BigDecimalExpression add(double constant) {

    return BigDecimalBinding.add(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression add(float constant) {

    return add((double) constant);
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
  default BigDecimalExpression subtract(ObservableDoubleValue other) {

    return BigDecimalBinding.subtract(this, other);
  }

  @Override
  default BigDecimalExpression subtract(ObservableFloatValue other) {

    return BigDecimalBinding.subtract(this, other);
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
  default BigDecimalExpression subtract(double constant) {

    return BigDecimalBinding.subtract(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression subtract(float constant) {

    return subtract((double) constant);
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
  default BigDecimalExpression multiply(ObservableDoubleValue other) {

    return BigDecimalBinding.multiply(this, other);
  }

  @Override
  default BigDecimalExpression multiply(ObservableFloatValue other) {

    return BigDecimalBinding.multiply(this, other);
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
  default BigDecimalExpression multiply(double constant) {

    return BigDecimalBinding.multiply(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression multiply(float constant) {

    return multiply((double) constant);
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

  @Override
  default NumberExpression<?> divide(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return BigDecimalBinding.divide(this, other);
    } else {
      return BigIntegerBinding.divide(this, other);
    }
  }

  @Override
  default BigIntegerExpression divide(ObservableBigIntegerValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigDecimalExpression divide(ObservableDoubleValue other) {

    return BigDecimalBinding.divide(this, other);
  }

  @Override
  default BigDecimalExpression divide(ObservableFloatValue other) {

    return BigDecimalBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression divide(ObservableLongValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression divide(ObservableIntegerValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression divide(ObservableShortValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default BigIntegerExpression divide(ObservableByteValue other) {

    return BigIntegerBinding.divide(this, other);
  }

  @Override
  default NumberExpression<?> divide(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return divide((BigDecimal) constant);
    } else {
      return BigIntegerBinding.divide(this, constant);
    }
  }

  @Override
  default BigIntegerExpression divide(BigInteger constant) {

    return BigIntegerBinding.divide(this, constant);
  }

  @Override
  default BigDecimalExpression divide(double constant) {

    return BigDecimalBinding.divide(this, BigDecimal.valueOf(constant));
  }

  @Override
  default BigDecimalExpression divide(float constant) {

    return divide((double) constant);
  }

  @Override
  default BigIntegerExpression divide(long constant) {

    return divide(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression divide(int constant) {

    return divide(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression divide(short constant) {

    return divide(BigInteger.valueOf(constant));
  }

  @Override
  default BigIntegerExpression divide(byte constant) {

    return divide(BigInteger.valueOf(constant));
  }
}
