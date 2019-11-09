/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;
import java.util.Set;

import io.github.mmm.value.observable.container.list.ChangeAwareList;
import io.github.mmm.value.observable.container.map.impl.ChangeAwareMapImpl;
import io.github.mmm.value.observable.container.map.impl.EmptyChangeAwareMap;
import io.github.mmm.value.observable.container.map.impl.ImmutableChangeAwareMap;

/**
 * Factory for {@link ChangeAwareMap}.
 *
 * @since 1.0.0
 */
public final class ChangeAwareMaps {

  private ChangeAwareMaps() {

    super();
  }

  /**
   * @param <K> type of the {@link Map#containsKey(Object) keys}.
   * @param <V> type of the {@link Map#containsValue(Object) values}.
   * @return an empty, immutable {@link ChangeAwareMap}.
   */
  public static <K, V> ChangeAwareMap<K, V> empty() {

    return EmptyChangeAwareMap.INSTANCE;
  }

  /**
   * @param <K> type of the {@link Map#containsKey(Object) keys}.
   * @param <V> type of the {@link Map#containsValue(Object) values}.
   * @return a new empty mutable {@link ChangeAwareMap}.
   */
  public static <K, V> ChangeAwareMap<K, V> of() {

    return new ChangeAwareMapImpl<>();
  }

  /**
   * @param <K> type of the {@link Map#containsKey(Object) keys}.
   * @param <V> type of the {@link Map#containsValue(Object) values}.
   * @param capacity the initial capacity of the map.
   * @return a new empty mutable {@link ChangeAwareMap}.
   */
  public static <K, V> ChangeAwareMap<K, V> of(int capacity) {

    return new ChangeAwareMapImpl<>(capacity);
  }

  /**
   * @param <K> type of the {@link Map#containsKey(Object) keys}.
   * @param <V> type of the {@link Map#containsValue(Object) values}.
   * @param map the existing {@link Set} implementation to wrap as {@link ChangeAwareMap}. Please avoid to modify this
   *        {@link Map} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ChangeAwareMap}.
   */
  public static <K, V> ChangeAwareMap<K, V> of(Map<K, V> map) {

    if (map instanceof ChangeAwareMap) {
      return (ChangeAwareMap<K, V>) map;
    }
    return new ChangeAwareMapImpl<>(map);
  }

  /**
   * @param <K> type of the {@link Map#containsKey(Object) keys}.
   * @param <V> type of the {@link Map#containsValue(Object) values}.
   * @param map the existing {@link Map} implementation to wrap as {@link ChangeAwareMap}. Please avoid to modify this
   *        {@link Map} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ChangeAwareList}.
   */
  public static <K, V> ChangeAwareMap<K, V> ofUnmodifiable(Map<K, V> map) {

    if (map instanceof ImmutableChangeAwareMap) {
      return (ChangeAwareMap<K, V>) map;
    }
    return new ImmutableChangeAwareMap<>(map);
  }

}
