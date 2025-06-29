/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdate;

import java.time.LocalDate;

import io.github.mmm.value.observable.time.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link LocalDate} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLocalDateValue extends ReadableTemporalValue<LocalDate> {

  @Override
  default Class<LocalDate> getValueClass() {

    return LocalDate.class;
  }

  @Override
  default LocalDate getFallbackSafeValue() {

    return LocalDate.MIN;
  }

  @Override
  default LocalDate parse(String value) {

    if (value == null) {
      return null;
    }
    return LocalDate.parse(value);
  }

}
