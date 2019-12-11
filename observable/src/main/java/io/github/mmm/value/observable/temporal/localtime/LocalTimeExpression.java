/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localtime;

import java.time.LocalTime;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.temporal.TemporalExpression;

/**
 * {@link TemporalExpression} for {@link LocalTime} {@link #getValue() values}.
 *
 * @since 1.0.0
 */
public interface LocalTimeExpression extends ObservableLocalTimeValue, TemporalExpression<LocalTime> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> LocalTimeHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> LocalTimeHelper.isInPast(getValue()));
  }

}
