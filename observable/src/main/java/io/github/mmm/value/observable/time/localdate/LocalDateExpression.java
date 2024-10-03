package io.github.mmm.value.observable.time.localdate;

import java.time.LocalDate;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.time.TemporalExpression;

/**
 * {@link TemporalExpression} for {@link LocalDate} {@link #getValue() values}.
 *
 */
public interface LocalDateExpression extends ObservableLocalDateValue, TemporalExpression<LocalDate> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> LocalDateHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> LocalDateHelper.isInPast(getValue()));
  }

}
