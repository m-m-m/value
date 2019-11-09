/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set.impl;

import java.util.List;
import java.util.Set;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.collection.impl.AbstractCollectionChange;
import io.github.mmm.value.observable.container.set.SetChange;

/**
 * Implementation of {@link SetChange}.
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public class SetChangeImpl<E> extends AbstractCollectionChange<Set<E>, E> implements SetChange<E> {

  private final Set<E> container;

  /**
   * The constructor.
   *
   * @param container the {@link List} that changed.
   * @param type the {@link ChangeType}.
   * @param elements the {@link #getElement(int) changed elements}.
   */
  public SetChangeImpl(Set<E> container, ChangeType type, Object[] elements) {

    super(type, elements);
    this.container = container;
  }

  @Override
  public Set<E> getContainer() {

    return this.container;
  }

}
