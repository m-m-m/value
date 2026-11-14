/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.impl;

import io.github.mmm.value.observable.ObservableEvent;
import io.github.mmm.value.observable.ObservableEventListener;
import io.github.mmm.value.observable.ObservableValue;

/// Default implementation of [ObservableEvent].
///
/// @param <V> type of observed [value][ObservableValue#get()].
/// @since 1.0.0
public class ObservableEventImpl<V> implements ObservableEvent<V> {

  private final ObservableValue<V> observable;

  private Object change;

  private V oldValue;

  private V value;

  private boolean valueUpdated;

  private boolean hasOldValue;

  private boolean locked;

  /// The constructor.
  ///
  /// @param observable the owning [ObservableValue].
  public ObservableEventImpl(ObservableValue<V> observable) {

    super();
    this.observable = observable;
    this.oldValue = observable.get();
    this.hasOldValue = true;
  }

  @Override
  public ObservableValue<V> getObservable() {

    return this.observable;
  }

  @Override
  public V getValue() {

    if (!this.valueUpdated) {
      this.value = this.observable.get();
      this.valueUpdated = true;
    }
    return this.value;
  }

  @Override
  public V getOldValue() {

    return this.oldValue;
  }

  @Override
  public boolean hasOldValue() {

    return this.hasOldValue;
  }

  @SuppressWarnings("unchecked")
  @Override
  public final <M> M getChange() {

    return (M) this.change;
  }

  /// Needs to be called before this event is sent as a new event to the first [ObservableEventListener].
  ///
  /// @param theOldValue the [old value][#getOldValue()].
  /// @return this event itself or a new instance if locked.
  public ObservableEventImpl<V> startWithOldValue(V theOldValue) {

    return start(theOldValue, true, null);
  }

  /// Needs to be called before this event is sent as a new event to the first [ObservableEventListener].
  ///
  /// @return this event itself or a new instance if locked.
  public ObservableEventImpl<V> start() {

    return start(null, false, null);
  }

  /// Needs to be called before this event is sent as a new event to the first [ObservableEventListener].
  ///
  /// @param valueChange the [change][#getChange()].
  /// @return this event itself or a new instance if locked.
  public ObservableEventImpl<V> startWithChange(Object valueChange) {

    return start(null, false, valueChange);
  }

  /// Needs to be called before this event is sent as a new event to the first [ObservableEventListener].
  ///
  /// @param theOldValue the [old value][#getOldValue()].
  /// @param withOldValue - `true` if [old value][#getOldValue()] is provided and known (even if it is
  ///        `null`), `false` otherwise.
  /// @param valueChange the [change][#getChange()].
  private ObservableEventImpl<V> start(V theOldValue, boolean withOldValue, Object valueChange) {

    ObservableEventImpl<V> event = this;
    if (this.locked) {
      event = new ObservableEventImpl<>(this.observable);
    }
    event.locked = true;
    if (withOldValue) {
      event.hasOldValue = true;
      event.oldValue = theOldValue;
    } else {
      event.hasOldValue = this.valueUpdated;
      if (event.hasOldValue) {
        event.oldValue = this.value;
      } else {
        event.oldValue = null;
      }
    }
    event.change = valueChange;
    if (valueChange == null) {
      event.valueUpdated = false;
    }
    return event;
  }

  /// Ends the event.
  public void end() {

    this.locked = true;
  }

}
