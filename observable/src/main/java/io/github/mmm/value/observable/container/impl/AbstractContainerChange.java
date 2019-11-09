/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.impl;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.ContainerChange;

/**
 * Abstract base implementation of {@link ContainerChange}.
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public abstract class AbstractContainerChange<C, E> implements ContainerChange<C, E> {

  /** @see #getType() */
  protected final ChangeType type;

  /** @see #getElement(int) */
  protected final Object[] elements;

  /** @see #getCount() */
  protected final int count;

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param count the {@link #getCount() number of changed elements}.
   */
  public AbstractContainerChange(ChangeType type, int count) {

    super();
    this.type = type;
    this.elements = null;
    this.count = this.elements.length;
  }

  /**
   * The constructor.
   *
   * @param type the {@link ChangeType}.
   * @param elements the {@link #getElement(int) changed elements}.
   */
  public AbstractContainerChange(ChangeType type, Object[] elements) {

    super();
    this.type = type;
    this.elements = elements;
    this.count = elements.length;
  }

  @Override
  public ChangeType getType() {

    return this.type;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E getElement(int index) {

    return (E) this.elements[index];
  }

  @Override
  public int getCount() {

    return this.count;
  }

  @Override
  public String toString() {

    return getClass().getSimpleName() + ":" + this.type + "(#" + getCount() + ")";
  }

}
