/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.floats;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Float} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface WritableFloatValue extends ReadableFloatValue, WritableNumberValue<Float> {

  @Override
  default Float parse(String value) {

    if (value == null) {
      return null;
    }
    return Float.valueOf(value);
  }

  /**
   * @param value the new {@link #getValue() primitive value}.
   * @see #set(Float)
   */
  default void setValue(float value) {

    set(Float.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Float)) {
      set((Float) value);
    } else {
      set(Float.valueOf(value.floatValue()));
    }
  }

}
