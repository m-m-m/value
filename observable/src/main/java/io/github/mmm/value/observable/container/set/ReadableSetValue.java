/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.Collections;
import java.util.Set;

import io.github.mmm.value.observable.container.collection.ReadableCollectionValue;

/**
 * {@link ReadableCollectionValue} for {@link Set} {@link #get() value}s.
 *
 * @param <E> type of the {@link Set#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ReadableSetValue<E> extends ReadableCollectionValue<Set<E>, E> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  default Class<Set<E>> getValueClass() {

    return (Class) Set.class;
  }

  @Override
  default Set<E> getSafe() {

    Set<E> value = get();
    if (value == null) {
      value = Collections.emptySet();
    }
    return value;
  }

}
