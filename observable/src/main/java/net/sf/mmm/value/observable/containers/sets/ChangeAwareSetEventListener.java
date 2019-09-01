/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import java.util.Set;

import net.sf.mmm.value.observable.ChangeAwareObservableEventListener;
import net.sf.mmm.value.observable.ObservableEvent;

/**
 * {@link ChangeAwareObservableEventListener Listener} for {@link ObservableSetValue} and its sub-types. This interface
 * only exists for your convenience to avoid casting or type guessing. You may still directly implement
 * {@link ChangeAwareObservableEventListener} if you prefer.
 *
 * @param <E> type of the {@link Set#contains(Object) contained elements}.
 * @since 1.0.0
 */
public interface ChangeAwareSetEventListener<E> extends ChangeAwareObservableEventListener<Set<E>> {

  @Override
  default void onEvent(ObservableEvent<Set<E>> event) {

    SetChange<E> change = event.getChange();
    onChange(change, event);
  }

  /**
   * @param change the {@link SetChange}. May be {@code null} if the entire contained changed.
   * @param event the original {@link ObservableEvent}. May be ignored if {{@code change} is not {@code null}.
   */
  void onChange(SetChange<E> change, ObservableEvent<Set<E>> event);

}
