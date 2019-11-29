/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.List;

import io.github.mmm.value.observable.container.collection.ObservableCollectionValue;

/**
 * {@link io.github.mmm.value.observable.ObservableValue} with {@link List} {@link #get() value}.
 *
 * @param <E> type of the {@link List#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ObservableListValue<E> extends ObservableCollectionValue<List<E>, E>, ReadableListValue<E> {

}
