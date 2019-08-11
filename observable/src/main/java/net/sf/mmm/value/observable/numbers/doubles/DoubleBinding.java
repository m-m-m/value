package net.sf.mmm.value.observable.numbers.doubles;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link NumberBinding} with {@link Double} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class DoubleBinding extends NumberBinding<Double> implements DoubleExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public DoubleBinding(Supplier<Double> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link DoubleExpression} to negate.
   * @return a new {@link DoubleExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link DoubleExpression}.
   * @see #negate()
   */
  public static DoubleExpression negate(DoubleExpression expression) {

    return new DoubleBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link DoubleExpression}.
   */
  public static DoubleExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof DoubleExpression) {
      return (DoubleExpression) expression;
    } else {
      return new DoubleBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link DoubleExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #add(ObservableDoubleValue)
   */
  public static DoubleExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new DoubleBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link DoubleExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #add(ObservableDoubleValue)
   */
  public static DoubleExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.doubleValue());
  }

  /**
   * @param expression the {@link DoubleExpression} to add.
   * @param constant the constant {@code double} to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #add(ObservableDoubleValue)
   */
  public static DoubleExpression add(NumberExpression<?> expression, double constant) {

    return new DoubleBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static DoubleExpression addAll(ObservableValue<? extends Number>... observables) {

    return new DoubleBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #subtract(ObservableDoubleValue)
   */
  public static DoubleExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new DoubleBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #subtract(ObservableDoubleValue)
   */
  public static DoubleExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.doubleValue());
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@code double} to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #subtract(ObservableDoubleValue)
   */
  public static DoubleExpression subtract(NumberExpression<?> expression, double constant) {

    return new DoubleBinding(() -> minus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static DoubleExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new DoubleBinding(() -> minusAll(observables), observables);
  }

  private static Double to(Number value) {

    if (value == null) {
      return null;
    } else if (value instanceof Double) {
      return (Double) value;
    } else {
      return Double.valueOf(value.doubleValue());
    }
  }

  private static Double negate(Double value) {

    if (value == null) {
      return null;
    }
    return Double.valueOf(-value.doubleValue());
  }

  @SafeVarargs
  private static Double plusAll(ReadableValue<? extends Number>... observables) {

    double sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = sum + value.doubleValue();
        }
      }
    }
    return Double.valueOf(sum);
  }

  private static Double plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Double plus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Double.valueOf(v1.doubleValue() + v2.doubleValue());
  }

  private static Double plus(double v1, Number v2) {

    if (v2 != null) {
      return v1 = v1 + v2.doubleValue();
    }
    return Double.valueOf(v1);
  }

  @SafeVarargs
  private static Double minusAll(ReadableValue<? extends Number>... observables) {

    double difference = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          difference = difference - value.doubleValue();
        }
      }
    }
    return Double.valueOf(difference);
  }

  private static Double minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Double minus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Double.valueOf(v1.doubleValue() - v2.doubleValue());
  }

  private static Double minus(double v1, Number v2) {

    if (v2 != null) {
      return v1 = v1 - v2.doubleValue();
    }
    return Double.valueOf(v1);
  }
}
