/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.year;

import java.time.Year;

import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link Year} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableYearValue extends ReadableYearValue, WritableSimpleValue<Year> {

  /**
   * @param year the {@link Year} as primitive {@code int} value.
   */
  default void setValue(int year) {

    set(Year.of(year));
  }

}
