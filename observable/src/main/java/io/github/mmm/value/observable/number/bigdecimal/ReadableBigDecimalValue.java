/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bigdecimal;

import java.math.BigDecimal;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link BigDecimal} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableBigDecimalValue extends ReadableNumberValue<BigDecimal> {

  @Override
  default Class<BigDecimal> getValueClass() {

    return BigDecimal.class;
  }

  @Override
  default BigDecimal getSafe() {

    BigDecimal value = get();
    if (value == null) {
      return BigDecimal.ZERO;
    }
    return value;
  }

}
