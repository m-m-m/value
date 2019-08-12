package net.sf.mmm.value.observable.containers;

import net.sf.mmm.event.ChangeType;

/**
 * Event that signals the change of a container (e.g. {@link java.util.Collection} or {@link java.util.Map}).
 *
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 */
public interface ContainerChangeEvent<E> {

  /**
   * @return the {@link ChangeType} as one of {@link ChangeType#ADD}, {@link ChangeType#UPDATE}, or
   *         {@link ChangeType#REMOVE}.
   */
  ChangeType getType();

  /**
   * @param index the index of the changed {@link java.util.Collection#contains(Object) element} in the range from
   *        {@code 0} to {@link #getCount() count - 1}.
   * @return the element at the given {@code index}. In case of {@link ChangeType#REMOVE} the removed element, in case
   *         of {@link ChangeType#ADD} the inserted element, and in case of {@link ChangeType#UPDATE} the updated
   *         element.
   */
  E getElement(int index);

  /**
   * @return the number of elements that have changed.
   */
  int getCount();

}
