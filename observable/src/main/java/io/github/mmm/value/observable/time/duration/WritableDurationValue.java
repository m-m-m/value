/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.duration;

import java.time.Duration;

import io.github.mmm.value.observable.time.WritableTemporalAmountValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link Duration} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableDurationValue extends ReadableDurationValue, WritableTemporalAmountValue<Duration> {

}
