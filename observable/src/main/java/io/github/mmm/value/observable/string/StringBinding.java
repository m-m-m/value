package io.github.mmm.value.observable.string;

import java.util.function.Supplier;

import io.github.mmm.value.observable.Binding;
import io.github.mmm.value.observable.ObservableValue;

/// [Binding] with [String] [value][#getValue()].
///
/// @since 1.0.0
public class StringBinding extends Binding<String> implements StringExpression {

  /// The constructor.
  ///
  /// @param expression the [Supplier] to compute the [value][#getValue()].
  /// @param dependencies the [ObservableValue]s the `expression` depends on.
  public StringBinding(Supplier<String> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

}
