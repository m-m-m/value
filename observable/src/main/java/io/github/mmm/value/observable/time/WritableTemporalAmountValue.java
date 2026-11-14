/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time;

import java.time.temporal.TemporalAmount;

import io.github.mmm.value.observable.object.WritableSimpleObjectValue;

/// [io.github.mmm.value.WritableValue] containing a [TemporalAmount] [value][#getValue()].
///
/// @param <V> type of the [value][#getValue()].
/// @since 1.0.0
public interface WritableTemporalAmountValue<V extends TemporalAmount>
    extends ReadableTemporalAmountValue<V>, WritableSimpleObjectValue<V> {

}
