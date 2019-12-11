/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.offsettime;

import java.time.OffsetTime;

import io.github.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link OffsetTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableOffsetTimeValue extends ReadableOffsetTimeValue, WritableTemporalValue<OffsetTime> {

  @Override
  default OffsetTime parse(String value) {

    if (value == null) {
      return null;
    }
    return OffsetTime.parse(value);
  }

}
