package net.sf.mmm.value.observable.numbers.integers;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link NumberBinding} with {@link Integer} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class IntegerBinding extends NumberBinding<Integer> implements IntegerExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public IntegerBinding(Supplier<Integer> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link IntegerExpression} to negate.
   * @return a new {@link IntegerExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link IntegerExpression}.
   * @see #negate()
   */
  public static IntegerExpression negate(IntegerExpression expression) {

    return new IntegerBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link IntegerExpression}.
   */
  public static IntegerExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof IntegerExpression) {
      return (IntegerExpression) expression;
    } else {
      return new IntegerBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link IntegerExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #add(ObservableIntegerValue)
   */
  public static IntegerExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new IntegerBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link IntegerExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #add(ObservableIntegerValue)
   */
  public static IntegerExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.intValue());
  }

  /**
   * @param expression the {@link IntegerExpression} to add.
   * @param constant the constant {@code int} to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #add(ObservableIntegerValue)
   */
  public static IntegerExpression add(NumberExpression<?> expression, int constant) {

    return new IntegerBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link IntegerExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static IntegerExpression addAll(ObservableValue<? extends Number>... observables) {

    return new IntegerBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #subtract(ObservableIntegerValue)
   */
  public static IntegerExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new IntegerBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #subtract(ObservableIntegerValue)
   */
  public static IntegerExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.intValue());
  }

  /**
   * @param expression the {@link IntegerExpression}.
   * @param constant the constant {@code int} to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link IntegerExpression} with the given {@code constant}.
   * @see #subtract(ObservableIntegerValue)
   */
  public static IntegerExpression subtract(NumberExpression<?> expression, int constant) {

    return new IntegerBinding(() -> minus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link IntegerExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static IntegerExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new IntegerBinding(() -> minusAll(observables), observables);
  }

  private static Integer to(Number value) {

    if (value == null) {
      return null;
    } else if (value instanceof Integer) {
      return (Integer) value;
    } else {
      return Integer.valueOf(value.intValue());
    }
  }

  private static Integer negate(Integer value) {

    if (value == null) {
      return null;
    }
    return Integer.valueOf(-value.intValue());
  }

  @SafeVarargs
  private static Integer plusAll(ReadableValue<? extends Number>... observables) {

    int sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = sum + value.intValue();
        }
      }
    }
    return Integer.valueOf(sum);
  }

  private static Integer plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Integer plus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Integer.valueOf(v1.intValue() + v2.intValue());
  }

  private static Integer plus(int v1, Number v2) {

    if (v2 != null) {
      v1 = v1 + v2.intValue();
    }
    return Integer.valueOf(v1);
  }

  @SafeVarargs
  private static Integer minusAll(ReadableValue<? extends Number>... observables) {

    int difference = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          difference = difference - value.intValue();
        }
      }
    }
    return Integer.valueOf(difference);
  }

  private static Integer minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Integer minus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Integer.valueOf(v1.intValue() - v2.intValue());
  }

  private static Integer minus(int v1, Number v2) {

    if (v2 != null) {
      v1 = v1 - v2.intValue();
    }
    return Integer.valueOf(v1);
  }

}
