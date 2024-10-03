/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time;

import io.github.mmm.value.observable.comparable.ComparableExpression;

/**
 * {@link ComparableExpression} for {@link java.time.temporal.TemporalAmount} {@link #get() values} (e.g.
 * {@link java.time.Duration}).
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface TemporalAmountExpression<V extends Comparable<? super V>> extends ComparableExpression<V> {

}
