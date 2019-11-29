/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

/**
 * Event notifying about changes of an {@link ObservableValue}.
 *
 * @param <V> type of observed {@link ObservableValue#get() value}.
 * @since 1.0.0
 * @see ObservableEventListener
 * @see ObservableValue
 */
public interface ObservableEvent<V> {

  /**
   * @return the {@link ObservableValue} that changed and send this event.
   */
  ObservableValue<V> getObservable();

  /**
   * @return the current {@link ObservableValue#get() value}.
   */
  V getValue();

  /**
   * @return the {@link ObservableValue#get() value} before the change. May be {@code null} if the previous value was
   *         {@code null} or {@link #hasOldValue() the old value is not available}.
   */
  V getOldValue();

  /**
   * @return {@code true} if the old value is available, {@code false} otherwise. For advanced performance the old value
   *         is not available for dynamically computed {@link ObservableValue}s by default. It is guaranteed to be
   *         available if at least one of the {@link ObservableValue#addListener(io.github.mmm.event.EventListener)
   *         registered} {@link ObservableEventListener}s has called {@link #getValue()} on the previous
   *         {@link ObservableEvent} forcing an eager evaluation.
   */
  boolean hasOldValue();

  /**
   * @param <M> type of the change.
   * @return the modification in case of a {@link #isChange() value change}, {@code null} otherwise.
   * @see io.github.mmm.value.observable.container.list.ListChange
   * @see io.github.mmm.value.observable.container.map.MapChange
   * @see io.github.mmm.value.observable.container.set.SetChange
   */
  <M> M getChange();

  /**
   * @return {@code true} if the {@link #getValue() value} object instance itself has changed. Most
   *         {@link ObservableValue}s contain immutable value types (such as {@link String}, {@link Boolean},
   *         {@link Integer}, {@link java.math.BigDecimal}, {@link java.time.Instant}, etc.). However, values like e.g.
   *         {@link java.util.Collection} are mutable and may support notifying {@link #getChange() changes}. Otherwise,
   *         if {@code false} the {@link #getObservable() observable} itself was modified and its {@link #getValue()
   *         value} has changed (or was invalidated and needs to be recalculated).
   * @see #getChange()
   */
  default boolean isChange() {

    return (getChange() != null);
  }

}
