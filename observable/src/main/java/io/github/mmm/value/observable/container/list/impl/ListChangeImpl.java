/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list.impl;

import java.util.List;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.collection.impl.AbstractCollectionChange;
import io.github.mmm.value.observable.container.list.ListChange;

/// Implementation of [ListChange].
///
/// @param <E> type of the [elements][#getElement(int)].
/// @since 1.0.0
public class ListChangeImpl<E> extends AbstractCollectionChange<List<E>, E> implements ListChange<E> {

  private final List<E> container;

  private final int from;

  /// The constructor.
  ///
  /// @param container the [List] that changed.
  /// @param from the [start index][#getFrom()].
  /// @param removedElements the elements that have been removed for the [List].
  public ListChangeImpl(List<E> container, int from, Object[] removedElements) {

    super(ChangeType.REMOVE, removedElements);
    this.container = container;
    this.from = from;
  }

  /// The constructor.
  ///
  /// @param container the [List] that changed.
  /// @param type the [ChangeType].
  /// @param from the [start index][#getFrom()].
  /// @param count the [number of changed elements][#getCount()].
  public ListChangeImpl(List<E> container, ChangeType type, int from, int count) {

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
