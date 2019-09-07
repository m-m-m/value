/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.list;

import java.util.List;

import net.sf.mmm.value.observable.ChangeAwareObservableEventListener;
import net.sf.mmm.value.observable.ObservableEvent;

/**
 * {@link ChangeAwareObservableEventListener Listener} for {@link ObservableListValue} and its sub-types. This interface
 * only exists for your convenience to avoid casting or type guessing. You may still directly implement
 * {@link ChangeAwareObservableEventListener} if you prefer.
 *
 * @param <E> type of the {@link List#contains(Object) contained elements}.
 * @since 1.0.0
 */
public interface ChangeAwareListEventListener<E> extends ChangeAwareObservableEventListener<List<E>> {

  @Override
  default void onEvent(ObservableEvent<List<E>> event) {

    ListChange<E> change = event.getChange();
    onChange(change, event);
  }

  /**
   * @param change the {@link ListChange}. May be {@code null} if the entire contained changed.
   * @param event the original {@link ObservableEvent}. May be ignored if {{@code change} is not {@code null}.
   */
  void onChange(ListChange<E> change, ObservableEvent<List<E>> event);

}
