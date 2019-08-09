/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 * Default implementation of {@link ObservableEvent}.
 *
 * @param <V> type of observed {@link ObservableValue#getValue() value}.
 * @since 1.0.0
 */
public class ObservableEventImpl<V> implements ObservableEvent<V> {

  private final ObservableValue<V> observable;

  private V oldValue;

  private V value;

  private boolean valueUpdated;

  private boolean hasOldValue;

  private boolean locked;

  /**
   * The constructor.
   *
   * @param observable the owning {@link ObservableValue}.
   */
  public ObservableEventImpl(ObservableValue<V> observable) {

    super();
    this.observable = observable;
    this.hasOldValue = true; // assuming null is the initial value...
  }

  @Override
  public ObservableValue<V> getObservable() {

    return this.observable;
  }

  @Override
  public V getValue() {

    if (this.value == null) {

    }
    return null;
  }

  @Override
  public V getOldValue() {

    return this.oldValue;
  }

  @Override
  public boolean hasOldValue() {

    return this.hasOldValue;
  }

  @Override
  public final Object getModification() {

    return null;
  }

  /**
   * Called after the last {@link ObservableEventListener} has received this event and before it is sent as a new event
   * to the first {@link ObservableEventListener}.
   *
   * @param theOldValue - see {@link #getOldValue()}.
   */
  ObservableEventImpl<V> start(V theOldValue) {

    this.hasOldValue = true;
    this.valueUpdated = false;
    this.oldValue = theOldValue;

    ObservableEventImpl<V> event = this;
    if (this.locked) {
      event = new ObservableEventImpl<>(this.observable);
    }
    event.locked = true;
    event.hasOldValue = true;
    event.valueUpdated = false;
    event.oldValue = theOldValue;
    return event;

  }

  /**
   * Called after the last {@link ObservableEventListener} has received this event and before it is sent as a new event
   * to the first {@link ObservableEventListener}.
   */
  ObservableEventImpl<V> start() {

    ObservableEventImpl<V> event = this;
    if (this.locked) {
      event = new ObservableEventImpl<>(this.observable);
    }
    event.locked = true;
    event.hasOldValue = this.valueUpdated;
    event.valueUpdated = false;
    if (event.hasOldValue) {
      event.oldValue = this.value;
    } else {
      event.oldValue = null;
    }
    return event;
  }

  void end() {

    this.locked = true;
  }

}
