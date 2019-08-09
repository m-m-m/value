/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.doubles;

import net.sf.mmm.value.observable.numbers.WritableNumberValue;

/**
 * {@link net.sf.mmm.value.WritableValue} containing a {@link Integer} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableDoubleValue extends ReadableDoubleValue, WritableNumberValue<Double> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Double)
   */
  default void set(double value) {

    setValue(Double.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Double)) {
      setValue((Double) value);
    } else {
      setValue(Double.valueOf(value.doubleValue()));
    }
  }

}
