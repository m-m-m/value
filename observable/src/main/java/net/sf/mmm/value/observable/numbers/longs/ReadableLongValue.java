/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.longs;

import net.sf.mmm.value.observable.numbers.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Long} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLongValue extends ReadableNumberValue<Long> {

  @Override
  default Class<Long> getValueClass() {

    return Long.class;
  }

  /**
   * @return the current value as primitive. Will be {@code 0} if undefined.
   */
  default long get() {

    return longValue();
  }

  @Override
  default Long getValueSafe() {

    Long value = getValue();
    if (value == null) {
      return Long.valueOf(0);
    }
    return value;
  }
}
