/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.value.observable.container.collection.WritableCollectionValue;

/// [WritableCollectionValue] for [List] [value][#get()]s.
///
/// @param <E> type of the [elements][List#contains(Object)].
/// @since 1.0.0
public interface WritableListValue<E> extends WritableCollectionValue<List<E>, E>, ReadableListValue<E> {

  @Override
  default List<E> create() {

    return new ArrayList<>();
  }

}
