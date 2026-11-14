/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time;

import io.github.mmm.value.observable.comparable.ComparableExpression;

/// [ComparableExpression] for [java.time.temporal.TemporalAmount] [values][#get()] (e.g.
/// [java.time.Duration]).
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface TemporalAmountExpression<V extends Comparable<? super V>> extends ComparableExpression<V> {

}
