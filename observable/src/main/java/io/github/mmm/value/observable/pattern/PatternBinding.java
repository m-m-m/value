package io.github.mmm.value.observable.pattern;

import java.util.function.Supplier;
import java.util.regex.Pattern;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [Binding] with [String] [value][#getValue()].
///
/// @since 1.0.0
public class PatternBinding extends Binding<Pattern> implements PatternExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#getValue()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public PatternBinding(Supplier<Pattern> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
