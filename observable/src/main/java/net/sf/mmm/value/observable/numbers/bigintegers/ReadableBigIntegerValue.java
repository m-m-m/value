/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigintegers;

import java.math.BigInteger;

import net.sf.mmm.value.observable.numbers.ReadableNumberValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link BigInteger} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableBigIntegerValue extends ReadableNumberValue<BigInteger> {

  @Override
  default Class<BigInteger> getValueClass() {

    return BigInteger.class;
  }

  @Override
  default BigInteger getValueSafe() {

    BigInteger value = getValue();
    if (value == null) {
      return BigInteger.ZERO;
    }
    return value;
  }

}
