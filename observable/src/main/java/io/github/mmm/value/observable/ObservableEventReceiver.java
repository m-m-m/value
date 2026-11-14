/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

/// Implementation of [ObservableEventListener] that [counts][#getEventCount()] the
/// [received][#onEvent(ObservableEvent)] events and allows to [get the last received event][#getEvent()].
/// Mainly useful for testing.
///
/// @param <V> type of the value.
public class ObservableEventReceiver<V> implements ObservableEventListener<V> {

  private ObservableEvent<V> event;

  private int eventCount;

  /// The constructor.
  public ObservableEventReceiver() {

    super();
  }

  @Override
  public void onEvent(ObservableEvent<V> e) {

    this.event = e;
    this.eventCount++;
  }

  /// @return the last [ObservableEvent] that has been [received][#onEvent(ObservableEvent)]. Will be
  ///         `null` if nothing received yet.
  public ObservableEvent<V> getEvent() {

    return this.event;
  }

  /// @return the number of [ObservableEvent]s [received][#onEvent(ObservableEvent)].
  public int getEventCount() {

    return this.eventCount;
  }
}