/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.Set;

import io.github.mmm.value.observable.container.ContainerChange;
import io.github.mmm.value.observable.container.collection.CollectionChange;

/**
 * {@link ContainerChange} for {@link Set}s.
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 * @see io.github.mmm.value.observable.ObservableEvent#getChange()
 */
public interface SetChange<E> extends CollectionChange<Set<E>, E> {

}
