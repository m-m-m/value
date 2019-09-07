/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporal.localdatetime;

import java.time.LocalDateTime;

import net.sf.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link net.sf.mmm.value.WritableValue} containing a {@link LocalDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableLocalDateTimeValue extends ReadableLocalDateTimeValue, WritableTemporalValue<LocalDateTime> {

}
