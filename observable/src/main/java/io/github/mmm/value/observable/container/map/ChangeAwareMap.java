/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;

import io.github.mmm.value.observable.container.ChangeAwareContainer;

/**
 * {@link io.github.mmm.value.observable.container.ChangeAwareContainer} that is a {@link Map}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface ChangeAwareMap<K, V>
    extends ChangeAwareContainer<V, MapChange<K, V>, MapChangeListener<K, V>>, Map<K, V> {

}
