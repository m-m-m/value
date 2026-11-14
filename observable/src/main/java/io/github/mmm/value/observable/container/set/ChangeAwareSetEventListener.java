/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.Set;

import io.github.mmm.value.observable.ChangeAwareObservableEventListener;
import io.github.mmm.value.observable.ObservableEvent;

/// [Listener][ChangeAwareObservableEventListener] for [ObservableSetValue] and its sub-types. This interface
/// only exists for your convenience to avoid casting or type guessing. You may still directly implement
/// [ChangeAwareObservableEventListener] if you prefer.
///
/// @param <E> type of the [contained elements][Set#contains(Object)].
/// @since 1.0.0
public interface ChangeAwareSetEventListener<E> extends ChangeAwareObservableEventListener<Set<E>> {

  @Override
  default void onEvent(ObservableEvent<Set<E>> event) {

    SetChange<E> change = event.getChange();
    onChange(change, event);
  }

  /// @param change the [SetChange]. May be `null` if the entire contained changed.
  /// @param event the original [ObservableEvent]. May be ignored if {`change` is not `null`.
  void onChange(SetChange<E> change, ObservableEvent<Set<E>> event);

}
