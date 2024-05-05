/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localtime;

import java.time.LocalTime;

import io.github.mmm.value.observable.temporal.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link LocalTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLocalTimeValue extends ReadableTemporalValue<LocalTime> {

  @Override
  default Class<LocalTime> getValueClass() {

    return LocalTime.class;
  }

  @Override
  default LocalTime getFallbackSafeValue() {

    return LocalTime.MIN;
  }

}
