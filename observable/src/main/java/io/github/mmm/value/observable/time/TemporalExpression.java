/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.comparable.ComparableExpression;

/// [ComparableExpression] for [java.time.temporal.Temporal] [values][#get()] (e.g.
/// [java.time.Instant] or [java.time.LocalDateTime]).
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface TemporalExpression<V extends Comparable<? super V>> extends ComparableExpression<V> {

  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] is in the future.
  BooleanBinding inFuture();

  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] is in the past.
  BooleanBinding inPast();

}
