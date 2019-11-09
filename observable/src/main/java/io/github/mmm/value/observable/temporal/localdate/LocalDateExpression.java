package io.github.mmm.value.observable.temporal.localdate;

import java.time.LocalDate;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.temporal.DateExpression;

/**
 * {@link DateExpression} for {@link LocalDate} {@link #getValue() values}.
 *
 */
public interface LocalDateExpression extends ObservableLocalDateValue, DateExpression<LocalDate> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> LocalDateHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> LocalDateHelper.isInPast(getValue()));
  }

}
