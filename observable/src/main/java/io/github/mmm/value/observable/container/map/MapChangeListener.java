/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import io.github.mmm.event.EventListener;
import io.github.mmm.value.observable.container.ContainerChangeListener;

/**
 * {@link EventListener} for {@link MapChange}s.
 *
 * @param <K> type of the {@link MapChange#getKey(int) keys}.
 * @param <V> type of the {@link MapChange#getElement(int) elements}.
 * @since 1.0.0
 * @see io.github.mmm.value.observable.ObservableEvent#getChange()
 */
@FunctionalInterface
public interface MapChangeListener<K, V> extends ContainerChangeListener<MapChange<K, V>> {

}
