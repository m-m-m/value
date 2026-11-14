/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.map;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import io.github.mmm.value.observable.container.map.impl.ChangeAwareMapImpl;
import io.github.mmm.value.observable.container.map.impl.EmptyChangeAwareMap;
import io.github.mmm.value.observable.container.map.impl.ImmutableChangeAwareMap;
import io.github.mmm.value.observable.container.map.impl.ImmutableChangeAwareMapView;

/// Factory for [ChangeAwareMap].
///
/// @since 1.0.0
public final class ChangeAwareMaps {

  private ChangeAwareMaps() {

    super();
  }

  /// @param <K> type of the [keys][Map#containsKey(Object)].
  /// @param <V> type of the [values][Map#containsValue(Object)].
  /// @return an empty, immutable [ChangeAwareMap].
  public static <K, V> ChangeAwareMap<K, V> empty() {

    return EmptyChangeAwareMap.INSTANCE;
  }

  /// @param <K> type of the [keys][Map#containsKey(Object)].
  /// @param <V> type of the [values][Map#containsValue(Object)].
  /// @return a new empty mutable [ChangeAwareMap].
  public static <K, V> ChangeAwareMap<K, V> of() {

    return new ChangeAwareMapImpl<>();
  }

  /// @param <K> type of the [keys][Map#containsKey(Object)].
  /// @param <V> type of the [values][Map#containsValue(Object)].
  /// @param capacity the initial capacity of the map.
  /// @return a new empty mutable [ChangeAwareMap].
  public static <K, V> ChangeAwareMap<K, V> of(int capacity) {

    return new ChangeAwareMapImpl<>(capacity);
  }

  /// @param <K> type of the [keys][Map#containsKey(Object)].
  /// @param <V> type of the [values][Map#containsValue(Object)].
  /// @param map the existing [Set] implementation to wrap as [ChangeAwareMap]. Please avoid to modify this
  ///        [Map] afterwards, as this will not trigger modification events.
  /// @return a new empty mutable [ChangeAwareMap].
  public static <K, V> ChangeAwareMap<K, V> of(Map<K, V> map) {

    if (map instanceof ChangeAwareMap) {
      return (ChangeAwareMap<K, V>) map;
    }
    return new ChangeAwareMapImpl<>(map);
  }

  /// @param <K> type of the [keys][Map#containsKey(Object)].
  /// @param <V> type of the [values][Map#containsValue(Object)].
  /// @param map the existing [Map] implementation to wrap as [ChangeAwareMap]. Modifying such [Map]
  ///        afterwards will not trigger modification events in the read-only view returned by this method.
  /// @return a unmodifiable [ChangeAwareMap] that acts as a view on the given [Map].
  public static <K, V> ChangeAwareMap<K, V> ofUnmodifiable(Map<K, V> map) {

    if (map instanceof ImmutableChangeAwareMap) {
      return (ChangeAwareMap<K, V>) map;
    }
    return new ImmutableChangeAwareMap<>(map);
  }

  /// @param <K> type of the [keys][Map#containsKey(Object)].
  /// @param <V> type of the [values][Map#containsValue(Object)].
  /// @param mapSupplier the [Supplier] to the (mutable) [Map] implementation to wrap as
  ///        [ChangeAwareMap]. Modifying such [Map] afterwards will not trigger modification events in the
  ///        read-only view returned by this method.
  /// @return a unmodifiable [ChangeAwareMap] that acts as a view on the [supplied][Supplier#get()]
  ///         [Map].
  public static <K, V> ChangeAwareMap<K, V> ofUnmodifiable(Supplier<Map<K, V>> mapSupplier) {

    return new ImmutableChangeAwareMapView<>(mapSupplier);
  }

}
