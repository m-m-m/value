/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.Collections;
import java.util.List;

import io.github.mmm.value.observable.container.collection.ReadableCollectionValue;

/**
 * {@link ReadableCollectionValue} for {@link List} {@link #get() value}s.
 *
 * @param <E> type of the {@link List#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ReadableListValue<E> extends ReadableCollectionValue<List<E>, E> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  default Class<List<E>> getValueClass() {

    return (Class) List.class;
  }

  @Override
  default List<E> getSafe() {

    List<E> value = get();
    if (value == null) {
      value = Collections.emptyList();
    }
    return value;
  }

}
