/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.shorts;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Short} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface WritableShortValue extends ReadableShortValue, WritableNumberValue<Short> {

  @Override
  default Short parse(String value) {

    if (value == null) {
      return null;
    }
    return Short.valueOf(value);
  }

  /**
   * @param value the new {@link #getValue() primitive value}.
   * @see #set(Short)
   */
  default void setValue(short value) {

    set(Short.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Short)) {
      set((Short) value);
    } else {
      set(Short.valueOf(value.shortValue()));
    }
  }

}
