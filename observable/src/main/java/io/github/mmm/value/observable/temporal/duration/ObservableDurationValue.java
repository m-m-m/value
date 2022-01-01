/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.duration;

import java.time.Duration;

import io.github.mmm.value.observable.temporal.ObservableTemporalAmountValue;

/**
 * {@link io.github.mmm.value.observable.ObservableValue} containing a {@link Duration} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ObservableDurationValue extends ObservableTemporalAmountValue<Duration>, ReadableDurationValue {

}
