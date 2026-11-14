/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.WritableValue;

/// [WritableValue] for a simple datatype (and not a
/// [container value][io.github.mmm.value.observable.container.ReadableContainerValue]).
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface WritableSimpleValue<V> extends ReadableSimpleValue<V>, WritableValue<V> {

  /// @param valueAsString the [value][#get()] as [string representation][#format(Object)].
  /// @return the parsed value.
  /// @see #getAsString()
  default V setAsString(String valueAsString) {

    V value = parse(valueAsString);
    set(value);
    return value;
  }

}
