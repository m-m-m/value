/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link ObservableValue} for a simple datatype (and not a
 * {@link io.github.mmm.value.observable.container.ReadableContainerValue container value}).
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface ObservableSimpleValue<V> extends ObservableValue<V>, ReadableSimpleValue<V> {

}
