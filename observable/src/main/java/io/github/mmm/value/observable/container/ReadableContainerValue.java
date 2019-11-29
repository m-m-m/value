/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container;

import io.github.mmm.value.observable.object.ReadableTypedObjectValue;

/**
 * {@link ReadableTypedObjectValue} for container {@link #get() values} (e.g. {@link java.util.Collection} or
 * {@link java.util.Map}).
 *
 * @param <C> type of the container {@link #get() value}.
 * @param <E> type of the contained elements ({@link java.util.Collection#contains(Object) collection element} or
 *        {@link java.util.Map#containsValue(Object) map value}).
 * @since 1.0.0
 */
public interface ReadableContainerValue<C, E> extends ReadableTypedObjectValue<C> {

  /**
   * @return the {@link java.util.Collection#size() size} of the {@link #get() container}.
   */
  int size();

  /**
   * @return the {@link java.util.Collection#isEmpty() empty state} of the {@link #get() container}.
   */
  default boolean isEmpty() {

    return size() == 0;
  }

}
