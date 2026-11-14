/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.ReadableValue;

/// [ReadableValue] for a simple datatype (and not a
/// [container value][io.github.mmm.value.observable.container.ReadableContainerValue]).
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface ReadableSimpleValue<V> extends ReadableValue<V> {

  /// @param valueAsString the value as [String]. May be `null`.
  /// @return the parsed `value`. May be `null` (e.g. if the given [String] is `null`).
  V parse(String valueAsString);

  /// @return the [value][#get()] as [String].
  default String getAsString() {

    return format(get());
  }

  /// @param value the [value][#get()].
  /// @return the [string representation][#toString()] of the given `value`. Will typically be `null` if
  ///         `value` is `null`.
  default String format(V value) {

    if (value == null) {
      return null;
    }
    return value.toString();
  }

}
