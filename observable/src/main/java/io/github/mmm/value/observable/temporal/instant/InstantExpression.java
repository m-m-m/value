package io.github.mmm.value.observable.temporal.instant;

import java.time.Instant;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.temporal.TemporalExpression;

/**
 * {@link TemporalExpression} for {@link Instant} {@link #getValue() values}.
 *
 */
public interface InstantExpression extends ObservableInstantValue, TemporalExpression<Instant> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> InstantHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> InstantHelper.isInPast(getValue()));
  }

}
