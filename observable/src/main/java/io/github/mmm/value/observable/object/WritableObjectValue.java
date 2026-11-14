/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.WritableValue;

/// [WritableValue] for [Object] [value][#getValue()] that has no primitive type.
///
/// @param <V> type of the [value][#getValue()].
/// @since 1.0.0
public interface WritableObjectValue<V> extends ReadableObjectValue<V>, WritableValue<V> {

  /// Same as [#set(Object)].
  ///
  /// @param value the new value.
  default void setValue(V value) {

    set(value);
  }

}
