/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import io.github.mmm.value.observable.container.collection.CollectionChangeListener;

/**
 * {@link CollectionChangeListener} for {@link SetChange}s.
 *
 * @param <E> type of the {@link SetChange#getElement(int) elements}.
 * @since 1.0.0
 * @see io.github.mmm.value.observable.ObservableEvent#getChange()
 */
@FunctionalInterface
public interface SetChangeListener<E> extends CollectionChangeListener<SetChange<E>> {

}
