package net.sf.mmm.value.observable.containers;

import net.sf.mmm.event.ChangeType;

/**
 * {@link net.sf.mmm.value.observable.ObservableEvent#getChange() Change} that signals the modification of a container
 * (e.g. {@link java.util.Collection} or {@link java.util.Map}).
 *
 * @param <C> type of the {@link #getContainer() container}.
 * @param <E> type of the {@link #getElement(int) elements}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getChange()
 */
public interface ContainerChange<C, E> {

  /**
   * @return the container that changed.
   */
  C getContainer();

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
