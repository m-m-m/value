/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time;

import java.time.temporal.Temporal;

import io.github.mmm.value.observable.object.ObservableObjectValue;

/// [io.github.mmm.value.observable.ObservableValue] containing a [Temporal] [value][#getValue()].
///
/// @param <V> type of the [value][#getValue()].
/// @since 1.0.0
public interface ObservableTemporalValue<V extends Temporal>
    extends ObservableObjectValue<V>, ReadableTemporalValue<V> {

}
