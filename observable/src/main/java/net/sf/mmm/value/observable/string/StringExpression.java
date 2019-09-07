package net.sf.mmm.value.observable.string;

import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.booleans.BooleanBinding;
import net.sf.mmm.value.observable.comparable.ComparableExpression;
import net.sf.mmm.value.observable.number.integers.IntegerBinding;

/**
 * {@link ComparableExpression} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface StringExpression extends ObservableStringValue, ComparableExpression<String> {

  /**
   * @return a new {@link IntegerBinding} that holds the {@link String#length() length} of the {@code String}
   *         {@link #getValue() value}.
   */
  default IntegerBinding length() {

    return new IntegerBinding(() -> getValueSafe().length(), this);
  }

  /**
   * @param other the {@code Object} to concat.
   * @return a new {@code StringExpression} that holds the {@link #getValue() value} of this property concatenated with
   *         the given {@link Object}.
   */
  default StringExpression concat(Object other) {

    if (other instanceof ObservableValue<?>) {
      ObservableValue<?> observable = (ObservableValue<?>) other;
      return new StringBinding(() -> getValueSafe() + observable.getValue(), this, observable);
    } else {
      return new StringBinding(() -> getValueSafe() + other, this);
    }
  }

  /**
   * @param other the {@link ObservableStringValue} to check for equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property and
   *         the {@link ObservableStringValue#getValue() value} of the given {@link ObservableStringValue} are
   *         {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isEqualToIgnoreCase(ObservableStringValue other) {

    return new BooleanBinding(() -> getValueSafe().equalsIgnoreCase(other.getValueSafe()), this, other);
  }

  /**
   * @param other the {@link String} to check for equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property and
   *         the given {@link String} are {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isEqualToIgnoreCase(String other) {

    return new BooleanBinding(() -> getValueSafe().equalsIgnoreCase(other), this);
  }

  /**
   * @param other the {@link ObservableStringValue} to check for non-equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property and
   *         the {@link ObservableStringValue#getValue() value} of the given {@link ObservableStringValue} are NOT
   *         {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isNotEqualToIgnoreCase(ObservableStringValue other) {

    return new BooleanBinding(() -> !getValueSafe().equalsIgnoreCase(other.getValueSafe()), this, other);
  }

  /**
   * @param other the {@link String} to check for non-equality.
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property and
   *         the given {@link String} are NOT {@link String#equalsIgnoreCase(String) equal ignoring the case}.
   */
  default BooleanBinding isNotEqualToIgnoreCase(String other) {

    return new BooleanBinding(() -> !getValueSafe().equalsIgnoreCase(other), this);
  }

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         {@link String#isEmpty() empty}.
   */
  default BooleanBinding isEmpty() {

    return new BooleanBinding(() -> getValueSafe().isEmpty(), this);
  }

  /**
   * @return a new {@link BooleanBinding} that holds {@code true} if the {@link #getValue() value} of this property is
   *         NOT {@link String#isEmpty() empty}.
   */
  default BooleanBinding isNotEmpty() {

    return new BooleanBinding(() -> !getValueSafe().isEmpty(), this);
  }

}
