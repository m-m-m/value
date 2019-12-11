/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localtime;

import java.time.LocalTime;

import io.github.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link LocalTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableLocalTimeValue extends ReadableLocalTimeValue, WritableTemporalValue<LocalTime> {

  @Override
  default LocalTime parse(String value) {

    if (value == null) {
      return null;
    }
    return LocalTime.parse(value);
  }

}
