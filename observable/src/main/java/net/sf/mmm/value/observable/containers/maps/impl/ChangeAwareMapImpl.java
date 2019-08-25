/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps.impl;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.mmm.value.observable.containers.maps.MapChange;

/**
 * Regular mutable implementation of {@link net.sf.mmm.value.observable.containers.maps.ChangeAwareMap}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public class ChangeAwareMapImpl<K, V> extends AbstractChangeAwareMap<K, V> {

  private final Map<K, V> map;

  /**
   * The constructor.
   */
  public ChangeAwareMapImpl() {

    this(new HashMap<>());
  }

  /**
   * The constructor.
   *
   * @param capacity the initial capacity.
   */
  public ChangeAwareMapImpl(int capacity) {

    this(new HashMap<>(capacity));
  }

  /**
   * The constructor.
   *
   * @param map the adapted {@link Map}.
   */
  public ChangeAwareMapImpl(Map<K, V> map) {

    super();
    this.map = map;
  }

  @Override
  public boolean isEmpty() {

    return this.map.isEmpty();
  }

  @Override
  public int size() {

    return this.map.size();
  }

  @Override
  public V get(Object key) {

    return this.map.get(key);
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
  public V remove(Object key) {

    V value = this.map.remove(key);
    fireRemove(key, value);
    return value;
  }

  @Override
  public void clear() {

    MapChange<K, V> modification = modRemoveAll();
    this.map.clear();
    fireEvent(modification);
  }

  @Override
  public V put(K key, V value) {

    V old = this.map.put(key, value);
    if (old == null) {
      fireAdd(key);
    } else {
      fireUpdate(key);
    }
    return old;
  }

  @Override
  public Set<Entry<K, V>> entrySet() {

    return new EntrySet();
  }

  private class EntrySet extends AbstractSet<Entry<K, V>> {

    private final Set<Entry<K, V>> entrySet;

    public EntrySet() {

      super();
      this.entrySet = ChangeAwareMapImpl.this.map.entrySet();
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {

      return new EntrySetIterator(this.entrySet.iterator());
    }

    @Override
    public void clear() {

      ChangeAwareMapImpl.this.clear();
    }

    @Override
    public int size() {

      return ChangeAwareMapImpl.this.size();
    }

  }

  private class EntrySetIterator implements Iterator<Entry<K, V>> {

    private final Iterator<Entry<K, V>> itr;

    private Entry<K, V> entry;

    public EntrySetIterator(Iterator<Entry<K, V>> itr) {

      super();
      this.itr = itr;
    }

    @Override
    public boolean hasNext() {

      return this.itr.hasNext();
    }

    @Override
    public Entry<K, V> next() {

      this.entry = this.itr.next();
      return this.entry;
    }

    @Override
    public void remove() {

      this.itr.remove();
      fireRemove(this.entry.getKey(), this.entry.getValue());
    }

  }

}
