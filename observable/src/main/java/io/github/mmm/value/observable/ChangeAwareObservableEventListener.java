/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

/// [ObservableEventListener] that is also interested in [change][ObservableEvent#getChange()]s. For performance
/// optimisation [change][ObservableEvent#getChange()] events are only created and sent if at least one
/// [ChangeAwareObservableEventListener] is
/// [registered][ObservableValue#addListener(io.github.mmm.event.EventListener)]. Please note that it is pointless to
/// register a [ChangeAwareObservableEventListener] on an [ObservableValue] if the
/// [value type][io.github.mmm.value.ReadableValue#getValueClass()] is immutable (such as
/// [String], [Boolean], [Number], [java.time.temporal.Temporal], etc.). This only makes sense for types such as
/// [io.github.mmm.value.observable.container.ObservableContainerValue].
///
/// @param <V> type of observed [value][ObservableValue#get()].
/// @since 1.0.0
@FunctionalInterface
public interface ChangeAwareObservableEventListener<V> extends ObservableEventListener<V> {

}
