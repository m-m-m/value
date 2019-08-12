/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import net.sf.mmm.event.AbstractEventSource;

/**
 * Abstract base implementation of {@link ObservableValue} that handles {@link ObservableEventListener}s.
 *
 * @param <V> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AbstractObservableValue<V>
    extends AbstractEventSource<ObservableEvent<V>, ObservableEventListener<V>> implements ObservableValue<V> {

  private ObservableEventImpl<V> observableChangeEvent;

  /**
   * The constructor.
   */
  public AbstractObservableValue() {

    super();
  }

  /**
   * Fires a default value change event.
   *
   * @see #fireEvent(ObservableEvent)
   */
  protected void fireEvent() {

    if (!hasListeners()) {
      return;
    }
    if (this.observableChangeEvent == null) {
      this.observableChangeEvent = new ObservableEventImpl<>(this);
    }
    ObservableEventImpl<V> event = this.observableChangeEvent.start();
    fireEvent(event);
    event.end();
  }

  /**
   * Fires a default value change event.
   *
   * @param oldValue the {@link ObservableEvent#getOldValue() old value}.
   * @see #fireEvent(ObservableEvent)
   */
  protected void fireEventOldValue(V oldValue) {

    if (!hasListeners()) {
      return;
    }
    if (this.observableChangeEvent == null) {
      this.observableChangeEvent = new ObservableEventImpl<>(this);
    }
    ObservableEventImpl<V> event = this.observableChangeEvent.start(oldValue);
    fireEvent(event);
    event.end();
  }

  @Override
  protected void fireEvent(ObservableEvent<V> event) {

    super.fireEvent(event);
  }

  /**
   * @param observable the {@link AbstractObservableValue} where to invoke {@link #fireEvent(ObservableEvent)} (if
   *        prevented due to visibility issues).
   * @param event the {@link ObservableEvent} to send.
   */
  protected void fireEvent(AbstractObservableValue<V> observable, ObservableEvent<V> event) {

    observable.fireEvent(event);
  }

  /**
   * @param observable the {@link AbstractObservableValue} where to invoke {@link #fireEvent()} (if prevented due to
   *        visibility issues).
   */
  protected void fireEvent(AbstractObservableValue<V> observable) {

    observable.fireEvent();
  }

  /**
   * Invalidates this observable in case it's value is computed.
   */
  protected void invalidate() {

    fireEvent();
  }

  @Override
  public final String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append('[');
    toString(sb);
    sb.append(']');
    return sb.toString();
  }

  /**
   * @param sb the {@link StringBuilder} where to append the details of this property for
   *        {@link #toString()}-Representation.
   */
  protected void toString(StringBuilder sb) {

    sb.append("value=");
    sb.append(getValue());
  }

}
