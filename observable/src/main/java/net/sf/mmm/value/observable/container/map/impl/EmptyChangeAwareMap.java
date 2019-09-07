/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.map.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Empty singleton implementation of {@link net.sf.mmm.value.observable.container.map.ChangeAwareMap}.
 *
 * @param <K> type of the {@link java.util.Map#containsKey(Object) keys}.
 * @param <V> type of the {@link java.util.Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public class EmptyChangeAwareMap<K, V> extends ReadOnlyChangeAwareMap<K, V> {

  /** The singleton instance. */
  @SuppressWarnings("rawtypes")
  public static EmptyChangeAwareMap INSTANCE = new EmptyChangeAwareMap<>();

  @Override
  public boolean isEmpty() {

    return true;
  }

  @Override
  public int size() {

    return 0;
  }

  @Override
  public boolean containsKey(Object key) {

    return false;
  }

  @Override
  public boolean containsValue(Object value) {

    return false;
  }

  @Override
  public V get(Object key) {

    return null;
  }

  @Override
  public Set<Entry<K, V>> entrySet() {

    return Collections.emptySet();
  }

  @Override
  public Set<K> keySet() {

    return Collections.emptySet();
  }

  @Override
  public Collection<V> values() {

    return Collections.emptySet();
  }

  @Override
  public V getOrDefault(Object k, V defaultValue) {

    return defaultValue;
  }

  @Override
  public void forEach(BiConsumer<? super K, ? super V> action) {

    Objects.requireNonNull(action);
  }

  @Override
  public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    Objects.requireNonNull(function);
  }

}
