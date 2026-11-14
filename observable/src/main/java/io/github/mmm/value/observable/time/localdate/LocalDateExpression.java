package io.github.mmm.value.observable.time.localdate;

import java.time.LocalDate;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.time.TemporalExpression;

/// [TemporalExpression] for [LocalDate] [values][#getValue()].
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
