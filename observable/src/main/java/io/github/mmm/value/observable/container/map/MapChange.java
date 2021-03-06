/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.ContainerChange;

/**
 * {@link ContainerChange} for {@link Map}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 * @see io.github.mmm.value.observable.ObservableEvent#getChange()
 */
public interface MapChange<K, V> extends ContainerChange<Map<K, V>, V> {

  /**
   * @param index the index of the changed {@link java.util.Map#containsKey(Object) key} in the range from {@code 0} to
   *        {@link #getCount() count - 1}.
   * @return the key at the given {@code index}. In case of {@link ChangeType#REMOVE} the removed key, in case of
   *         {@link ChangeType#ADD} the inserted key, and in case of {@link ChangeType#UPDATE} the key of the updated
   *         element.
   */
  K getKey(int index);

}
