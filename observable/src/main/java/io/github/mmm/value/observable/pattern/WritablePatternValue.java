/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.pattern;

import java.util.regex.Pattern;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link WritableValue} with {@link Pattern} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritablePatternValue extends WritableSimpleValue<Pattern>, ReadablePatternValue {

  /**
   * @param value the value to set.
   * @see #get()
   * @see #set(Pattern)
   */
  default void setValue(Pattern value) {

    set(value);
  }

}
