/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.lists.impl.ChangeAwareListImpl;
import net.sf.mmm.value.observable.containers.lists.impl.EmptyChangeAwareList;
import net.sf.mmm.value.observable.containers.lists.impl.ImmutableChangeAwareList;

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
   * @param list the existing {@link List} implementation to wrap as {@link ChangeAwareList}. Please avoid to modify
   *        this {@link List} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ChangeAwareList}.
   */
  public static <E> ChangeAwareList<E> ofUnmodifiable(List<E> list) {

    if (list instanceof ImmutableChangeAwareList) {
      return (ChangeAwareList<E>) list;
    }
    return new ImmutableChangeAwareList<>(list);
  }

}
