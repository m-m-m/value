/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.year;

import java.time.Year;

import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link Year} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableYearValue extends ReadableSimpleValue<Year> {

  @Override
  default Class<Year> getValueClass() {

    return Year.class;
  }

  @Override
  default Year getFallbackSafeValue() {

    return Year.of(0);
  }

  @Override
  default Year parse(String value) {

    if (value == null) {
      return null;
    }
    return Year.parse(value);
  }

  /**
   * @return the {@link Year} {@link #get() value} as primitive {@code int} value. Will be {@code 0} if undefined.
   */
  default int getValue() {

    return getSafe().getValue();
  }

}
