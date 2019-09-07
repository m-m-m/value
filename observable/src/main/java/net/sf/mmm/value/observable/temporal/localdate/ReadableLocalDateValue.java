/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporal.localdate;

import java.time.LocalDate;

import net.sf.mmm.value.observable.temporal.ReadableTemporalValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link LocalDate} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLocalDateValue extends ReadableTemporalValue<LocalDate> {

  @Override
  default Class<LocalDate> getValueClass() {

    return LocalDate.class;
  }

}
