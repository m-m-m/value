/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 * Implementation of {@link ObservableEventListener} that {@link #getEventCount() counts} the
 * {@link #onEvent(ObservableEvent) received} events and allows to {@link #getEvent() get the last received event}.
 * Mainly useful for testing.
 *
 * @param <V> type of the value.
 */
public class ObservableEventReceiver<V> implements ObservableEventListener<V> {

  private ObservableEvent<V> event;

  private int eventCount;

  /**
   * The constructor.
   */
  public ObservableEventReceiver() {

    super();
  }

  @Override
  public void onEvent(ObservableEvent<V> e) {

    this.event = e;
    this.eventCount++;
  }

  /**
   * @return the last {@link ObservableEvent} that has been {@link #onEvent(ObservableEvent) received}. Will be
   *         {@code null} if nothing received yet.
   */
  public ObservableEvent<V> getEvent() {

    return this.event;
  }

  /**
   * @return the number of {@link ObservableEvent}s {@link #onEvent(ObservableEvent) received}.
   */
  public int getEventCount() {

    return this.eventCount;
  }
}