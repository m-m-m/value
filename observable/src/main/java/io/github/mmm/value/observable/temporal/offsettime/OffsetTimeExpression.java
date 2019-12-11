/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.offsettime;

import java.time.LocalDateTime;
import java.time.OffsetTime;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.temporal.TemporalExpression;

/**
 * {@link TemporalExpression} for {@link LocalDateTime} {@link #getValue() values}.
 *
 * @since 1.0.0
 */
public interface OffsetTimeExpression extends ObservableOffsetTimeValue, TemporalExpression<OffsetTime> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> OffsetTimeHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> OffsetTimeHelper.isInPast(getValue()));
  }

}
