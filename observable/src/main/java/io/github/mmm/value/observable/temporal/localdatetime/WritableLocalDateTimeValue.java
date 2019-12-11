/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localdatetime;

import java.time.LocalDateTime;

import io.github.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link LocalDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableLocalDateTimeValue extends ReadableLocalDateTimeValue, WritableTemporalValue<LocalDateTime> {

  @Override
  default LocalDateTime parse(String value) {

    if (value == null) {
      return null;
    }
    return LocalDateTime.parse(value);
  }

}
