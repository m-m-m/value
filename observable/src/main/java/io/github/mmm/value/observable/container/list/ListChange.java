/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.List;

import io.github.mmm.value.observable.container.ContainerChange;
import io.github.mmm.value.observable.container.collection.CollectionChange;

/// [ContainerChange] for [List]s.
///
/// @param <E> type of the [contained elements][List#contains(Object)].
/// @since 1.0.0
/// @see io.github.mmm.value.observable.ObservableEvent#getChange()
public interface ListChange<E> extends CollectionChange<List<E>, E> {

  /// @return the [index][java.util.List#indexOf(Object)] of the start position of this change, or `-1` for
  ///         unordered containers (like [java.util.Set] or [java.util.Map]).
  int getFrom();

  /// @return the [index][java.util.List#indexOf(Object)] of the end position of this change, or `-1` for
  ///         unordered containers (like [java.util.Set] or [java.util.Map]).
  default int getTo() {

    int from = getFrom();
    if (from >= 0) {
      return from + getCount();
    }
    return -1;
  }

}
