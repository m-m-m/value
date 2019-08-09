/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.integers;

import net.sf.mmm.value.observable.numbers.ReadableNumberValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link Integer} {@link #getValue() value}.
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
