/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container;

import io.github.mmm.event.EventListener;
import io.github.mmm.event.EventSource;
import io.github.mmm.value.observable.ObservableEvent;

/// A container (e.g. [java.util.Collection] or [java.util.Map]) that can be
/// [observed][#addListener(io.github.mmm.event.EventListener)]. It will send [modification][ObservableEvent#getChange()] [event][ObservableEvent]s, whenever the container is modified (elements added, replaced or
/// removed).
///
/// @param <E> type of the elements in the container.
/// @param <M> type of the [ContainerChange] (event).
/// @param <L> type of the [EventListener].
/// @since 1.0.0
public interface ChangeAwareContainer<E, M extends ContainerChange<?, E>, L extends EventListener<M>>
    extends EventSource<M, L> {

}
