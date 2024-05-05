/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.zoneddatetime;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import io.github.mmm.value.observable.temporal.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link ZonedDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableZonedDateTimeValue extends ReadableTemporalValue<ZonedDateTime> {

  /** @see #getFallbackSafeValue() */
  ZonedDateTime STATIC_SAFE_VALUE = ZonedDateTime.of(LocalDateTime.MIN, ZoneOffset.MIN);

  @Override
  default Class<ZonedDateTime> getValueClass() {

    return ZonedDateTime.class;
  }

  @Override
  default ZonedDateTime getFallbackSafeValue() {

    return STATIC_SAFE_VALUE;
  }

}
