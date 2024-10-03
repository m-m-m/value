/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.month;

import java.time.Month;
import java.util.Locale;

import io.github.mmm.value.observable.object.ReadableSimpleObjectValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link Month} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableMonthValue extends ReadableSimpleObjectValue<Month> {

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

}
