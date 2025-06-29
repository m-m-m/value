/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.offsettime;

import java.time.OffsetTime;

import io.github.mmm.value.observable.time.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link OffsetTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableOffsetTimeValue extends ReadableTemporalValue<OffsetTime> {

  @Override
  default Class<OffsetTime> getValueClass() {

    return OffsetTime.class;
  }

  @Override
  default OffsetTime getFallbackSafeValue() {

    return OffsetTime.MIN;
  }

  @Override
  default OffsetTime parse(String value) {

    if (value == null) {
      return null;
    }
    return OffsetTime.parse(value);
  }

}
