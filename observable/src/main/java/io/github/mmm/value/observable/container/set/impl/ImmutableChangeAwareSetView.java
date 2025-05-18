/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Supplier;

import io.github.mmm.base.collection.ReadOnlyIterator;

/**
 * Immutable implementation of {@link io.github.mmm.value.observable.container.list.ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class ImmutableChangeAwareSetView<E> extends ReadOnlyChangeAwareSet<E> {

  private final Supplier<Set<E>> setSupplier;

  /**
   * The constructor.
   *
   * @param setSupplier the internal {@link Set} to adopt.
   */
  public ImmutableChangeAwareSetView(Supplier<Set<E>> setSupplier) {

    super();
    this.setSupplier = setSupplier;
  }

  @Override
  public int size() {

    return this.setSupplier.get().size();
  }

  @Override
  public boolean contains(Object element) {

    return this.setSupplier.get().contains(element);
  }

  @Override
  public boolean containsAll(Collection<?> collection) {

    return this.setSupplier.get().containsAll(collection);
  }

  @Override
  public Iterator<E> iterator() {

    return new ReadOnlyIterator<>(this.setSupplier.get().iterator());
  }

}
