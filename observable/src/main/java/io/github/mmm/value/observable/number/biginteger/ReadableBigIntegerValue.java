/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.biginteger;

import java.math.BigInteger;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link BigInteger} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableBigIntegerValue extends ReadableNumberValue<BigInteger> {

  @Override
  default Class<BigInteger> getValueClass() {

    return BigInteger.class;
  }

  @Override
  default BigInteger getSafe() {

    BigInteger value = get();
    if (value == null) {
      return BigInteger.ZERO;
    }
    return value;
  }

}
