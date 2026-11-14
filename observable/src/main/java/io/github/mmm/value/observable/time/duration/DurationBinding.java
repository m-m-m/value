package io.github.mmm.value.observable.time.duration;

import java.time.Duration;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [io.github.mmm.value.observable.Binding] for an [Duration] [value][#getValue()].
///
/// @since 1.0.0
public class DurationBinding extends Binding<Duration> implements DurationExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#getValue()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public DurationBinding(Supplier<Duration> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
