/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.integers;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Integer} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface WritableIntegerValue extends ReadableIntegerValue, WritableNumberValue<Integer> {

  @Override
  default Integer parse(String value) {

    if (value == null) {
      return null;
    }
    return Integer.valueOf(value);
  }

  @Override
  void set(Integer value);

  /**
   * @param value the new {@link #getValue() primitive value}.
   * @see #set(Integer)
   */
  default void setValue(int value) {

    set(Integer.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Integer)) {
      set((Integer) value);
    } else {
      set(Integer.valueOf(value.intValue()));
    }
  }

}
