/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.shorts;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Short} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableShortValue extends ReadableNumberValue<Short> {

  @Override
  default Class<Short> getValueClass() {

    return Short.class;
  }

  /**
   * @return the current value as primitive. Will be {@code 0} if undefined.
   */
  default short get() {

    return shortValue();
  }

  @Override
  default Short getValueSafe() {

    Short value = getValue();
    if (value == null) {
      return Short.valueOf((short) 0);
    }
    return value;
  }
}
