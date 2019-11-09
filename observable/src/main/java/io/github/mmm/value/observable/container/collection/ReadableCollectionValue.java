/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.collection;

import java.util.Collection;

import io.github.mmm.value.observable.container.ReadableContainerValue;

/**
 * {@link ReadableContainerValue} for {@link Collection} {@link #getValue() value}s.
 *
 * @param <C> type of the {@link Collection} {@link #getValue() value}.
 * @param <E> type of the {@link Collection#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ReadableCollectionValue<C extends Collection<E>, E> extends ReadableContainerValue<C, E> {

  @Override
  default int size() {

    return getValueSafe().size();
  }

}
