/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.object.ObservableSimpleValue;

/**
 * {@link ObservableValue} with {@link Pattern} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ObservablePatternValue extends ObservableSimpleValue<Pattern>, ReadablePatternValue {

  /**
   * @param input the string to match.
   * @return the {@link Matcher}.
   * @see Pattern#matcher(CharSequence)
   */
  default Matcher matcher(CharSequence input) {

    return getSafe().matcher(input);
  }

  /**
   * @param input the string to match.
   * @return {@code true} if the given {@code input} matches the {@link #get() regex pattern}, {@code false} otherwise.
   * @see Pattern#matches(String, CharSequence)
   */
  default boolean matches(CharSequence input) {

    return matcher(input).matches();
  }

}
