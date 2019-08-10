/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.longs;

import net.sf.mmm.value.observable.numbers.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Long} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableLongValue extends ReadableLongValue, WritableNumberValue<Long> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Long)
   */
  default void set(long value) {

    setValue(Long.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Long)) {
      setValue((Long) value);
    } else {
      setValue(Long.valueOf(value.longValue()));
    }
  }
}
