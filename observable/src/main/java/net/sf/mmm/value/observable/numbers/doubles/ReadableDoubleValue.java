/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.doubles;

import net.sf.mmm.value.observable.numbers.ReadableNumberValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link Double} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableDoubleValue extends ReadableNumberValue<Double> {

  @Override
  default Class<Double> getValueClass() {

    return Double.class;
  }

  /**
   * @return the current value as primitive. Will be {@code 0} if undefined.
   */
  default double get() {

    return doubleValue();
  }

  @Override
  default Double getValueSafe() {

    Double value = getValue();
    if (value == null) {
      return Double.valueOf(0);
    }
    return value;
  }
}
