/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.value.observable.ChangeAwareObservableEventListener;
import net.sf.mmm.value.observable.ObservableEvent;
import net.sf.mmm.value.observable.containers.sets.ObservableSetValue;

/**
 * {@link ChangeAwareObservableEventListener Listener} for {@link ObservableSetValue} and its sub-types. This interface
 * only exists for your convenience to avoid casting or type guessing. You may still directly implement
 * {@link ChangeAwareObservableEventListener} if you prefer.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface ChangeAwareMapEventListener<K, V> extends ChangeAwareObservableEventListener<Map<K, V>> {

  @Override
  default void onEvent(ObservableEvent<Map<K, V>> event) {

    MapChange<K, V> change = event.getChange();
    onChange(change, event);
  }

  /**
   * @param change the {@link MapChange}. May be {@code null} if the entire contained changed.
   * @param event the original {@link ObservableEvent}. May be ignored if {{@code change} is not {@code null}.
   */
  void onChange(MapChange<K, V> change, ObservableEvent<Map<K, V>> event);

}
