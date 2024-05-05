/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list;

import java.util.List;
import java.util.function.Supplier;

import io.github.mmm.value.observable.container.list.impl.ChangeAwareListImpl;
import io.github.mmm.value.observable.container.list.impl.EmptyChangeAwareList;
import io.github.mmm.value.observable.container.list.impl.ImmutableChangeAwareList;
import io.github.mmm.value.observable.container.list.impl.ImmutableChangeAwareListView;

/**
 * Factory for {@link ChangeAwareList}.
 *
 * @since 1.0.0
 */
public final class ChangeAwareLists {

  private ChangeAwareLists() {

    super();
  }

  /**
   * @param <E> the type of the elements.
   * @return an empty, immutable {@link ChangeAwareList}.
   */
  public static <E> ChangeAwareList<E> empty() {

    return EmptyChangeAwareList.INSTANCE;
  }

  /**
   * @param <E> the type of the elements.
   * @return a new empty mutable {@link ChangeAwareList}.
   */
  public static <E> ChangeAwareList<E> of() {

    return new ChangeAwareListImpl<>();
  }

  /**
   * @param <E> the type of the elements.
   * @param capacity the initial capacity of the list.
   * @return a new empty mutable {@link ChangeAwareList}.
   */
  public static <E> ChangeAwareList<E> of(int capacity) {

    return new ChangeAwareListImpl<>(capacity);
  }

  /**
   * @param <E> the type of the elements.
   * @param list the existing {@link List} implementation to wrap as {@link ChangeAwareList}. Please avoid to modify
   *        this {@link List} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ChangeAwareList}.
   */
  public static <E> ChangeAwareList<E> of(List<E> list) {

    if (list instanceof ChangeAwareList) {
      return (ChangeAwareList<E>) list;
    }
    return new ChangeAwareListImpl<>(list);
  }

  /**
   * @param <E> the type of the elements.
   * @param list the existing {@link List} implementation to wrap as {@link ChangeAwareList}. Modifying such
   *        {@link List} afterwards will not trigger modification events in the read-only view returned by this method.
   * @return a unmodifiable {@link ChangeAwareList} that acts as a view on the given {@link List}.
   */
  public static <E> ChangeAwareList<E> ofUnmodifiable(List<E> list) {

    if (list instanceof ImmutableChangeAwareList<E> result) {
      return result;
    }
    return new ImmutableChangeAwareList<>(list);
  }

  /**
   * @param <E> the type of the elements.
   * @param listSupplier the {@link Supplier} to the (mutable) {@link List} implementation to wrap as
   *        {@link ChangeAwareList}. Modifying such {@link List} afterwards will not trigger modification events in the
   *        read-only view returned by this method.
   * @return a unmodifiable {@link ChangeAwareList} that acts as a view on the {@link Supplier#get() supplied}
   *         {@link List}.
   */
  public static <E> ChangeAwareList<E> ofUnmodifiable(Supplier<List<E>> listSupplier) {

    return new ImmutableChangeAwareListView<>(listSupplier);
  }

}
