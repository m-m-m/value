/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import net.sf.mmm.event.EventSource;
import net.sf.mmm.value.ReadableValue;

/**
 * An {@link ObservableValue} wraps a {@link #getValue() value} and allows to observe the value for changes. In general
 * this interface should not be implemented directly but one of its sub-interfaces.
 * <p>
 * The value of the {@link ObservableValue} can be requested with {@link #getValue()}.
 * <p>
 * An implementation of {@link ObservableValue} may support lazy evaluation, which means that the value is not
 * immediately recomputed after changes, but lazily the next time the value is requested. All bindings and properties in
 * this library support lazy evaluation.
 * <p>
 * An {@link ObservableValue} generates change events. A change event indicates that the value has changed.
 *
 * @param <V> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ObservableValue<V>
    extends ReadableValue<V>, EventSource<ObservableEvent<V>, ObservableEventListener<V>> {

}
