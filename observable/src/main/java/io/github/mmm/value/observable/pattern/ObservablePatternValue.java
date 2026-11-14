/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.object.ObservableSimpleValue;

/// [ObservableValue] with [Pattern] [value][#getValue()].
///
/// @since 1.0.0
public interface ObservablePatternValue extends ObservableSimpleValue<Pattern>, ReadablePatternValue {

  /// @param input the string to match.
  /// @return the [Matcher].
  /// @see Pattern#matcher(CharSequence)
  default Matcher matcher(CharSequence input) {

    return getSafe().matcher(input);
  }

  /// @param input the string to match.
  /// @return `true` if the given `input` matches the [regex pattern][#get()], `false` otherwise.
  /// @see Pattern#matches(String, CharSequence)
  default boolean matches(CharSequence input) {

    return matcher(input).matches();
  }

}
