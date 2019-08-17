/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import net.sf.mmm.event.EventListener;

/**
 * {@link EventListener} with ability for change events.
 *
 * @param <E> the type of the {@link #onEvent(Object) handled} events.
 * @since 1.0.0
 * @see ChangeAwareObservableEventListener
 */
public abstract interface EventListenerWithChange<E> extends EventListener<E> {

  /**
   * @return {@code true} if this listener is also interested in {@link ObservableEvent#getChange() value modification
   *         changes of mutable value instances}, {@code false} otherwise.
   */
  default boolean isChangeAware() {

    return false;
  }

}
