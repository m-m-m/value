/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.dayofweek;

import java.time.DayOfWeek;
import java.util.Locale;

import io.github.mmm.value.observable.enumeration.ReadableEnumValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link DayOfWeek} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableDayOfWeekValue extends ReadableEnumValue<DayOfWeek> {

  @Override
  default Class<DayOfWeek> getValueClass() {

    return DayOfWeek.class;
  }

  @Override
  default DayOfWeek getFallbackSafeValue() {

    return null;
  }

  @Override
  default DayOfWeek parse(String value) {

    if (value == null) {
      return null;
    }
    if (value.length() <= 1) {
      int m = Integer.parseInt(value);
      return DayOfWeek.of(m);
    } else {
      return DayOfWeek.valueOf(value.toUpperCase(Locale.ROOT));
    }
  }

}
