/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.month;

import java.time.Month;

import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link Month} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableMonthValue extends ReadableMonthValue, WritableSimpleValue<Month> {

  /**
   * @param month the {@link Month} as primitive {@code int} value.
   */
  default void setValue(int month) {

    if (month == 0) {
      set(null);
    } else {
      set(Month.of(month));
    }
  }

}
