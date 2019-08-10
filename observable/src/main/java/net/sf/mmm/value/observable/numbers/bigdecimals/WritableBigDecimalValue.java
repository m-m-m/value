/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link BigDecimal} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableBigDecimalValue extends ReadableBigDecimalValue, WritableNumberValue<BigDecimal> {

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof BigDecimal)) {
      setValue((BigDecimal) value);
    } else if (value instanceof BigInteger) {
      setValue(new BigDecimal((BigInteger) value));
    } else {
      setValue(BigDecimal.valueOf(value.doubleValue()));
    }
  }

}
