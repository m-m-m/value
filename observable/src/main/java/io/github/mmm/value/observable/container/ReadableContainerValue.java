/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container;

import io.github.mmm.value.observable.object.ReadableObjectValue;

/// [ReadableObjectValue] for container [values][#get()] (e.g. [java.util.Collection] or
/// [java.util.Map]).
///
/// @param <C> type of the container [value][#get()].
/// @param <E> type of the contained elements ([collection element][java.util.Collection#contains(Object)] or
///        [map value][java.util.Map#containsValue(Object)]).
/// @since 1.0.0
public interface ReadableContainerValue<C, E> extends ReadableObjectValue<C> {

  /// @return the [size][java.util.Collection#size()] of the [container][#get()].
  int size();

  /// @return the [empty state][java.util.Collection#isEmpty()] of the [container][#get()].
  default boolean isEmpty() {

    return size() == 0;
  }

}
