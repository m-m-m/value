/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.value.observable.containers.ReadableContainerValue;

/**
 * {@link ReadableContainerValue} for {@link Map} {@link #getValue() value}s.
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

    return getValueSafe().size();
  }

}
