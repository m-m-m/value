/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.integers;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Integer} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableIntegerValue extends ReadableNumberValue<Integer> {

  @Override
  default Class<Integer> getValueClass() {

    return Integer.class;
  }

  /**
   * @return the current value as primitive. Will be {@code 0} if undefined.
   */
  default int get() {

    return intValue();
  }

  @Override
  default Integer getValueSafe() {

    Integer value = getValue();
    if (value == null) {
      return Integer.valueOf(0);
    }
    return value;
  }
}
