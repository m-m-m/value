/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.impl;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.ContainerChangeEvent;

/**
 * Abstract base implementation of {@link ContainerChangeEvent}.
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public abstract class ContainerChangeEventImpl<C, E> implements ContainerChangeEvent<C, E> {

  /** @see #getType() */
  protected final ChangeType type;

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   */
  public ContainerChangeEventImpl(ChangeType type) {

    super();
    this.type = type;
  }

  @Override
  public ChangeType getType() {

    return this.type;
  }

  @Override
  public String toString() {

    return getClass().getSimpleName() + ":" + this.type + "(#" + getCount() + ")";
  }

}
