package io.github.mmm.value.observable.container;

import io.github.mmm.event.ChangeType;

/// [Change][io.github.mmm.value.observable.ObservableEvent#getChange()] that signals the modification of a container
/// (e.g. [java.util.Collection] or [java.util.Map]).
///
/// @param <C> type of the [container][#getContainer()].
/// @param <E> type of the [elements][#getElement(int)].
/// @since 1.0.0
/// @see io.github.mmm.value.observable.ObservableEvent#getChange()
public interface ContainerChange<C, E> {

  /// @return the container that changed.
  C getContainer();

  /// @return the [ChangeType] as one of [ChangeType#ADD], [ChangeType#UPDATE], or
  ///         [ChangeType#REMOVE].
  ChangeType getType();

  /// @param index the index of the changed [element][java.util.Collection#contains(Object)] in the range from
  ///        `0` to [count - 1][#getCount()].
  /// @return the element at the given `index`. In case of [ChangeType#REMOVE] the removed element, in case
  ///         of [ChangeType#ADD] the inserted element, and in case of [ChangeType#UPDATE] the updated
  ///         element.
  E getElement(int index);

  /// @return the number of elements that have changed.
  int getCount();

}
