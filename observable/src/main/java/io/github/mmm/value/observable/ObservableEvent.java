/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

/// Event notifying about changes of an [ObservableValue].
///
/// @param <V> type of observed [value][ObservableValue#get()].
/// @since 1.0.0
/// @see ObservableEventListener
/// @see ObservableValue
public interface ObservableEvent<V> {

  /// @return the [ObservableValue] that changed and send this event.
  ObservableValue<V> getObservable();

  /// @return the current [value][ObservableValue#get()].
  V getValue();

  /// @return the [value][ObservableValue#get()] before the change. May be `null` if the previous value was
  ///         `null` or [the old value is not available][#hasOldValue()].
  V getOldValue();

  /// @return `true` if the old value is available, `false` otherwise. For advanced performance the old value
  ///         is not available for dynamically computed [ObservableValue]s by default. It is guaranteed to be
  ///         available if at least one of the [registered][ObservableValue#addListener(io.github.mmm.event.EventListener)] [ObservableEventListener]s has called [#getValue()] on the previous
  ///         [ObservableEvent] forcing an eager evaluation.
  boolean hasOldValue();

  /// @param <M> type of the change.
  /// @return the modification in case of a [value change][#isChange()], `null` otherwise.
  /// @see io.github.mmm.value.observable.container.list.ListChange
  /// @see io.github.mmm.value.observable.container.map.MapChange
  /// @see io.github.mmm.value.observable.container.set.SetChange
  <M> M getChange();

  /// @return `true` if the [value][#getValue()] object instance itself has changed. Most
  ///         [ObservableValue]s contain immutable value types (such as [String], [Boolean],
  ///         [Integer], [java.math.BigDecimal], [java.time.Instant], etc.). However, values like e.g.
  ///         [java.util.Collection] are mutable and may support notifying [changes][#getChange()]. Otherwise,
  ///         if `false` the [observable][#getObservable()] itself was modified and its [value][#getValue()] has changed (or was invalidated and needs to be recalculated).
  /// @see #getChange()
  default boolean isChange() {

    return (getChange() != null);
  }

}
