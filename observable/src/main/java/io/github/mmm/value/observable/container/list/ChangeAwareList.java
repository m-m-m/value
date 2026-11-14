/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.List;

import io.github.mmm.value.observable.container.collection.ChangeAwareCollection;

/// [io.github.mmm.value.observable.container.ChangeAwareContainer] that is a [List].
///
/// @param <E> type of the [contained elements][List#contains(Object)].
/// @since 1.0.0
public interface ChangeAwareList<E> extends ChangeAwareCollection<E, ListChange<E>, ListChangeListener<E>>, List<E> {

  /// [Removes][#remove(int)] the elements within the given range. Behaves like `sublist(from, to).clear()`
  /// but can be implemented more efficient.
  ///
  /// @param from the start [index][#indexOf(Object)] of the range to remove (inclusive).
  /// @param to the end [index][#indexOf(Object)] of the range to remove (exclusive).
  /// @throws IndexOutOfBoundsException if an illegal range is provided.
  void remove(int from, int to);

}
