/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container;

import net.sf.mmm.event.EventListener;
import net.sf.mmm.event.EventSource;
import net.sf.mmm.value.observable.ObservableEvent;

/**
 * A container (e.g. {@link java.util.Collection} or {@link java.util.Map}) that can be
 * {@link #addListener(net.sf.mmm.event.EventListener) observed}. It will send {@link ObservableEvent#getChange()
 * modification} {@link ObservableEvent event}s, whenever the container is modified (elements added, replaced or
 * removed).
 *
 * @param <E> type of the elements in the container.
 * @param <M> type of the {@link ContainerChange} (event).
 * @param <L> type of the {@link EventListener}.
 * @since 1.0.0
 */
public interface ChangeAwareContainer<E, M extends ContainerChange<?, E>, L extends EventListener<M>>
    extends EventSource<M, L> {

}
