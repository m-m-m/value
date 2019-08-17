/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.lists.impl.EmptyObservableList;
import net.sf.mmm.value.observable.containers.lists.impl.ImmutableObservableList;
import net.sf.mmm.value.observable.containers.lists.impl.ObservableListImpl;

/**
 * Factory for {@link ObservableList}.
 *
 * @since 1.0.0
 */
public final class ObservableLists {

  private ObservableLists() {

    super();
  }

  /**
   * @param <E> the type of the elements.
   * @return an empty, immutable {@link ObservableList}.
   */
  public static <E> ObservableList<E> empty() {

    return EmptyObservableList.INSTANCE;
  }

  /**
   * @param <E> the type of the elements.
   * @return a new empty mutable {@link ObservableList}.
   */
  public static <E> ObservableList<E> of() {

    return new ObservableListImpl<>();
  }

  /**
   * @param <E> the type of the elements.
   * @param list the existing {@link List} implementation to wrap as {@link ObservableList}. Please avoid to modify this
   *        {@link List} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ObservableList}.
   */
  public static <E> ObservableList<E> of(List<E> list) {

    if (list instanceof ObservableList) {
      return (ObservableList<E>) list;
    }
    return new ObservableListImpl<>(list);
  }

  /**
   * @param <E> the type of the elements.
   * @param list the existing {@link List} implementation to wrap as {@link ObservableList}. Please avoid to modify this
   *        {@link List} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ObservableList}.
   */
  public static <E> ObservableList<E> ofUnmodifiable(List<E> list) {

    if (list instanceof ImmutableObservableList) {
      return (ObservableList<E>) list;
    }
    return new ImmutableObservableList<>(list);
  }

}
