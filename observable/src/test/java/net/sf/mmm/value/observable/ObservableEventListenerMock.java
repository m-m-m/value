/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 * Mock implementation of {@link ObservableEventListener} for testing.
 *
 * @param <V> type of value.
 */
public class ObservableEventListenerMock<V> implements ObservableEventListener<V> {

  private ObservableEvent<V> event;

  @Override
  public void onEvent(ObservableEvent<V> observableEvent) {

    this.event = observableEvent;
  }

  /**
   * @return the last received {@link ObservableEvent}.
   */
  public ObservableEvent<V> getEvent() {

    return this.event;
  }

}
