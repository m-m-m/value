/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.observable.ObservableValue;

/// [ObservableValue] for any [Object] [value][#get()] that has no primitive type.
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface ObservableObjectValue<V> extends ObservableValue<V>, ReadableObjectValue<V> {

}
