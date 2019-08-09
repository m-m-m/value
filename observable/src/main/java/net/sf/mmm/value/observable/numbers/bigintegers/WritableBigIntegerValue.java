/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigintegers;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.WritableNumberValue;

/**
 * {@link net.sf.mmm.value.WritableValue} containing a {@link BigInteger} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableBigIntegerValue extends ReadableBigIntegerValue, WritableNumberValue<BigInteger> {

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof BigInteger)) {
      setValue((BigInteger) value);
    } else if (value instanceof BigDecimal) {
      setValue(((BigDecimal) value).toBigInteger());
    } else {
      setValue(BigInteger.valueOf(value.longValue()));
    }
  }

}
