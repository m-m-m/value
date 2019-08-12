/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;
import java.util.Set;

import net.sf.mmm.value.observable.containers.ReadableContainerValue;
import net.sf.mmm.value.observable.containers.collections.ReadableCollectionValue;

/**
 * {@link ReadableCollectionValue} for {@link Set} {@link #getValue() value}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <E> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface WritableMapValue<K, E> extends ReadableContainerValue<Map<K, E>, E> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  default Class<Map<K, E>> getValueClass() {

    return (Class) Map.class;
  }

}
