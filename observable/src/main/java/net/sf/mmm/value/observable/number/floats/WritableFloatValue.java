/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number.floats;

import net.sf.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Float} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableFloatValue extends ReadableFloatValue, WritableNumberValue<Float> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Float)
   */
  default void set(float value) {

    setValue(Float.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Float)) {
      setValue((Float) value);
    } else {
      setValue(Float.valueOf(value.floatValue()));
    }
  }

}
