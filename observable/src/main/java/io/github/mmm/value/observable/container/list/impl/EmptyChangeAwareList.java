/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import io.github.mmm.value.observable.container.list.ChangeAwareList;

/**
 * Empty singleton implementation of {@link io.github.mmm.value.observable.container.list.ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class EmptyChangeAwareList<E> extends ReadOnlyChangeAwareList<E> {

  /** The singleton instance. */
  @SuppressWarnings("rawtypes")
  public static final ChangeAwareList INSTANCE = new EmptyChangeAwareList<>();

  @Override
  public E get(int index) {

    throw new IndexOutOfBoundsException("Index: " + index);
  }

  @Override
  public int size() {

    return 0;
  }

  @Override
  public boolean isEmpty() {

    return true;
  }

  @Override
  public boolean contains(Object element) {

    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {

    if ((c == null) || (c.isEmpty())) {
      return true;
    }
    return false;
  }

  @Override
  public Iterator<E> iterator() {

    return Collections.emptyIterator();
  }

  @Override
  public ListIterator<E> listIterator() {

    return Collections.emptyListIterator();
  }

  @Override
  public boolean equals(Object o) {

    return (o instanceof List) && ((List<?>) o).isEmpty();
  }

  @Override
  public int hashCode() {

    return 1;
  }

  @Override
  public boolean removeIf(Predicate<? super E> filter) {

    Objects.requireNonNull(filter);
    return false;
  }

  @Override
  public void replaceAll(UnaryOperator<E> operator) {

    Objects.requireNonNull(operator);
  }

  @Override
  public void sort(Comparator<? super E> c) {

    // nothing to sort
  }

  @Override
  public void forEach(Consumer<? super E> action) {

    Objects.requireNonNull(action);
  }

  @Override
  public Spliterator<E> spliterator() {

    return Spliterators.emptySpliterator();
  }

  @Override
  public Object[] toArray() {

    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {

    if (a.length > 0) {
      a[0] = null;
    }
    return a;
  }

}
