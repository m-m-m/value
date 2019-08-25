/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import net.sf.mmm.event.EventListener;

/**
 * {@link EventListener} for {@link ObservableEvent}s.
 *
 * @param <V> type of observed {@link ObservableValue#getValue() value}.
 * @since 1.0.0
 * @see ChangeAwareObservableEventListener
 */
@FunctionalInterface
public interface ObservableEventListener<V> extends EventListener<ObservableEvent<V>> {

}
