/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets.impl;

import java.util.List;
import java.util.Set;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.value.observable.containers.collections.impl.CollectionModificationImpl;
import net.sf.mmm.value.observable.containers.sets.SetModification;

/**
 * Implementation of {@link SetModification}.
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public class SetModificationImpl<E> extends CollectionModificationImpl<Set<E>, E> implements SetModification<E> {

  private final Set<E> container;

  /**
   * The constructor.
   *
   * @param container the {@link List} that changed.
   * @param type the {@link ChangeType}.
   * @param elements the {@link #getElement(int) changed elements}.
   */
  public SetModificationImpl(Set<E> container, ChangeType type, E[] elements) {

    super(type, elements);
    this.container = container;
  }

  @Override
  public Set<E> getContainer() {

    return this.container;
  }

}
