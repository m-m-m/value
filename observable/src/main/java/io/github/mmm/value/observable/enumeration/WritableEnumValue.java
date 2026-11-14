/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.enumeration;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/// [WritableValue] with [Enum] [value][#getValue()].
///
/// @param <E> type of [Enum] [value][#getValue()].
/// @since 1.0.0
public interface WritableEnumValue<E extends Enum<E>> extends WritableSimpleValue<E>, ReadableEnumValue<E> {

  /// @param value the value to set.
  /// @see #get()
  /// @see #set(Object)
  default void setValue(E value) {

    set(value);
  }

}
