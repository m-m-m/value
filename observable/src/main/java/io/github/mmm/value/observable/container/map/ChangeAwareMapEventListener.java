/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;

import io.github.mmm.value.observable.ChangeAwareObservableEventListener;
import io.github.mmm.value.observable.ObservableEvent;
import io.github.mmm.value.observable.container.set.ObservableSetValue;

/// [Listener][ChangeAwareObservableEventListener] for [ObservableSetValue] and its sub-types. This interface
/// only exists for your convenience to avoid casting or type guessing. You may still directly implement
/// [ChangeAwareObservableEventListener] if you prefer.
///
/// @param <K> type of the [keys][Map#containsKey(Object)].
/// @param <V> type of the [values][Map#containsValue(Object)].
/// @since 1.0.0
public interface ChangeAwareMapEventListener<K, V> extends ChangeAwareObservableEventListener<Map<K, V>> {

  @Override
  default void onEvent(ObservableEvent<Map<K, V>> event) {

    MapChange<K, V> change = event.getChange();
    onChange(change, event);
  }

  /// @param change the [MapChange]. May be `null` if the entire contained changed.
  /// @param event the original [ObservableEvent]. May be ignored if {`change` is not `null`.
  void onChange(MapChange<K, V> change, ObservableEvent<Map<K, V>> event);

}
