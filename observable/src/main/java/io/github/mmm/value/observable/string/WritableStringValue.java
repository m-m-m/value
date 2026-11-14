/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.string;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/// [WritableValue] with [String] [value][#getValue()].
///
/// @since 1.0.0
public interface WritableStringValue extends WritableSimpleValue<String>, ReadableStringValue {

  @Override
  default String setAsString(String value) {

    set(value);
    return value;
  }

  /// @param value the value to set.
  /// @see #get()
  /// @see #set(String)
  default void setValue(String value) {

    set(value);
  }

}
