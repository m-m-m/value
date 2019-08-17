/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import net.sf.mmm.value.observable.containers.WritableContainerValue;

/**
 * {@link WritableContainerValue} for {@link ObservableMap} {@link #getValue() value}s.
 *
 * @param <K> type of the {@link ObservableMap#containsKey(Object) keys}.
 * @param <V> type of the {@link ObservableMap#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface WritableObservableMapValue<K, V>
    extends WritableContainerValue<ObservableMap<K, V>, V>, ReadableObservableMapValue<K, V> {

}
