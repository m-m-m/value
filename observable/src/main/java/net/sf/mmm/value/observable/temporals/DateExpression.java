/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals;

import java.time.Instant;
import java.time.LocalDateTime;

import net.sf.mmm.value.observable.booleans.BooleanBinding;
import net.sf.mmm.value.observable.comparables.ComparableExpression;

/**
 * {@link ComparableExpression} for date {@link #getValue() values} (e.g. {@link Instant} or {@link LocalDateTime}).
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface DateExpression<V extends Comparable<? super V>> extends ComparableExpression<V> {

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} is in the future.
   */
  BooleanBinding inFuture();

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} is in the past.
   */
  BooleanBinding inPast();

}
