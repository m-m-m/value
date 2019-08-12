/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists.impl;

import java.util.List;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.collections.impl.CollectionChangeEventImpl;
import net.sf.mmm.value.observable.containers.lists.ListChangeEvent;

/**
 * Implementation of {@link ListChangeEvent}.
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public class ListChangeEventImpl<E> extends CollectionChangeEventImpl<List<E>, E> implements ListChangeEvent<E> {

  private final List<E> container;

  private final int from;

  /**
   * The constructor.
   *
   * @param container the {@link List} that changed.
   * @param from the {@link #getFrom() start index}.
   * @param removedElements the elements that have been removed for the {@link List}.
   */
  public ListChangeEventImpl(List<E> container, int from, E[] removedElements) {

    super(ChangeType.REMOVE, removedElements);
    this.container = container;
    this.from = from;
  }

  /**
   * The constructor.
   *
   * @param container the {@link List} that changed.
   * @param type the {@link ChangeType}.
   * @param from the {@link #getFrom() start index}.
   * @param count the {@link #getCount() number of changed elements}.
   */
  public ListChangeEventImpl(List<E> container, ChangeType type, int from, int count) {

    super(type, count);
    this.container = container;
    this.from = from;
  }

  @Override
  public List<E> getContainer() {

    return this.container;
  }

  @Override
  public E getElement(int index) {

    if (this.type == ChangeType.REMOVE) {
      return super.getElement(index);
    }
    return this.container.get(this.from + index);
  }

  @Override
  public int getFrom() {

    return this.from;
  }

}
