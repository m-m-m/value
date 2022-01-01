package io.github.mmm.value.observable.temporal.duration;

import java.time.Duration;

import io.github.mmm.value.observable.temporal.TemporalAmountExpression;

/**
 * {@link TemporalAmountExpression} for {@link Duration} {@link #getValue() values}.
 *
 * @since 1.0.0
 */
public interface DurationExpression extends ObservableDurationValue, TemporalAmountExpression<Duration> {

}
