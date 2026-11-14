/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.Set;

import io.github.mmm.value.observable.container.collection.ObservableCollectionValue;

/// [io.github.mmm.value.observable.ObservableValue] with [Set] [value][#get()].
///
/// @param <E> type of the [elements][Set#contains(Object)].
/// @since 1.0.0
public interface ObservableSetValue<E> extends ObservableCollectionValue<Set<E>, E>, ReadableSetValue<E> {

}
