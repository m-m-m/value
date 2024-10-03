/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.comparable.ComparableExpression;

/**
 * {@link ComparableExpression} for {@link java.time.temporal.Temporal} {@link #get() values} (e.g.
 * {@link java.time.Instant} or {@link java.time.LocalDateTime}).
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface TemporalExpression<V extends Comparable<? super V>> extends ComparableExpression<V> {

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} is in the future.
   */
  BooleanBinding inFuture();

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} is in the past.
   */
  BooleanBinding inPast();

}
