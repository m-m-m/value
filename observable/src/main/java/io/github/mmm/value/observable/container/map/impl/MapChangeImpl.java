/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map.impl;

import java.util.Map;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.impl.AbstractContainerChange;
import io.github.mmm.value.observable.container.list.ListChange;
import io.github.mmm.value.observable.container.map.MapChange;

/// Implementation of [ListChange].
///
/// @param <K> type of the [keys][Map#containsKey(Object)].
/// @param <V> type of the [values][Map#containsValue(Object)].
/// @since 1.0.0
public class MapChangeImpl<K, V> extends AbstractContainerChange<Map<K, V>, V>
    implements MapChange<K, V> {

  private final Map<K, V> container;

  private final Object[] keys;

  /// The constructor.
  ///
  /// @param container the [Map] that changed.
  /// @param removedKeys the keys that have been removed from the [Map].
  /// @param removedElements the elements that have been removed for the [Map].
  public MapChangeImpl(Map<K, V> container, Object[] removedKeys, Object[] removedElements) {

    super(ChangeType.REMOVE, removedElements);
    this.container = container;
    this.keys = removedKeys;
  }

  /// The constructor.
  ///
  /// @param container the [Map] that changed.
  /// @param type the [ChangeType].
  /// @param keys the keys that have changed in the [Map].
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
