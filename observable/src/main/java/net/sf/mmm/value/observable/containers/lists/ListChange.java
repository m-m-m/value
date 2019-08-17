/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.ContainerChange;
import net.sf.mmm.value.observable.containers.collections.CollectionChange;

/**
 * {@link ContainerChange} for {@link List}s.
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getChange()
 */
public interface ListChange<E> extends CollectionChange<List<E>, E> {

  /**
   * @return the {@link java.util.List#indexOf(Object) index} of the start position of this change, or {@code -1} for
   *         unordered containers (like {@link java.util.Set} or {@link java.util.Map}).
   */
  int getFrom();

  /**
   * @return the {@link java.util.List#indexOf(Object) index} of the end position of this change, or {@code -1} for
   *         unordered containers (like {@link java.util.Set} or {@link java.util.Map}).
   */
  default int getTo() {

    int from = getFrom();
    if (from >= 0) {
      return from + getCount();
    }
    return -1;
  }

}
