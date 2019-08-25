/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets.impl;

import java.util.AbstractSet;

import net.sf.mmm.value.observable.containers.sets.ChangeAwareSet;
import net.sf.mmm.value.observable.containers.sets.SetChangeListener;

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

}
