/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.pattern;

import java.util.regex.Pattern;

import io.github.mmm.value.observable.object.ReadableSimpleObjectValue;

/**
 * {@link ReadableSimpleObjectValue} with {@link Pattern} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadablePatternValue extends ReadableSimpleObjectValue<Pattern> {

  /** @see #getFallbackSafeValue() */
  Pattern STATIC_SAFE_VALUE = Pattern.compile("");

  @Override
  default Class<Pattern> getValueClass() {

    return Pattern.class;
  }

  /**
   * Same as {@link #get()}.
   *
   * @return the current {@link #get() value}.
   */
  @Override
  default Pattern getValue() {

    return get();
  }

  @Override
  default Pattern getFallbackSafeValue() {

    return STATIC_SAFE_VALUE;
  }

  @Override
  default Pattern parse(String value) {

    if (value == null) {
      return null;
    }
    return Pattern.compile(value);
  }

}
