/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections.impl;

import java.util.Collection;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.collections.CollectionChange;
import net.sf.mmm.value.observable.containers.impl.AbstractContainerChange;

/**
 * Abstract base implementation of {@link CollectionChange}.
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public abstract class AbstractCollectionChange<C extends Collection<E>, E> extends AbstractContainerChange<C, E>
    implements CollectionChange<C, E> {

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param count the {@link #getCount() number of changed elements}.
   */
  public AbstractCollectionChange(ChangeType type, int count) {

    super(type, count);
  }

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param elements the {@link #getElement(int) changed elements}.
   */
  public AbstractCollectionChange(ChangeType type, Object[] elements) {

    super(type, elements);
  }

}
