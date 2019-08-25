/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import java.util.Objects;

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

  private int changeAwareCount;

  /**
   * The constructor.
   */
  public AbstractObservableValue() {

    super();
  }

  @Override
  public void addListener(ObservableEventListener<V> listener, boolean weak) {

    if (listener instanceof ChangeAwareObservableEventListener) {
      this.changeAwareCount++;
    }
    super.addListener(listener, weak);
  }

  @Override
  public boolean removeListener(ObservableEventListener<V> listener) {

    boolean removed = super.removeListener(listener);
    if (removed && (listener instanceof ChangeAwareObservableEventListener)) {
      this.changeAwareCount--;
    }
    return removed;
  }

  /**
   * @return {@code true} if at least one {@link ChangeAwareObservableEventListener} is
   *         {@link #addListener(net.sf.mmm.event.EventListener) registered}, {@code false} otherwise (to avoid building
   *         and {@link #fireChange(Object) sending} {@link ObservableEvent#getChange() change}s for better
   *         performance).
   */
  protected boolean hasChangeAwareListeners() {

    return (this.changeAwareCount > 0);
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
   * Fires a default value change event if the {@link ObservableEvent#getOldValue() old value} is known (currently
   * available anyhow).
   *
   * @param oldValue the {@link ObservableEvent#getOldValue() old value}. May be {@code null}.
   * @see #fireEvent(ObservableEvent)
   */
  protected void fireEventWithOldValue(V oldValue) {

    if (!hasListeners()) {
      return;
    }
    if (this.observableChangeEvent == null) {
      this.observableChangeEvent = new ObservableEventImpl<>(this);
    }
    ObservableEventImpl<V> event = this.observableChangeEvent.startWithOldValue(oldValue);
    fireEvent(event);
    event.end();
  }

  /**
   * Fires a default {@link ObservableEvent#getChange() value change} event.
   *
   * @param change the {@link ObservableEvent#getChange() change}.
   * @see #fireEvent(ObservableEvent)
   */
  protected void fireChange(Object change) {

    Objects.requireNonNull(change, "change");
    if (!hasListeners()) {
      return;
    }
    if (this.observableChangeEvent == null) {
      this.observableChangeEvent = new ObservableEventImpl<>(this);
    }
    ObservableEventImpl<V> event = this.observableChangeEvent.startWithChange(change);
    fireEvent(event);
    event.end();
  }

  @Override
  protected void fireEvent(ObservableEvent<V> event) {

    super.fireEvent(event);
  }

  /**
   * @param <T> type of the observable value.
   * @param observable the {@link AbstractObservableValue} where to invoke {@link #fireEvent(ObservableEvent)} (if
   *        prevented due to visibility issues).
   * @param event the {@link ObservableEvent} to send.
   */
  protected <T> void fireEventFor(AbstractObservableValue<T> observable, ObservableEvent<T> event) {

    observable.fireEvent(event);
  }

  /**
   * @param observable the {@link AbstractObservableValue} where to invoke {@link #fireEvent()} (if prevented due to
   *        visibility issues).
   */
  protected void fireEventFor(AbstractObservableValue<?> observable) {

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
