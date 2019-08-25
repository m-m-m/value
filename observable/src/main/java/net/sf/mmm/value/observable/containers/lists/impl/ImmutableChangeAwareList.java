/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists.impl;

import java.util.Collection;
import java.util.List;

/**
 * Immutable implementation of {@link net.sf.mmm.value.observable.containers.lists.ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class ImmutableChangeAwareList<E> extends ReadOnlyChangeAwareList<E> {

  private final List<E> list;

  /**
   * The constructor.
   *
   * @param list the internal {@link List} to adopt.
   */
  public ImmutableChangeAwareList(List<E> list) {

    super();
    this.list = list;
  }

  @Override
  public E get(int index) {

    return this.list.get(index);
  }

  @Override
  public int size() {

    return this.list.size();
  }

  @Override
  public int indexOf(Object element) {

    return this.list.indexOf(element);
  }

  @Override
  public int lastIndexOf(Object element) {

    return this.list.lastIndexOf(element);
  }

  @Override
  public boolean contains(Object element) {

    return this.list.contains(element);
  }

  @Override
  public boolean containsAll(Collection<?> collection) {

    return this.list.containsAll(collection);
  }

}
