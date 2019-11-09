/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map.impl;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import io.github.mmm.value.observable.container.map.ChangeAwareMap;
import io.github.mmm.value.observable.container.map.MapChangeListener;

/**
 * Abstract base implementation for an immutable {@link ChangeAwareMap}.
 *
 * @param <K> type of the {@link ChangeAwareMap#containsKey(Object) keys}.
 * @param <V> type of the {@link ChangeAwareMap#containsValue(Object) values}.
 * @since 1.0.0
 */
public abstract class ReadOnlyChangeAwareMap<K, V> extends AbstractMap<K, V> implements ChangeAwareMap<K, V> {

  @Override
  public void addListener(MapChangeListener<K, V> listener, boolean weak) {

  }

  @Override
  public boolean removeListener(MapChangeListener<K, V> listener) {

    return false;
  }

  @Override
  public V putIfAbsent(K key, V value) {

    throw new UnsupportedOperationException();
  }

  @Override
  public boolean remove(Object key, Object value) {

    throw new UnsupportedOperationException();
  }

  @Override
  public boolean replace(K key, V oldValue, V newValue) {

    throw new UnsupportedOperationException();
  }

  @Override
  public V replace(K key, V value) {

    throw new UnsupportedOperationException();
  }

  @Override
  public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {

    throw new UnsupportedOperationException();
  }

  @Override
  public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {

    throw new UnsupportedOperationException();
  }

  @Override
  public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {

    throw new UnsupportedOperationException();
  }

  @Override
  public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {

    throw new UnsupportedOperationException();
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> map) {

    if (!map.isEmpty()) {
      throw new UnsupportedOperationException();
    }
  }

}
