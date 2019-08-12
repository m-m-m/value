/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.ContainerModification;

/**
 * {@link ContainerModification} for {@link Map}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getModification()
 */
public interface MapModification<K, E> extends ContainerModification<Map<K, E>, E> {

  /**
   * @param index the index of the changed {@link java.util.Map#containsKey(Object) key} in the range from {@code 0} to
   *        {@link #getCount() count - 1}.
   * @return the key at the given {@code index}. In case of {@link ChangeType#REMOVE} the removed key, in case of
   *         {@link ChangeType#ADD} the inserted key, and in case of {@link ChangeType#UPDATE} the key of the updated
   *         element.
   */
  K getKey(int index);

}
