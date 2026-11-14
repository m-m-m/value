/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.List;
import java.util.function.Supplier;

import io.github.mmm.value.observable.container.list.impl.ChangeAwareListImpl;
import io.github.mmm.value.observable.container.list.impl.EmptyChangeAwareList;
import io.github.mmm.value.observable.container.list.impl.ImmutableChangeAwareList;
import io.github.mmm.value.observable.container.list.impl.ImmutableChangeAwareListView;

/// Factory for [ChangeAwareList].
///
/// @since 1.0.0
public final class ChangeAwareLists {

  private ChangeAwareLists() {

    super();
  }

  /// @param <E> the type of the elements.
  /// @return an empty, immutable [ChangeAwareList].
  public static <E> ChangeAwareList<E> empty() {

    return EmptyChangeAwareList.INSTANCE;
  }

  /// @param <E> the type of the elements.
  /// @return a new empty mutable [ChangeAwareList].
  public static <E> ChangeAwareList<E> of() {

    return new ChangeAwareListImpl<>();
  }

  /// @param <E> the type of the elements.
  /// @param capacity the initial capacity of the list.
  /// @return a new empty mutable [ChangeAwareList].
  public static <E> ChangeAwareList<E> of(int capacity) {

    return new ChangeAwareListImpl<>(capacity);
  }

  /// @param <E> the type of the elements.
  /// @param list the existing [List] implementation to wrap as [ChangeAwareList]. Please avoid to modify
  ///        this [List] afterwards, as this will not trigger modification events.
  /// @return a new empty mutable [ChangeAwareList].
  public static <E> ChangeAwareList<E> of(List<E> list) {

    if (list instanceof ChangeAwareList) {
      return (ChangeAwareList<E>) list;
    }
    return new ChangeAwareListImpl<>(list);
  }

  /// @param <E> the type of the elements.
  /// @param list the existing [List] implementation to wrap as [ChangeAwareList]. Modifying such
  ///        [List] afterwards will not trigger modification events in the read-only view returned by this method.
  /// @return a unmodifiable [ChangeAwareList] that acts as a view on the given [List].
  public static <E> ChangeAwareList<E> ofUnmodifiable(List<E> list) {

    if (list instanceof ImmutableChangeAwareList<E> result) {
      return result;
    }
    return new ImmutableChangeAwareList<>(list);
  }

  /// @param <E> the type of the elements.
  /// @param listSupplier the [Supplier] to the (mutable) [List] implementation to wrap as
  ///        [ChangeAwareList]. Modifying such [List] afterwards will not trigger modification events in the
  ///        read-only view returned by this method.
  /// @return a unmodifiable [ChangeAwareList] that acts as a view on the [supplied][Supplier#get()]
  ///         [List].
  public static <E> ChangeAwareList<E> ofUnmodifiable(Supplier<List<E>> listSupplier) {

    return new ImmutableChangeAwareListView<>(listSupplier);
  }

}
