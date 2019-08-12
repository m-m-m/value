/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections.impl;

import java.util.Collection;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.collections.CollectionChangeEvent;
import net.sf.mmm.value.observable.containers.impl.ContainerChangeEventImpl;

/**
 * Abstract base implementation of {@link CollectionChangeEvent}.
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public abstract class CollectionChangeEventImpl<C extends Collection<E>, E> extends ContainerChangeEventImpl<C, E>
    implements CollectionChangeEvent<C, E> {

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param count the {@link #getCount() number of changed elements}.
   */
  public CollectionChangeEventImpl(ChangeType type, int count) {

    super(type, count);
  }

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param elements the {@link #getElement(int) changed elements}.
   */
  public CollectionChangeEventImpl(ChangeType type, E[] elements) {

    super(type, elements);
  }

}
