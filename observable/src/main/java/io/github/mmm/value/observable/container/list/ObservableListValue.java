/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.List;

import io.github.mmm.value.observable.container.collection.ObservableCollectionValue;

/// [io.github.mmm.value.observable.ObservableValue] with [List] [value][#get()].
///
/// @param <E> type of the [elements][List#contains(Object)].
/// @since 1.0.0
public interface ObservableListValue<E> extends ObservableCollectionValue<List<E>, E>, ReadableListValue<E> {

}
