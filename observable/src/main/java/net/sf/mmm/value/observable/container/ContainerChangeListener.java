/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container;

import net.sf.mmm.event.EventListener;

/**
 * {@link EventListener} for {@link ContainerChange}s.
 *
 * @param <C> type of the {@link ContainerChange change}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getChange()
 */
public interface ContainerChangeListener<C extends ContainerChange<?, ?>> extends EventListener<C> {

}
