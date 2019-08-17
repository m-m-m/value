/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists.impl;

import java.util.AbstractList;

import net.sf.mmm.value.observable.containers.lists.ListChangeListener;
import net.sf.mmm.value.observable.containers.lists.ObservableList;

/**
 * Abstract base implementation for an immutable {@link net.sf.mmm.value.observable.containers.lists.ObservableList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public abstract class ReadOnlyObservableList<E> extends AbstractList<E> implements ObservableList<E> {

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

}
