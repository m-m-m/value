/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import net.sf.mmm.value.observable.containers.collections.WritableObservableCollectionValue;

/**
 * {@link WritableObservableCollectionValue} for {@link ObservableSet} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link ObservableSet#contains(Object) elements}.
 * @since 1.0.0
 */
public interface WritableObservableSetValue<E>
    extends WritableObservableCollectionValue<ObservableSet<E>, E>, ReadableObservableSetValue<E> {

}
