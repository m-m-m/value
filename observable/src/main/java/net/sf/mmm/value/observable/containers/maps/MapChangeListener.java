/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import net.sf.mmm.event.EventListener;
import net.sf.mmm.value.observable.containers.ContainerChangeListener;

/**
 * {@link EventListener} for {@link MapChange}s.
 *
 * @param <K> type of the {@link MapChange#getKey(int) keys}.
 * @param <V> type of the {@link MapChange#getElement(int) elements}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getChange()
 */
@FunctionalInterface
public interface MapChangeListener<K, V> extends ContainerChangeListener<MapChange<K, V>> {

}
