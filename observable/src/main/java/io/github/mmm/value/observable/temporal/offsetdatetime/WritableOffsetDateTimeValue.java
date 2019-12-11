/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.offsetdatetime;

import java.time.OffsetDateTime;

import io.github.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link OffsetDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableOffsetDateTimeValue
    extends ReadableOffsetDateTimeValue, WritableTemporalValue<OffsetDateTime> {

  @Override
  default OffsetDateTime parse(String value) {

    if (value == null) {
      return null;
    }
    return OffsetDateTime.parse(value);
  }

}
