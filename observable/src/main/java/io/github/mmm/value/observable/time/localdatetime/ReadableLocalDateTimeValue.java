/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdatetime;

import java.time.LocalDateTime;

import io.github.mmm.value.observable.time.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link LocalDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLocalDateTimeValue extends ReadableTemporalValue<LocalDateTime> {

  @Override
  default Class<LocalDateTime> getValueClass() {

    return LocalDateTime.class;
  }

  @Override
  default LocalDateTime getFallbackSafeValue() {

    return LocalDateTime.MIN;
  }

  @Override
  default LocalDateTime parse(String value) {

    if (value == null) {
      return null;
    }
    return LocalDateTime.parse(value);
  }

}
