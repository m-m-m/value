/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.list.impl;

import java.util.AbstractList;
import java.util.Collection;

import io.github.mmm.value.observable.container.list.ChangeAwareList;
import io.github.mmm.value.observable.container.list.ListChangeListener;

/**
 * Abstract base implementation for an immutable {@link ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public abstract class ReadOnlyChangeAwareList<E> extends AbstractList<E> implements ChangeAwareList<E> {

  @Override
  public void addListener(ListChangeListener<E> listener, boolean weak) {

  }

  @Override
  public boolean removeListener(ListChangeListener<E> listener) {

    return false;
  }

  @Override
  public void remove(int from, int to) {

    removeRange(from, to);
  }

  @Override
  public boolean addAll(Collection<? extends E> collection) {

    if (collection == null) {
      return false;
    }
    return super.addAll(collection);
  }

}
