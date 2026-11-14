/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

import java.util.Objects;

import io.github.mmm.event.AbstractEventSender;
import io.github.mmm.event.EventListener;
import io.github.mmm.value.observable.impl.ObservableEventImpl;

/// Abstract base implementation of [ObservableValue] that handles [ObservableEventListener]s.
///
/// @param <V> type of the observable [value][#get()].
/// @since 1.0.0
public abstract class AbstractObservableValue<V>
    extends AbstractEventSender<ObservableEvent<V>, ObservableEventListener<? super V>> implements ObservableValue<V> {

  private ObservableEventImpl<V> observableChangeEvent;

  private int changeAwareCount;

  /// The constructor.
  public AbstractObservableValue() {

    super();
  }

  @Override
  protected void doAddListener(EventListener<ObservableEvent<V>> listener) {

    if (listener instanceof ChangeAwareObservableEventListener) {
      this.changeAwareCount++;
    }
    super.doAddListener(listener);
  }

  @Override
  public boolean removeListener(ObservableEventListener<? super V> listener) {

    boolean removed = super.removeListener(listener);
    if (removed && (listener instanceof ChangeAwareObservableEventListener)) {
      this.changeAwareCount--;
    }
    return removed;
  }

  /// @return `true` if at least one [ChangeAwareObservableEventListener] is
  ///         [registered][#addListener(io.github.mmm.event.EventListener)], `false` otherwise (to avoid
  ///         building and [sending][#fireChange(Object)] [change][ObservableEvent#getChange()]s for better
  ///         performance).
  protected boolean hasChangeAwareListeners() {

    return (this.changeAwareCount > 0);
  }

  /// Fires a default value change event.
  ///
  /// @see #fireEvent(ObservableEvent)
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

  /// Fires a default value change event if the [old value][ObservableEvent#getOldValue()] is known (currently
  /// available anyhow).
  ///
  /// @param oldValue the [old value][ObservableEvent#getOldValue()]. May be `null`.
  /// @see #fireEvent(ObservableEvent)
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

  /// Fires a default [value change][ObservableEvent#getChange()] event.
  ///
  /// @param change the [changed value][ObservableEvent#getChange()].
  /// @see #fireEvent(ObservableEvent)
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
  protected boolean fireEvent(ObservableEvent<V> event) {

    return super.fireEvent(event);
  }

  /// @param <T> type of the observable value.
  /// @param observable the [AbstractObservableValue] where to invoke [#fireEvent(ObservableEvent)] (if
  ///        prevented due to visibility issues).
  /// @param event the [ObservableEvent] to send.
  protected <T> void fireEventFor(AbstractObservableValue<T> observable, ObservableEvent<T> event) {

    observable.fireEvent(event);
  }

  /// @param observable the [AbstractObservableValue] where to invoke [#fireEvent()] (if prevented due to
  ///        visibility issues).
  protected void fireEventFor(AbstractObservableValue<?> observable) {

    observable.fireEvent();
  }

  /// Invalidates this observable in case it's value is computed.
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

  /// @param sb the [StringBuilder] where to append the details of this property for
  ///        [#toString()]-Representation.
  @Override
  public void toString(StringBuilder sb) {

    sb.append("value=");
    sb.append(get());
  }

}
