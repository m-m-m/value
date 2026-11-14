/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.observable.ObservableValue;

/// [ObservableValue] for a simple datatype (and not a
/// [container value][io.github.mmm.value.observable.container.ReadableContainerValue]).
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface ObservableSimpleValue<V> extends ObservableValue<V>, ReadableSimpleValue<V> {

}
