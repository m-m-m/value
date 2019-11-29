package io.github.mmm.value.observable.string;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.booleans.BooleanBinding;
import io.github.mmm.value.observable.comparable.ComparableExpression;
import io.github.mmm.value.observable.number.integers.IntegerBinding;

/**
 * {@link ComparableExpression} with {@link String} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface StringExpression extends ObservableStringValue, ComparableExpression<String> {

  /**
   * @return a new {@link IntegerBinding} that holds the {@link String#length() length} of the {@code String}
   *         {@link #get() value}.
   */
  default IntegerBinding length() {

    return new IntegerBinding(() -> getSafe().length(), this);
  }

  /**
   * @param other the {@code Object} to concat.
   * @return a new {@code StringExpression} that holds the {@link #get() value} of this property concatenated with the
   *         given {@link Object}.
   */
  default StringExpression concat(Object other) {

    if (other instanceof ObservableValue<?>) {
      ObservableValue<?> observable = (ObservableValue<?>) other;
      return new StringBinding(() -> getSafe() + observable.get(), this, observable);
    } else {
      return new StringBinding(() -> getSafe() + other, this);
    }
  }

  /**
   * @param other the {@link ObservableStringValue} to check for equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property and the
   *         {@link ObservableStringValue#get() value} of the given {@link ObservableStringValue} are
   *         {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isEqualToIgnoreCase(ObservableStringValue other) {

    return new BooleanBinding(() -> getSafe().equalsIgnoreCase(other.getSafe()), this, other);
  }

  /**
   * @param other the {@link String} to check for equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property and the
   *         given {@link String} are {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isEqualToIgnoreCase(String other) {

    return new BooleanBinding(() -> getSafe().equalsIgnoreCase(other), this);
  }

  /**
   * @param other the {@link ObservableStringValue} to check for non-equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property and the
   *         {@link ObservableStringValue#get() value} of the given {@link ObservableStringValue} are NOT
   *         {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isNotEqualToIgnoreCase(ObservableStringValue other) {

    return new BooleanBinding(() -> !getSafe().equalsIgnoreCase(other.getSafe()), this, other);
  }

  /**
   * @param other the {@link String} to check for non-equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property and the
   *         given {@link String} are NOT {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isNotEqualToIgnoreCase(String other) {

    return new BooleanBinding(() -> !getSafe().equalsIgnoreCase(other), this);
  }

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is
   *         {@link String#isEmpty() empty}.
   */
  default BooleanBinding isEmpty() {

    return new BooleanBinding(() -> getSafe().isEmpty(), this);
  }

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #get() value} of this property is NOT
   *         {@link String#isEmpty() empty}.
   */
  default BooleanBinding isNotEmpty() {

    return new BooleanBinding(() -> !getSafe().isEmpty(), this);
  }

}
