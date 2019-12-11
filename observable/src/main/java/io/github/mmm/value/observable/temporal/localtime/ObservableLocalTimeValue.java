/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localtime;

import java.time.LocalDateTime;
import java.time.LocalTime;

import io.github.mmm.value.observable.temporal.ObservableTemporalValue;

/**
 * {@link io.github.mmm.value.observable.ObservableValue} containing a {@link LocalDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ObservableLocalTimeValue extends ObservableTemporalValue<LocalTime>, ReadableLocalTimeValue {

}
