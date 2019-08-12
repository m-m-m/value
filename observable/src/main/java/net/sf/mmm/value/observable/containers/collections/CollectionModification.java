/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections;

import java.util.Collection;

import net.sf.mmm.value.observable.containers.ContainerChangeEvent;

/**
 * {@link ContainerChangeEvent} for {@link Collection}s.
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public interface CollectionChangeEvent<C extends Collection<E>, E> extends ContainerChangeEvent<C, E> {

}
