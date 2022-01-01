/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal;

import java.time.temporal.TemporalAmount;

import io.github.mmm.value.observable.object.ReadableSimpleValue;
import io.github.mmm.value.observable.object.ReadableTypedObjectValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link TemporalAmount} {@link #getValue() value}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableTemporalAmountValue<V extends TemporalAmount>
    extends ReadableTypedObjectValue<V>, ReadableSimpleValue<V> {

}
