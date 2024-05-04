/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Collections;
import java.util.Map;

import io.github.mmm.value.observable.container.ReadableContainerValue;

/**
 * {@link ReadableContainerValue} for {@link Map} {@link #get() value}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface ReadableMapValue<K, V> extends ReadableContainerValue<Map<K, V>, V> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  default Class<Map<K, V>> getValueClass() {

    return (Class) Map.class;
  }

  @Override
  default int size() {

    return getSafe().size();
  }

  @Override
  default Map<K, V> getStaticSafeValue() {

    return Collections.emptyMap();
  }

}
