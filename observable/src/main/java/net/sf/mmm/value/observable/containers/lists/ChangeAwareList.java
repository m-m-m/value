/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.collections.ChangeAwareCollection;

/**
 * {@link net.sf.mmm.value.observable.containers.ChangeAwareContainer} that is a {@link List}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public interface ChangeAwareList<E>
    extends ChangeAwareCollection<E, ListChange<E>, ListChangeListener<E>>, List<E> {

  /**
   * {@link #remove(int) Removes} the elements within the given range. Behaves like {@code sublist(from, to).clear()}
   * but can be implemented more efficient.
   *
   * @param from the start {@link #indexOf(Object) index} of the range to remove (inclusive).
   * @param to the end {@link #indexOf(Object) index} of the range to remove (exclusive).
   * @throws IndexOutOfBoundsException if an illegal range is provided.
   */
  void remove(int from, int to);

}
