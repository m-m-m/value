/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.zoneddatetime;

import java.time.ZonedDateTime;

import io.github.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link ZonedDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableZonedDateTimeValue extends ReadableZonedDateTimeValue, WritableTemporalValue<ZonedDateTime> {

  @Override
  default ZonedDateTime parse(String value) {

    if (value == null) {
      return null;
    }
    return ZonedDateTime.parse(value);
  }

}
