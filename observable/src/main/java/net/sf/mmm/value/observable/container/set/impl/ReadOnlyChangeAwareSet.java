/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.set.impl;

import java.util.AbstractSet;
import java.util.Collection;

import net.sf.mmm.value.observable.container.set.ChangeAwareSet;
import net.sf.mmm.value.observable.container.set.SetChangeListener;

/**
 * Abstract base implementation for an immutable {@link ChangeAwareSet}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public abstract class ReadOnlyChangeAwareSet<E> extends AbstractSet<E> implements ChangeAwareSet<E> {

  @Override
  public void addListener(SetChangeListener<E> listener, boolean weak) {

  }

  @Override
  public boolean removeListener(SetChangeListener<E> listener) {

    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> collection) {

    if (collection == null) {
      return false;
    }
    return super.addAll(collection);
  }

}
