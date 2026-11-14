package io.github.mmm.value.observable.string;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.comparable.ComparableExpression;
import io.github.mmm.value.observable.number.integers.IntegerBinding;

/// [ComparableExpression] with [String] [value][#get()].
///
/// @since 1.0.0
public interface StringExpression extends ObservableStringValue, ComparableExpression<String> {

  /// @return a new [IntegerBinding] that holds the [length][String#length()] of the `String`
  ///         [value][#get()].
  default IntegerBinding expLength() {

    return new IntegerBinding(() -> getSafe().length(), this);
  }

  /// @param other the `Object` to concat.
  /// @return a new `StringExpression` that holds the [value][#get()] of this property concatenated with the
  ///         given [Object].
  default StringExpression expConcat(Object other) {

    if (other instanceof ObservableValue<?>) {
      ObservableValue<?> observable = (ObservableValue<?>) other;
      return new StringBinding(() -> getSafe() + observable.get(), this, observable);
    } else {
      return new StringBinding(() -> getSafe() + other, this);
    }
  }

  /// @param other the [ObservableStringValue] to check for equality.
  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] of this property and the
  ///         [value][ObservableStringValue#get()] of the given [ObservableStringValue] are
  ///         [equal ignoring the case][String#equalsIgnoreCase(String)].
  default BooleanBinding expEqualToIgnoreCase(ObservableStringValue other) {

    return new BooleanBinding(() -> getSafe().equalsIgnoreCase(other.getSafe()), this, other);
  }

  /// @param other the [String] to check for equality.
  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] of this property and the
  ///         given [String] are [equal ignoring the case][String#equalsIgnoreCase(String)].
  default BooleanBinding expEqualToIgnoreCase(String other) {

    return new BooleanBinding(() -> getSafe().equalsIgnoreCase(other), this);
  }

  /// @param other the [ObservableStringValue] to check for non-equality.
  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] of this property and the
  ///         [value][ObservableStringValue#get()] of the given [ObservableStringValue] are NOT
  ///         [equal ignoring the case][String#equalsIgnoreCase(String)].
  default BooleanBinding expNotEqualToIgnoreCase(ObservableStringValue other) {

    return new BooleanBinding(() -> !getSafe().equalsIgnoreCase(other.getSafe()), this, other);
  }

  /// @param other the [String] to check for non-equality.
  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] of this property and the
  ///         given [String] are NOT [equal ignoring the case][String#equalsIgnoreCase(String)].
  default BooleanBinding expNotEqualToIgnoreCase(String other) {

    return new BooleanBinding(() -> !getSafe().equalsIgnoreCase(other), this);
  }

  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] of this property is
  ///         [empty][String#isEmpty()].
  default BooleanBinding expEmpty() {

    return new BooleanBinding(() -> getSafe().isEmpty(), this);
  }

  /// @return a new [BooleanBinding] that holds `true` if the [value][#get()] of this property is NOT
  ///         [empty][String#isEmpty()].
  default BooleanBinding expNotEmpty() {

    return new BooleanBinding(() -> !getSafe().isEmpty(), this);
  }

}
