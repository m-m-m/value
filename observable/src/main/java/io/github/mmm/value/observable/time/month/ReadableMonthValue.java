/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.month;

import java.time.Month;
import java.util.Locale;

import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link Month} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableMonthValue extends ReadableSimpleValue<Month> {

  @Override
  default Class<Month> getValueClass() {

    return Month.class;
  }

  @Override
  default Month getFallbackSafeValue() {

    return null;
  }

  @Override
  default Month parse(String value) {

    if (value == null) {
      return null;
    }
    if (value.length() <= 2) {
      int m = Integer.parseInt(value);
      return Month.of(m);
    } else {
      return Month.valueOf(value.toUpperCase(Locale.ROOT));
    }
  }

  /**
   * @return the {@link Month} {@link #get() value} as primitive {@code int} value. Will be {@code 0} if undefined.
   */
  default int getValue() {

    Month month = get();
    if (month == null) {
      return 0;
    }
    return month.getValue();
  }

}
