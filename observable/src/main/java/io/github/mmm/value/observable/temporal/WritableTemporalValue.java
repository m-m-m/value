/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal;

import java.time.temporal.Temporal;

import io.github.mmm.value.observable.object.WritableObjectValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link io.github.mmm.value.WritableValue} containing a {@link Temporal} {@link #getValue() value}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface WritableTemporalValue<V extends Temporal>
    extends ReadableTemporalValue<V>, WritableObjectValue<V>, WritableSimpleValue<V> {

}
