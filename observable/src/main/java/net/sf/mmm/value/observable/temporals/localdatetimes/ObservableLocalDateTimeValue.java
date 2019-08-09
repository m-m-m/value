/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals.localdatetimes;

import java.time.LocalDateTime;

import net.sf.mmm.value.observable.temporals.ObservableTemporalValue;

/**
 * {@link net.sf.mmm.value.observable.ObservableValue} containing a {@link LocalDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ObservableLocalDateTimeValue
    extends ObservableTemporalValue<LocalDateTime>, ReadableLocalDateTimeValue {

}
