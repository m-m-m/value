package net.sf.mmm.value.observable.numbers.doubles;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.bigdecimals.ObservableBigDecimalValue;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerBinding;
import net.sf.mmm.value.observable.numbers.bigintegers.BigIntegerExpression;
import net.sf.mmm.value.observable.numbers.bigintegers.ObservableBigIntegerValue;
import net.sf.mmm.value.observable.numbers.bytes.ObservableByteValue;
import net.sf.mmm.value.observable.numbers.floats.ObservableFloatValue;
import net.sf.mmm.value.observable.numbers.integers.ObservableIntegerValue;
import net.sf.mmm.value.observable.numbers.longs.ObservableLongValue;
import net.sf.mmm.value.observable.numbers.shorts.ObservableShortValue;

/**
 * {@link NumberExpression} for {@link Double}.
 *
 * @since 1.0.0
 */
public interface DoubleExpression extends ObservableDoubleValue, NumberExpression<Double> {

  @Override
  default DoubleExpression negate() {

    return DoubleBinding.negate(this);
  }

  @Override
  default NumberExpression<?> add(ObservableValue<? extends Number> other) {

    if (other == null) {
      return this;
    } else if (other instanceof ObservableBigDecimalValue) {
      return add((ObservableBigDecimalValue) other);
    } else if (other instanceof ObservableBigIntegerValue) {
      return add((ObservableBigIntegerValue) other);
    } else {
      return DoubleBinding.add(this, other);
    }
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
  default DoubleExpression add(ObservableFloatValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableLongValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableIntegerValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableShortValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default DoubleExpression add(ObservableByteValue other) {

    return DoubleBinding.add(this, other);
  }

  @Override
  default NumberExpression<?> add(Number constant) {

    if (constant == null) {
      return this;
    } else if (constant instanceof BigDecimal) {
      return add((BigDecimal) constant);
    } else if (constant instanceof BigInteger) {
      return add((BigInteger) constant);
    } else {
      return add(constant.doubleValue());
    }
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
  default DoubleExpression add(float constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(long constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(int constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(short constant) {

    return add((double) constant);
  }

  @Override
  default DoubleExpression add(byte constant) {

    return add((double) constant);
  }
  //
  // default DoubleBinding add(float other) {
  //
  // return (DoubleBinding) Bindings.add(this, other);
  // }
  //
  // default DoubleBinding add(long other) {
  //
  // return (DoubleBinding) Bindings.add(this, other);
  // }
  //
  // default DoubleBinding add(int other) {
  //
  // return (DoubleBinding) Bindings.add(this, other);
  // }
  //
  // default DoubleBinding subtract(float other) {
  //
  // return (DoubleBinding) Bindings.subtract(this, other);
  // }
  //
  // default DoubleBinding subtract(long other) {
  //
  // return (DoubleBinding) Bindings.subtract(this, other);
  // }
  //
  // default DoubleBinding subtract(int other) {
  //
  // return (DoubleBinding) Bindings.subtract(this, other);
  // }
  //
  // default DoubleBinding multiply(float other) {
  //
  // return (DoubleBinding) Bindings.multiply(this, other);
  // }
  //
  // default DoubleBinding multiply(long other) {
  //
  // return (DoubleBinding) Bindings.multiply(this, other);
  // }
  //
  // default DoubleBinding multiply(int other) {
  //
  // return (DoubleBinding) Bindings.multiply(this, other);
  // }
  //
  // default DoubleBinding divide(float other) {
  //
  // return (DoubleBinding) Bindings.divide(this, other);
  // }
  //
  // default DoubleBinding divide(long other) {
  //
  // return (DoubleBinding) Bindings.divide(this, other);
  // }
  //
  // default DoubleBinding divide(int other) {
  //
  // return (DoubleBinding) Bindings.divide(this, other);
  // }

}
