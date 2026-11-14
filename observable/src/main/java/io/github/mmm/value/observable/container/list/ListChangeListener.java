/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import io.github.mmm.value.observable.container.collection.CollectionChangeListener;

/// [CollectionChangeListener] for [ListChange]s.
///
/// @param <E> type of the [elements][ListChange#getElement(int)].
/// @since 1.0.0
/// @see io.github.mmm.value.observable.ObservableEvent#getChange()
@FunctionalInterface
public interface ListChangeListener<E> extends CollectionChangeListener<ListChange<E>> {

}
