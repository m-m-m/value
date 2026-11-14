/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.ContainerChange;

/// [ContainerChange] for [Map]s.
///
/// @param <K> type of the [keys][Map#containsKey(Object)].
/// @param <V> type of the [values][Map#containsValue(Object)].
/// @since 1.0.0
/// @see io.github.mmm.value.observable.ObservableEvent#getChange()
public interface MapChange<K, V> extends ContainerChange<Map<K, V>, V> {

  /// @param index the index of the changed [key][java.util.Map#containsKey(Object)] in the range from `0` to
  ///        [count - 1][#getCount()].
  /// @return the key at the given `index`. In case of [ChangeType#REMOVE] the removed key, in case of
  ///         [ChangeType#ADD] the inserted key, and in case of [ChangeType#UPDATE] the key of the updated
  ///         element.
  K getKey(int index);

}
