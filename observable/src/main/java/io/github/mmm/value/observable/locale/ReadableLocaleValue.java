/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.locale;

import java.util.Locale;

import io.github.mmm.value.ReadableTypedValue;
import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link ReadableTypedValue} with {@link Locale} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableLocaleValue extends ReadableSimpleValue<Locale> {

  @Override
  default String getAsString() {

    return getSafe().toString();
  }

  @Override
  default Class<Locale> getValueClass() {

    return Locale.class;
  }

  @Override
  default Locale getFallbackSafeValue() {

    return Locale.ROOT;
  }

}
