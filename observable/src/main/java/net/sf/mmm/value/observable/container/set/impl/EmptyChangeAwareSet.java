/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.set.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;

import net.sf.mmm.value.observable.container.set.ChangeAwareSet;

/**
 * Empty singleton implementation of {@link net.sf.mmm.value.observable.container.set.ChangeAwareSets}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class EmptyChangeAwareSet<E> extends ReadOnlyChangeAwareSet<E> {

  /** The singleton instance. */
  @SuppressWarnings("rawtypes")
  public static final ChangeAwareSet INSTANCE = new EmptyChangeAwareSet<>();

  @Override
  public int size() {

    return 0;
  }

  @Override
  public boolean isEmpty() {

    return true;
  }

  @Override
  public void clear() {

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
