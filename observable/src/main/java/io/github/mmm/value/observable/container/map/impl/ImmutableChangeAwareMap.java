/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map.impl;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import io.github.mmm.base.collection.ReadOnlyIterator;

/**
 * Immutable implementation of {@link io.github.mmm.value.observable.container.map.ChangeAwareMap}.
 *
 * @param <K> type of the {@link java.util.Map#containsKey(Object) keys}.
 * @param <V> type of the {@link java.util.Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public class ImmutableChangeAwareMap<K, V> extends ReadOnlyChangeAwareMap<K, V> {

  private final Map<K, V> map;

  /**
   * The constructor.
   *
   * @param map the internal {@link Map} to adopt.
   */
  public ImmutableChangeAwareMap(Map<K, V> map) {

    super();
    this.map = map;
  }

  @Override
  public int size() {

    return this.map.size();
  }

  @Override
  public boolean containsKey(Object key) {

    return this.map.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {

    return this.map.containsValue(value);
  }

  @Override
  public V get(Object key) {

    return this.map.get(key);
  }

  @Override
  public Set<Entry<K, V>> entrySet() {

    return new EntrySet();
  }

  private class EntrySet extends AbstractSet<Entry<K, V>> {

    private final Set<Entry<K, V>> entrySet;

    public EntrySet() {

      super();
      this.entrySet = ImmutableChangeAwareMap.this.map.entrySet();
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {

      return new ReadOnlyIterator<>(this.entrySet.iterator());
    }

    @Override
    public void clear() {

      throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

      return ImmutableChangeAwareMap.this.map.size();
    }
  }

}
