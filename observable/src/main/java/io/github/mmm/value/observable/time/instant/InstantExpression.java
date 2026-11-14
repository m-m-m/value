package io.github.mmm.value.observable.time.instant;

import java.time.Instant;

import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.time.TemporalExpression;

/// [TemporalExpression] for [Instant] [values][#getValue()].
///
/// @since 1.0.0
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
