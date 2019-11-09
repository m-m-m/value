/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map.impl;

import java.util.AbstractMap;
import java.util.Map;

import io.github.mmm.event.ChangeType;
import io.github.mmm.event.EventSourceAdapter;
import io.github.mmm.value.observable.container.map.ChangeAwareMap;
import io.github.mmm.value.observable.container.map.MapChange;
import io.github.mmm.value.observable.container.map.MapChangeListener;

/**
 * Abstract base implementation of mutable {@link ChangeAwareMap}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public abstract class AbstractChangeAwareMap<K, V> extends AbstractMap<K, V> implements ChangeAwareMap<K, V> {

  private EventSourceAdapter<MapChange<K, V>, MapChangeListener<K, V>> eventAdapter;

  /**
   * The constructor.
   */
  public AbstractChangeAwareMap() {

    super();
    this.eventAdapter = EventSourceAdapter.empty();
  }

  @Override
  public void addListener(MapChangeListener<K, V> listener, boolean weak) {

    this.eventAdapter = this.eventAdapter.addListener(listener, weak);
  }

  @Override
  public boolean removeListener(MapChangeListener<K, V> listener) {

    EventSourceAdapter<MapChange<K, V>, MapChangeListener<K, V>> adapter = this.eventAdapter.removeListener(listener);
    if (adapter == null) {
      return false;
    }
    this.eventAdapter = adapter;
    return true;
  }

  /**
   * @return {@code true} if at least one {@link MapChangeListener} is {@link #addListener(MapChangeListener, boolean)
   *         registered}, {@code false} otherwise.
   */
  protected boolean hasListeners() {

    return this.eventAdapter.hasListeners();
  }

  /**
   * @return {@code true} if modification events should be generated, {@code false} otherwise.
   */
  protected boolean isChangeAware() {

    return hasListeners();
  }

  /**
   * @param modification the {@link MapChange} to {@link MapChangeListener#onEvent(Object) send} to all
   *        {@link #addListener(MapChangeListener, boolean) registered} {@link MapChangeListener}s.
   */
  protected void fireEvent(MapChange<K, V> modification) {

    if (modification == null) {
      return;
    }
    this.eventAdapter.fireEvent(modification);
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#UPDATE update} event.
   *
   * @param keys the keys of the values that have been updated.
   */
  protected void fireUpdate(Object... keys) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, ChangeType.UPDATE, keys));
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#ADD add} event.
   *
   * @param keys the keys of the values that have been inserted.
   */
  protected void fireAdd(Object... keys) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, ChangeType.ADD, keys));
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#REMOVE remove} event.
   *
   * @param keys the keys that have been removed.
   * @param values the values that have been removed in the order corresponding to the {@code keys}.
   */
  protected void fireRemove(Object[] keys, Object[] values) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, keys, values));
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#REMOVE remove} event.
   *
   * @param key the key that has been removed.
   * @param value the value that has been removed.
   */
  protected void fireRemove(Object key, Object value) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, new Object[] { key }, new Object[] { value }));
  }

  /**
   * @return the {@link MapChange} event for the remove of all entries or {@code null} if not {@link #isChangeAware()
   *         observed} or {@link #isEmpty() empty}.
   */
  protected MapChange<K, V> modRemoveAll() {

    if (isChangeAware()) {
      return null;
    }
    int size = size();
    if (size == 0) {
      return null;
    }
    Object[] keys = new Object[size];
    Object[] values = new Object[size];
    int i = 0;
    for (Entry<K, V> entry : entrySet()) {
      keys[i] = entry.getKey();
      values[i] = entry.getValue();
    }
    return new MapChangeImpl<>(this, keys, values);
  }

}
