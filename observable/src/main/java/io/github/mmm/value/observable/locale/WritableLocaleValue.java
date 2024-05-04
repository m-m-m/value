/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.locale;

import java.util.Locale;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link WritableValue} with {@link Locale} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface WritableLocaleValue extends WritableSimpleValue<Locale>, ReadableLocaleValue {

  @Override
  default Locale parse(String value) {

    return Locale.forLanguageTag(value.replace('_', '-'));
  }

  @Override
  void set(Locale value);

  /**
   * @param value the value to set.
   * @see #get()
   * @see #set(Locale)
   */
  default void setValue(Locale value) {

    set(value);
  }

}
