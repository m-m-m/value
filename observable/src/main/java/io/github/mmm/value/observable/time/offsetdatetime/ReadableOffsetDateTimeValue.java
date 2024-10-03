/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.offsetdatetime;

import java.time.OffsetDateTime;

import io.github.mmm.value.observable.time.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link OffsetDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableOffsetDateTimeValue extends ReadableTemporalValue<OffsetDateTime> {

  @Override
  default Class<OffsetDateTime> getValueClass() {

    return OffsetDateTime.class;
  }

  @Override
  default OffsetDateTime getFallbackSafeValue() {

    return OffsetDateTime.MIN;
  }

  @Override
  default OffsetDateTime parse(String value) {

    if (value == null) {
      return null;
    }
    return OffsetDateTime.parse(value);
  }

}
