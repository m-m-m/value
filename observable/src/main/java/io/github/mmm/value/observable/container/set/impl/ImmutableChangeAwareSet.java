/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import io.github.mmm.base.collection.ReadOnlyIterator;

/**
 * Immutable implementation of {@link io.github.mmm.value.observable.container.list.ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class ImmutableChangeAwareSet<E> extends ReadOnlyChangeAwareSet<E> {

  private final Set<E> set;

  /**
   * The constructor.
   *
   * @param set the internal {@link Set} to adopt.
   */
  public ImmutableChangeAwareSet(Set<E> set) {

    super();
    this.set = set;
  }

  @Override
  public int size() {

    return this.set.size();
  }

  @Override
  public boolean contains(Object element) {

    return this.set.contains(element);
  }

  @Override
  public boolean containsAll(Collection<?> collection) {

    return this.set.containsAll(collection);
  }

  @Override
  public Iterator<E> iterator() {

    return new ReadOnlyIterator<>(this.set.iterator());
  }

}
