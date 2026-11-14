/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container;

import io.github.mmm.value.observable.object.WritableObjectValue;

/// [WritableObjectValue] for container [values][#get()] (e.g. [java.util.Collection] or
/// [java.util.Map]).
///
/// @param <C> type of the container [value][#get()].
/// @param <E> type of the contained elements ([collection element][java.util.Collection#contains(Object)] or
///        [map value][java.util.Map#containsValue(Object)]).
/// @since 1.0.0
public interface WritableContainerValue<C, E> extends ReadableContainerValue<C, E>, WritableObjectValue<C> {

  /// @return the current null-safe [value][#get()]. Unlike [#getSafe()] this method will modify and
  ///         initialize the [value][#get()] with an empty mutable container if it was `null`.
  default C getOrCreate() {

    C value = get();
    if (value == null) {
      value = create();
      set(value);
    }
    return value;
  }

  /// @return a new mutable container instance of [value class][#getValueClass()].
  C create();

}
