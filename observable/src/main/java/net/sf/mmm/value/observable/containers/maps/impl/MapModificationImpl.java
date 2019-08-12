/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps.impl;

import java.util.Map;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.impl.ContainerModificationImpl;
import net.sf.mmm.value.observable.containers.lists.ListModification;
import net.sf.mmm.value.observable.containers.maps.MapModification;

/**
 * Implementation of {@link ListModification}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public class MapModificationImpl<K, E> extends ContainerModificationImpl<Map<K, E>, E> implements MapModification<K, E> {

  private final Map<K, E> container;

  private final K[] keys;

  /**
   * The constructor.
   *
   * @param container the {@link Map} that changed.
   * @param removedKeys the keys that have been removed from the {@link Map}.
   * @param removedElements the elements that have been removed for the {@link Map}.
   */
  public MapModificationImpl(Map<K, E> container, K[] removedKeys, E[] removedElements) {

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
  public MapModificationImpl(Map<K, E> container, ChangeType type, K[] keys) {

    super(type, keys.length);
    this.container = container;
    this.keys = keys;
  }

  @Override
  public Map<K, E> getContainer() {

    return this.container;
  }

  @Override
  public K getKey(int index) {

    return this.keys[index];
  }

  @Override
  public E getElement(int index) {

    if (this.elements == null) {
      return this.container.get(this.keys[index]);
    }
    return super.getElement(index);
  }

}
