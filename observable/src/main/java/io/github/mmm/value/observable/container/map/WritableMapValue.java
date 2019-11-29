/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.HashMap;
import java.util.Map;

import io.github.mmm.value.observable.container.WritableContainerValue;

/**
 * {@link WritableContainerValue} for {@link Map} {@link #get() value}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface WritableMapValue<K, V> extends WritableContainerValue<Map<K, V>, V>, ReadableMapValue<K, V> {

  @Override
  default Map<K, V> getOrCreateValue() {

    Map<K, V> value = get();
    if (value == null) {
      value = new HashMap<>();
      set(value);
    }
    return value;
  }

}
