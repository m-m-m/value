/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdate;

import java.time.LocalDate;

import io.github.mmm.value.observable.time.ObservableTemporalValue;

/**
 * {@link io.github.mmm.value.observable.ObservableValue} containing a {@link LocalDate} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ObservableLocalDateValue extends ObservableTemporalValue<LocalDate>, ReadableLocalDateValue {

}
