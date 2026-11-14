/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.collection;

import java.util.Collection;

import io.github.mmm.value.observable.container.ReadableContainerValue;

/// [ReadableContainerValue] for [Collection] [value][#get()]s.
///
/// @param <C> type of the [Collection] [value][#get()].
/// @param <E> type of the [elements][Collection#contains(Object)].
/// @since 1.0.0
public interface ReadableCollectionValue<C extends Collection<E>, E> extends ReadableContainerValue<C, E> {

  @Override
  default int size() {

    return getSafe().size();
  }

  @Override
  default boolean isEmpty() {

    C collection = get();
    return (collection == null) || collection.isEmpty();
  }

}
