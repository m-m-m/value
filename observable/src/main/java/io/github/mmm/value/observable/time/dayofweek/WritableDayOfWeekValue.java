/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.dayofweek;

import java.time.DayOfWeek;

import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link DayOfWeek} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableDayOfWeekValue extends ReadableDayOfWeekValue, WritableSimpleValue<DayOfWeek> {

  /**
   * @param dayOfWeek the {@link DayOfWeek} as primitive {@code int} value.
   */
  default void setValue(int dayOfWeek) {

    if (dayOfWeek == 0) {
      set(null);
    } else {
      set(DayOfWeek.of(dayOfWeek));
    }
  }

}
