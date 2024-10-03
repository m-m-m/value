/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.offsetdatetime;

import java.time.OffsetDateTime;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.time.TemporalExpression;

/**
 * {@link TemporalExpression} for {@link OffsetDateTime} {@link #getValue() values}.
 *
 * @since 1.0.0
 */
public interface OffsetDateTimeExpression extends ObservableOffsetDateTimeValue, TemporalExpression<OffsetDateTime> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> OffsetDateTimeHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> OffsetDateTimeHelper.isInPast(getValue()));
  }

}
