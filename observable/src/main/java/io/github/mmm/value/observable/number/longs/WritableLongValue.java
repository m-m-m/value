/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.longs;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Long} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface WritableLongValue extends ReadableLongValue, WritableNumberValue<Long> {

  /**
   * @param value the new {@link #getValue() primitive value}.
   * @see #set(Long)
   */
  default void setValue(long value) {

    set(Long.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Long)) {
      set((Long) value);
    } else {
      set(Long.valueOf(value.longValue()));
    }
  }
}
