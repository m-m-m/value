/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.temporal.DateExpression;

/**
 * {@link DateExpression} for {@link LocalDate} {@link #getValue() values}.
 * 
 * @since 1.0.0
 */
public interface LocalDateTimeExpression extends ObservableLocalDateTimeValue, DateExpression<LocalDateTime> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> LocalDateTimeHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> LocalDateTimeHelper.isInPast(getValue()));
  }

}
