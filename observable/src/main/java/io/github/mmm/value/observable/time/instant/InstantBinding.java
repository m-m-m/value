package io.github.mmm.value.observable.time.instant;

import java.time.Instant;
import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [io.github.mmm.value.observable.Binding] for an [Instant] [value][#getValue()].
///
/// @since 1.0.0
public class InstantBinding extends Binding<Instant> implements InstantExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#getValue()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public InstantBinding(Supplier<Instant> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
