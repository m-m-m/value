/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.collection;

import java.util.Arrays;
import java.util.Collection;

import io.github.mmm.event.EventListener;
import io.github.mmm.value.observable.container.ChangeAwareContainer;

/**
 * {@link ChangeAwareContainer} that is a {@link Collection}.
 *
 * @param <E> the type of the elements in the container.
 * @param <M> type of the {@link CollectionChange} (event).
 * @param <L> type of the {@link EventListener}.
 * @see io.github.mmm.value.observable.container.list.ChangeAwareList
 * @since 1.0.0
 */
public interface ChangeAwareCollection<E, M extends CollectionChange<?, E>, L extends EventListener<M>>
    extends Collection<E>, ChangeAwareContainer<E, M, L> {

  /**
   * {@link #add(Object) Adds} all the given {@code elements}.
   *
   * @param elements the elements to add.
   * @return {@code true} if this collection has changed (at least one of the given elements has newly been added),
   *         {@code false} otherwise.
   */
  @SuppressWarnings("unchecked")
  default boolean addAll(E... elements) {

    return addAll(Arrays.asList(elements));
  }

  /**
   * {@link #clear() Clears} this collection and {@link #addAll(Object...) adds all} the given {@code elements}.
   *
   * @param elements the elements to add.
   * @return {@code true} if this collection has changed (at least one previous element was removed or one of the given
   *         elements has newly been added), {@code false} otherwise.
   */
  @SuppressWarnings("unchecked")
  default boolean setAll(E... elements) {

    boolean modified = !isEmpty();
    clear();
    boolean added = addAll(elements);
    return (added || modified);
  }

  /**
   * {@link #clear() Clears} this collection and {@link #addAll(Collection) adds all} {@code elements} from the given
   * {@link Collection}.
   *
   * @param collection the {@link Collection} with elements to add.
   * @return {@code true} if this collection has changed (at least one previous element was removed or one of the given
   *         elements has newly been added), {@code false} otherwise.
   */
  default boolean setAll(Collection<? extends E> collection) {

    boolean notEmpty = !isEmpty();
    if (notEmpty) {
      clear();
    }
    boolean added = addAll(collection);
    return (added || notEmpty);
  }

  /**
   * A convenient method for var-arg usage of removaAll method.
   *
   * @param elements the elements to be removed
   * @return {@code true} if this collection has changed (at least one element was removed), {@code false} otherwise.
   */
  @SuppressWarnings("unchecked")
  default boolean removeAll(E... elements) {

    return removeAll(Arrays.asList(elements));
  }

  /**
   * A convenient method for var-arg usage of retain method.
   *
   * @param elements the elements to be retained
   * @return true if list changed as a result of this call
   */
  @SuppressWarnings("unchecked")
  default boolean retainAll(E... elements) {

    return retainAll(Arrays.asList(elements));
  }
}
