/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Immutable implementation of {@link io.github.mmm.value.observable.container.list.ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class ImmutableChangeAwareListView<E> extends ReadOnlyChangeAwareList<E> {

  private final Supplier<List<E>> listSupplier;

  /**
   * The constructor.
   *
   * @param listSupplied the {@link Supplier} of the internal (mutable) {@link List} to adopt.
   */
  public ImmutableChangeAwareListView(Supplier<List<E>> listSupplied) {

    super();
    this.listSupplier = listSupplied;
  }

  @Override
  public E get(int index) {

    return this.listSupplier.get().get(index);
  }

  @Override
  public int size() {

    return this.listSupplier.get().size();
  }

  @Override
  public int indexOf(Object element) {

    return this.listSupplier.get().indexOf(element);
  }

  @Override
  public int lastIndexOf(Object element) {

    return this.listSupplier.get().lastIndexOf(element);
  }

  @Override
  public boolean contains(Object element) {

    return this.listSupplier.get().contains(element);
  }

  @Override
  public boolean containsAll(Collection<?> collection) {

    return this.listSupplier.get().containsAll(collection);
  }

}
