/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.biginteger;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link BigInteger} {@link #getValue() value}.
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