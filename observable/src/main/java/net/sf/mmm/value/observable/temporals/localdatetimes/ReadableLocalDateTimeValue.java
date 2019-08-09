/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals.localdatetimes;

import java.time.LocalDateTime;

import net.sf.mmm.value.observable.temporals.ReadableTemporalValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link LocalDateTime} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLocalDateTimeValue extends ReadableTemporalValue<LocalDateTime> {

  @Override
  default Class<LocalDateTime> getValueClass() {

    return LocalDateTime.class;
  }

}
