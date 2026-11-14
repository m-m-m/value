/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;

import io.github.mmm.value.observable.container.ChangeAwareContainer;

/// [io.github.mmm.value.observable.container.ChangeAwareContainer] that is a [Map].
///
/// @param <K> type of the [keys][Map#containsKey(Object)].
/// @param <V> type of the [values][Map#containsValue(Object)].
/// @since 1.0.0
public interface ChangeAwareMap<K, V>
    extends ChangeAwareContainer<V, MapChange<K, V>, MapChangeListener<K, V>>, Map<K, V> {

}
