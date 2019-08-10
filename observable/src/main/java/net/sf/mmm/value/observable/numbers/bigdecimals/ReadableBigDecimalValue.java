/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;

import net.sf.mmm.value.observable.numbers.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link BigDecimal} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableBigDecimalValue extends ReadableNumberValue<BigDecimal> {

  @Override
  default Class<BigDecimal> getValueClass() {

    return BigDecimal.class;
  }

  @Override
  default BigDecimal getValueSafe() {

    BigDecimal value = getValue();
    if (value == null) {
      return BigDecimal.ZERO;
    }
    return value;
  }

}
