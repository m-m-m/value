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

  private Object change;

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
    this.oldValue = observable.getValue();
    this.hasOldValue = true;
  }

  @Override
  public ObservableValue<V> getObservable() {

    return this.observable;
  }

  @Override
  public V getValue() {

    if (!this.valueUpdated) {
      this.value = this.observable.getValue();
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

  /**
   * Needs to be called before this event is sent as a new event to the first {@link ObservableEventListener}.
   *
   * @param theOldValue the {@link #getOldValue() old value}.
   */
  ObservableEventImpl<V> startWithOldValue(V theOldValue) {

    return start(theOldValue, true, null);
  }

  /**
   * Needs to be called before this event is sent as a new event to the first {@link ObservableEventListener}.
   */
  ObservableEventImpl<V> start() {

    return start(null, false, null);
  }

  /**
   * Needs to be called before this event is sent as a new event to the first {@link ObservableEventListener}.
   *
   * @param valueChange the {@link #getChange() change}.
   */
  ObservableEventImpl<V> startWithChange(Object valueChange) {

    return start(null, false, valueChange);
  }

  /**
   * Needs to be called before this event is sent as a new event to the first {@link ObservableEventListener}.
   *
   * @param theOldValue the {@link #getOldValue() old value}.
   * @param withOldValue - {@code true} if {@link #getOldValue() old value} is provided and known (even if it is
   *        {@code null}), {@code false} otherwise.
   * @param valueChange the {@link #getChange() change}.
   */
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

  void end() {

    this.locked = true;
  }

}
