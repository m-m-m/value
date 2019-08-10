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
 * {@link NumberExpression} for {@link BigDecimal}.
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

}
