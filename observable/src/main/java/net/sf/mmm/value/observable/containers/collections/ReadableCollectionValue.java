/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections;

import java.util.Collection;

import net.sf.mmm.value.observable.containers.ReadableContainerValue;

/**
 * {@link ReadableContainerValue} for {@link java.util.Collection} {@link #getValue() values}.
 *
 * @param <E> type of the {@link Collection#contains(Object) elements}.
 * @param <C> type of the {@link Collection}.
 * @since 1.0.0
 */
public interface ReadableCollectionValue<E, C extends Collection<E>> extends ReadableContainerValue<C> {

}
