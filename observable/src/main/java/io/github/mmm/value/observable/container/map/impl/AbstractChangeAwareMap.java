/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map.impl;

import java.util.AbstractMap;
import java.util.Map;

import io.github.mmm.event.ChangeType;
import io.github.mmm.event.EventListener;
import io.github.mmm.event.EventSourceAdapter;
import io.github.mmm.value.observable.container.map.ChangeAwareMap;
import io.github.mmm.value.observable.container.map.MapChange;
import io.github.mmm.value.observable.container.map.MapChangeListener;

/// Abstract base implementation of mutable [ChangeAwareMap].
///
/// @param <K> type of the [keys][Map#containsKey(Object)].
/// @param <V> type of the [values][Map#containsValue(Object)].
/// @since 1.0.0
public abstract class AbstractChangeAwareMap<K, V> extends AbstractMap<K, V> implements ChangeAwareMap<K, V> {

  private EventSourceAdapter<MapChange<K, V>, EventListener<MapChange<K, V>>> eventAdapter;

  /// The constructor.
  public AbstractChangeAwareMap() {

    super();
    this.eventAdapter = EventSourceAdapter.empty();
  }

  @Override
  public void addListener(MapChangeListener<K, V> listener, boolean weak) {

    EventListener<MapChange<K, V>> l = listener;
    if (weak) {
      l = l.weak(this);
    }
    this.eventAdapter = this.eventAdapter.addListener(l);
  }

  @Override
  public boolean removeListener(MapChangeListener<K, V> listener) {

    var adapter = this.eventAdapter.removeListener(listener);
    if (adapter == null) {
      return false;
    }
    this.eventAdapter = adapter;
    return true;
  }

  /// @return `true` if at least one [MapChangeListener] is [registered][#addListener(MapChangeListener, boolean)], `false` otherwise.
  protected boolean hasListeners() {

    return this.eventAdapter.hasListeners();
  }

  /// @return `true` if modification events should be generated, `false` otherwise.
  protected boolean isChangeAware() {

    return hasListeners();
  }

  /// @param modification the [MapChange] to [send][MapChangeListener#onEvent(Object)] to all
  ///        [registered][#addListener(MapChangeListener, boolean)] [MapChangeListener]s.
  protected void fireEvent(MapChange<K, V> modification) {

    if (modification == null) {
      return;
    }
    this.eventAdapter.fireEvent(modification);
  }

  /// [Fires][#fireEvent(MapChange)] an [update][ChangeType#UPDATE] event.
  ///
  /// @param keys the keys of the values that have been updated.
  protected void fireUpdate(Object... keys) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, ChangeType.UPDATE, keys));
  }

  /// [Fires][#fireEvent(MapChange)] an [add][ChangeType#ADD] event.
  ///
  /// @param keys the keys of the values that have been inserted.
  protected void fireAdd(Object... keys) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, ChangeType.ADD, keys));
  }

  /// [Fires][#fireEvent(MapChange)] an [remove][ChangeType#REMOVE] event.
  ///
  /// @param keys the keys that have been removed.
  /// @param values the values that have been removed in the order corresponding to the `keys`.
  protected void fireRemove(Object[] keys, Object[] values) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, keys, values));
  }

  /// [Fires][#fireEvent(MapChange)] an [remove][ChangeType#REMOVE] event.
  ///
  /// @param key the key that has been removed.
  /// @param value the value that has been removed.
  protected void fireRemove(Object key, Object value) {

    if (!isChangeAware()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, new Object[] { key }, new Object[] { value }));
  }

  /// @return the [MapChange] event for the remove of all entries or `null` if not [observed][#isChangeAware()] or [empty][#isEmpty()].
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
