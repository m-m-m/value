/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import java.util.Set;

import net.sf.mmm.value.observable.containers.ContainerChange;
import net.sf.mmm.value.observable.containers.collections.CollectionChange;

/**
 * {@link ContainerChange} for {@link Set}s.
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getChange()
 */
public interface SetChange<E> extends CollectionChange<Set<E>, E> {

}
