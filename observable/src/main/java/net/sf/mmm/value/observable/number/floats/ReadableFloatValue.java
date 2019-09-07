/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number.floats;

import net.sf.mmm.value.observable.number.ReadableNumberValue;

/**
 * {@link ReadableNumberValue} with {@link Float} {@link #getValue() value}.
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
  default float get() {

    return floatValue();
  }

  @Override
  default Float getValueSafe() {

    Float value = getValue();
    if (value == null) {
      return Float.valueOf(0);
    }
    return value;
  }
}
