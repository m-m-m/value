/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.map.impl;

import java.util.Map;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.container.impl.AbstractContainerChange;
import net.sf.mmm.value.observable.container.list.ListChange;
import net.sf.mmm.value.observable.container.map.MapChange;

/**
 * Implementation of {@link ListChange}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public class MapChangeImpl<K, V> extends AbstractContainerChange<Map<K, V>, V>
    implements MapChange<K, V> {

  private final Map<K, V> container;

  private final Object[] keys;

  /**
   * The constructor.
   *
   * @param container the {@link Map} that changed.
   * @param removedKeys the keys that have been removed from the {@link Map}.
   * @param removedElements the elements that have been removed for the {@link Map}.
   */
  public MapChangeImpl(Map<K, V> container, Object[] removedKeys, Object[] removedElements) {

    super(ChangeType.REMOVE, removedElements);
    this.container = container;
    this.keys = removedKeys;
  }

  /**
   * The constructor.
   *
   * @param container the {@link Map} that changed.
   * @param type the {@link ChangeType}.
   * @param keys the keys that have changed in the {@link Map}.
   */
  public MapChangeImpl(Map<K, V> container, ChangeType type, Object[] keys) {

    super(type, keys.length);
    this.container = container;
    this.keys = keys;
  }

  @Override
  public Map<K, V> getContainer() {

    return this.container;
  }

  @SuppressWarnings("unchecked")
  @Override
  public K getKey(int index) {

    return (K) this.keys[index];
  }

  @Override
  public V getElement(int index) {

    if (this.elements == null) {
      return this.container.get(this.keys[index]);
    }
    return super.getElement(index);
  }

}
