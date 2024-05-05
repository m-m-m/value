/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.pattern;

import java.util.regex.Pattern;

import io.github.mmm.value.ReadableTypedValue;
import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link ReadableTypedValue} with {@link Pattern} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadablePatternValue extends ReadableSimpleValue<Pattern> {

  /** @see #getFallbackSafeValue() */
  Pattern STATIC_SAFE_VALUE = Pattern.compile("");

  @Override
  default String getAsString() {

    Pattern p = get();
    if (p == null) {
      return null;
    }
    return p.pattern();
  }

  @Override
  default Class<Pattern> getValueClass() {

    return Pattern.class;
  }

  /**
   * Same as {@link #get()}.
   *
   * @return the current {@link #get() value}.
   */
  default Pattern getValue() {

    return get();
  }

  @Override
  default Pattern getFallbackSafeValue() {

    return STATIC_SAFE_VALUE;
  }

}
