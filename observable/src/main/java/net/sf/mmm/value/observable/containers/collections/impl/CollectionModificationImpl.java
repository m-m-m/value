/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections.impl;

import java.util.Collection;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.collections.CollectionModification;
import net.sf.mmm.value.observable.containers.impl.ContainerModificationImpl;

/**
 * Abstract base implementation of {@link CollectionModification}.
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public abstract class CollectionModificationImpl<C extends Collection<E>, E> extends ContainerModificationImpl<C, E>
    implements CollectionModification<C, E> {

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param count the {@link #getCount() number of changed elements}.
   */
  public CollectionModificationImpl(ChangeType type, int count) {

    super(type, count);
  }

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param elements the {@link #getElement(int) changed elements}.
   */
  public CollectionModificationImpl(ChangeType type, E[] elements) {

    super(type, elements);
  }

}
