/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets.impl;

import java.util.AbstractSet;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.event.EventSourceAdapter;
import net.sf.mmm.value.observable.containers.sets.ChangeAwareSet;
import net.sf.mmm.value.observable.containers.sets.SetChange;
import net.sf.mmm.value.observable.containers.sets.SetChangeListener;

/**
 * Abstract base implementation of {@link ChangeAwareSet}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public abstract class AbstractChangeAwareSet<E> extends AbstractSet<E> implements ChangeAwareSet<E> {

  private EventSourceAdapter<SetChange<E>, SetChangeListener<E>> eventAdapter;

  /**
   * The constructor.
   */
  public AbstractChangeAwareSet() {

    super();
    this.eventAdapter = EventSourceAdapter.empty();
  }

  @Override
  public void addListener(SetChangeListener<E> listener, boolean weak) {

    this.eventAdapter = this.eventAdapter.addListener(listener, weak);
  }

  @Override
  public boolean removeListener(SetChangeListener<E> listener) {

    EventSourceAdapter<SetChange<E>, SetChangeListener<E>> adapter = this.eventAdapter.removeListener(listener);
    if (adapter == null) {
      return false;
    }
    this.eventAdapter = adapter;
    return true;
  }

  /**
   * @return {@code true} if at least one {@link SetChangeListener} is {@link #addListener(SetChangeListener, boolean)
   *         registered}, {@code false} otherwise.
   */
  protected boolean hasListeners() {

    return this.eventAdapter.hasListeners();
  }

  /**
   * @param modification the {@link SetChange} to {@link SetChangeListener#onEvent(Object) send} to all
   *        {@link #addListener(SetChangeListener, boolean) registered} {@link SetChangeListener}s.
   */
  protected void fireEvent(SetChange<E> modification) {

    if (modification == null) {
      return;
    }
    this.eventAdapter.fireEvent(modification);
  }

  /**
   * @param elements the added elements.
   */
  protected void fireAdd(Object... elements) {

    if (hasListeners()) {
      return;
    }
    SetChange<E> modification = new SetChangeImpl<>(this, ChangeType.ADD, elements);
    this.eventAdapter.fireEvent(modification);
  }

  /**
   * @param elements the removed elements.
   */
  protected void fireRemove(Object... elements) {

    if (hasListeners()) {
      return;
    }
    SetChange<E> modification = new SetChangeImpl<>(this, ChangeType.REMOVE, elements);
    this.eventAdapter.fireEvent(modification);
  }

}
