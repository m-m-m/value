/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

/**
 * {@link ObservableEventListener} that is also interested in {@link ObservableEvent#getChange() change}s. For
 * performance optimization {@link ObservableEvent#getChange() change} events are only created and sent if at least one
 * {@link ChangeAwareObservableEventListener} is {@link ObservableValue#addListener(io.github.mmm.event.EventListener)
 * registered}.<br>
 * Please note that it is pointless to register a {@link ChangeAwareObservableEventListener} on an
 * {@link ObservableValue} if the {@link io.github.mmm.value.ReadableTypedValue#getValueClass() value type} is immutable
 * (such as {@link String}, {@link Boolean}, {@link Number}, {@link java.time.temporal.Temporal}, etc.). This only makes
 * sense for types such as {@link io.github.mmm.value.observable.container.ObservableContainerValue}.
 *
 * @param <V> type of observed {@link ObservableValue#getValue() value}.
 * @since 1.0.0
 */
@FunctionalInterface
public interface ChangeAwareObservableEventListener<V> extends ObservableEventListener<V> {

}
