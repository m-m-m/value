/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals.localdates;

import java.time.LocalDate;

import net.sf.mmm.value.observable.temporals.WritableTemporalValue;

/**
 * {@link net.sf.mmm.value.WritableValue} containing a {@link LocalDate} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableLocalDateValue extends ReadableLocalDateValue, WritableTemporalValue<LocalDate> {

}
