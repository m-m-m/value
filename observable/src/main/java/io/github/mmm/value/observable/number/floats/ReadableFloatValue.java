/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.floats;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Float} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableFloatValue extends ReadableNumberValue<Float> {

  @Override
  default Class<Float> getValueClass() {

    return Float.class;
  }

  /**
   * @return the current value as primitive. Will be {@code 0} if undefined.
   */
  default float getValue() {

    return floatValue();
  }

  @Override
  default Float getFallbackSafeValue() {

    return Float.valueOf(0);
  }

  @Override
  default Float parse(String value) {

    if (value == null) {
      return null;
    }
    return Float.valueOf(value);
  }

}
