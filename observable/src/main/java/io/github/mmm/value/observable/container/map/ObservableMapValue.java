/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.List;
import java.util.Map;

import io.github.mmm.value.observable.container.ObservableContainerValue;

/**
 * {@link io.github.mmm.value.observable.ObservableValue} with {@link List} {@link #get() value}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface ObservableMapValue<K, V> extends ObservableContainerValue<Map<K, V>, V>, ReadableMapValue<K, V> {

}
