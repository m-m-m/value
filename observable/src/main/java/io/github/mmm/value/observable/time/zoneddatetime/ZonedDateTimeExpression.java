/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.zoneddatetime;

import java.time.ZonedDateTime;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.time.TemporalExpression;

/**
 * {@link TemporalExpression} for {@link ZonedDateTime} {@link #getValue() values}.
 *
 * @since 1.0.0
 */
public interface ZonedDateTimeExpression extends ObservableZonedDateTimeValue, TemporalExpression<ZonedDateTime> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> ZonedDateTimeHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> ZonedDateTimeHelper.isInPast(getValue()));
  }

}
