/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections;

/**
 * {@link net.sf.mmm.value.observable.ObservableValue} with {@link ObservableCollection} {@link #getValue() value}.
 *
 * @param <C> type of the {@link ObservableCollection} {@link #getValue() value}.
 * @param <E> type of the {@link ObservableCollection#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ObservableObservableCollectionValue<C extends ObservableCollection<E, ?, ?>, E>
    extends ObservableCollectionValue<C, E>, ReadableObservableCollectionValue<C, E> {

}
