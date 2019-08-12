/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.collections.ReadableCollectionValue;

/**
 * {@link ReadableCollectionValue} for {@link List} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link List#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ReadableListValue<E> extends ReadableCollectionValue<E, List<E>> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  default Class<List<E>> getValueClass() {

    return (Class) List.class;
  }

}
