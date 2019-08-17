/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps.impl;

import java.util.AbstractMap;

import net.sf.mmm.value.observable.containers.maps.MapChangeListener;
import net.sf.mmm.value.observable.containers.maps.ObservableMap;

/**
 * Abstract base implementation for an immutable {@link ObservableMap}.
 *
 * @param <K> type of the {@link ObservableMap#containsKey(Object) keys}.
 * @param <V> type of the {@link ObservableMap#containsValue(Object) values}.
 * @since 1.0.0
 */
public abstract class ReadOnlyObservableMap<K, V> extends AbstractMap<K, V> implements ObservableMap<K, V> {

  @Override
  public void addListener(MapChangeListener<K, V> listener, boolean weak) {

  }

  @Override
  public boolean removeListener(MapChangeListener<K, V> listener) {

    return false;
  }

}
