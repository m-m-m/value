/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.duration;

import java.time.Duration;
import java.time.Instant;

import io.github.mmm.value.observable.time.ReadableTemporalAmountValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link Instant} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableDurationValue extends ReadableTemporalAmountValue<Duration> {

  @Override
  default Class<Duration> getValueClass() {

    return Duration.class;
  }

  @Override
  default Duration getFallbackSafeValue() {

    return Duration.ZERO;
  }

  @Override
  default Duration parse(String value) {

    if (value == null) {
      return null;
    }
    return Duration.parse(value);
  }

}
