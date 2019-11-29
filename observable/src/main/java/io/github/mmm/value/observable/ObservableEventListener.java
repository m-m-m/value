/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

import io.github.mmm.event.EventListener;

/**
 * {@link EventListener} for {@link ObservableEvent}s.
 *
 * @param <V> type of observed {@link ObservableValue#get() value}.
 * @since 1.0.0
 * @see ChangeAwareObservableEventListener
 */
@FunctionalInterface
public interface ObservableEventListener<V> extends EventListener<ObservableEvent<V>> {

}
