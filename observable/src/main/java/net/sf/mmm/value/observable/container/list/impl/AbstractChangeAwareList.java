/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.list.impl;

import java.util.AbstractList;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.event.EventSourceAdapter;
import net.sf.mmm.value.observable.container.list.ChangeAwareList;
import net.sf.mmm.value.observable.container.list.ListChange;
import net.sf.mmm.value.observable.container.list.ListChangeListener;

/**
 * Abstract base implementation of {@link ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public abstract class AbstractChangeAwareList<E> extends AbstractList<E> implements ChangeAwareList<E> {

  private EventSourceAdapter<ListChange<E>, ListChangeListener<E>> eventAdapter;

  /**
   * The constructor.
   */
  public AbstractChangeAwareList() {

    super();
    this.eventAdapter = EventSourceAdapter.empty();
  }

  @Override
  public void addListener(ListChangeListener<E> listener, boolean weak) {

    this.eventAdapter = this.eventAdapter.addListener(listener, weak);
  }

  @Override
  public boolean removeListener(ListChangeListener<E> listener) {

    EventSourceAdapter<ListChange<E>, ListChangeListener<E>> adapter = this.eventAdapter
        .removeListener(listener);
    if (adapter == null) {
      return false;
    }
    this.eventAdapter = adapter;
    return true;
  }

  /**
   * @return {@code true} if at least one {@link ListChangeListener} is
   *         {@link #addListener(ListChangeListener, boolean) registered}, {@code false} otherwise.
   */
  protected boolean hasListeners() {

    return this.eventAdapter.hasListeners();
  }

  /**
   * @param modification the {@link ListChange} to {@link ListChangeListener#onEvent(Object) send} to all
   *        {@link #addListener(ListChangeListener, boolean) registered} {@link ListChangeListener}s.
   */
  protected void fireEvent(ListChange<E> modification) {

    if (modification == null) {
      return;
    }
    this.eventAdapter.fireEvent(modification);
  }

  /**
   * @return a new {@link ListChange} notifying about a remove of all current elements. May be {@code null}.
   */
  protected ListChange<E> modRemoveAll() {

    if (isEmpty() || !this.eventAdapter.hasListeners()) {
      return null;
    }
    Object[] elements = toArray();
    return new ListChangeImpl<>(this, 0, elements);
  }

  /**
   * @param from the {@link #indexOf(Object) index} of the element that is going to be removed.
   * @return a new {@link ListChange} notifying about a remove of a single element at the given {@code from}
   *         index. May be {@code null}.
   */
  protected ListChange<E> modRemove(int from) {

    if (!this.eventAdapter.hasListeners()) {
      return null;
    }
    Object[] elements = new Object[] { get(from) };
    return new ListChangeImpl<>(this, from, elements);
  }

  /**
   * @param from the start {@link #indexOf(Object) index} of the range to be removed (inclusive).
   * @param to the end {@link #indexOf(Object) index} of the range to be removed (exclusive).
   * @return a new {@link ListChange} notifying about a remove of the elements in the specified range. May be
   *         {@code null}.
   */
  protected ListChange<E> modRemove(int from, int to) {

    if ((from < 0) || (to == from) || (from >= to) || !this.eventAdapter.hasListeners()) {
      return null;
    }
    Object[] elements = new Object[to - from];
    for (int i = 0; i < elements.length; i++) {
      elements[i] = get(to + i);
    }
    return new ListChangeImpl<>(this, from, elements);
  }

  /**
   * @param from the start {@link #indexOf(Object) index} where the element(s) have been inserted.
   * @param count the number of inserted elements.
   */
  protected void fireAdd(int from, int count) {

    if (!this.eventAdapter.hasListeners()) {
      return;
    }
    fireEvent(new ListChangeImpl<>(this, ChangeType.ADD, from, count));
  }

  /**
   * @param from the start {@link #indexOf(Object) index} where the element(s) have been updated (replaced).
   * @param count the number of updated elements.
   */
  protected void fireUpdate(int from, int count) {

    if (!this.eventAdapter.hasListeners()) {
      return;
    }
    fireEvent(new ListChangeImpl<>(this, ChangeType.UPDATE, from, count));
  }

  /**
   * @param index the {@link #indexOf(Object) index} of the element that has been removed.
   * @param element the element that has been removed.
   */
  protected void fireRemove(int index, Object element) {

    if (!this.eventAdapter.hasListeners()) {
      return;
    }
    fireEvent(new ListChangeImpl<>(this, index, new Object[] { element }));
  }

  @Override
  public void remove(int from, int to) {

    removeRange(from, to);
  }

}
