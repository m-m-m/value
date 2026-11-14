/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.collection.impl;

import java.util.Collection;

import io.github.mmm.event.ChangeType;
import io.github.mmm.value.observable.container.collection.CollectionChange;
import io.github.mmm.value.observable.container.impl.AbstractContainerChange;

/// Abstract base implementation of [CollectionChange].
///
/// @param <C> type of the [container][#getContainer()].
/// @param <E> type of the [elements][#getElement(int)].
/// @since 1.0.0
public abstract class AbstractCollectionChange<C extends Collection<E>, E> extends AbstractContainerChange<C, E>
    implements CollectionChange<C, E> {

  /// The constructor.
  ///
  /// @param type the [ChangeType].
  /// @param count the [number of changed elements][#getCount()].
  public AbstractCollectionChange(ChangeType type, int count) {

    super(type, count);
  }

  /// The constructor.
  ///
  /// @param type the [ChangeType].
  /// @param elements the [changed elements][#getElement(int)].
  public AbstractCollectionChange(ChangeType type, Object[] elements) {

    super(type, elements);
  }

}
