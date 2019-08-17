/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections;

import java.util.Collection;

import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link ObservableValue} with {@link Collection} {@link #getValue() value}.
 *
 * @param <C> type of the {@link Collection} {@link #getValue() value}.
 * @param <E> type of the {@link Collection#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ObservableCollectionValue<C extends Collection<E>, E>
    extends ObservableValue<C>, ReadableCollectionValue<C, E> {

}
