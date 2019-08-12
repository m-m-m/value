/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.value.observable.containers.WritableContainerValue;

/**
 * {@link WritableContainerValue} for {@link Map} {@link #getValue() value}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <E> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface WritableMapValue<K, E> extends WritableContainerValue<Map<K, E>, E>, ReadableMapValue<K, E> {

}
