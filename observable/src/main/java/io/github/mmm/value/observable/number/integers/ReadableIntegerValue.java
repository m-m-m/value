/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.integers;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Integer} {@link #get() value}.
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
  default int getValue() {

    return intValue();
  }

  @Override
  default Integer getFallbackSafeValue() {

    return Integer.valueOf(0);
  }

  @Override
  default Integer parse(String value) {

    if (value == null) {
      return null;
    }
    return Integer.valueOf(value);
  }

}
