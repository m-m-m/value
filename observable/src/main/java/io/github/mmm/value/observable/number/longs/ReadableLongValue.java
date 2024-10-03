/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.longs;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Long} {@link #get() value}.
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
  default long getValue() {

    return longValue();
  }

  @Override
  default Long getFallbackSafeValue() {

    return Long.valueOf(0);
  }

  @Override
  default Long parse(String value) {

    if (value == null) {
      return null;
    }
    return Long.valueOf(value);
  }
}
