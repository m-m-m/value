package net.sf.mmm.value.observable.numbers.shorts;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link NumberBinding} with {@link Short} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class ShortBinding extends NumberBinding<Short> implements ShortExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public ShortBinding(Supplier<Short> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link ShortExpression} to negate.
   * @return a new {@link ShortExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link ShortExpression}.
   * @see #negate()
   */
  public static ShortExpression negate(ShortExpression expression) {

    return new ShortBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link ShortExpression}.
   */
  public static ShortExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof ShortExpression) {
      return (ShortExpression) expression;
    } else {
      return new ShortBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link ShortExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #add(ObservableShortValue)
   */
  public static ShortExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new ShortBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link ShortExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link ShortExpression} with the given {@code constant}.
   * @see #add(ObservableShortValue)
   */
  public static ShortExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.shortValue());
  }

  /**
   * @param expression the {@link ShortExpression} to add.
   * @param constant the constant {@code short} to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link ShortExpression} with the given {@code constant}.
   * @see #add(ObservableShortValue)
   */
  public static ShortExpression add(NumberExpression<?> expression, short constant) {

    return new ShortBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link ShortExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static ShortExpression sum(ObservableValue<? extends Number>... observables) {

    return new ShortBinding(() -> plusAll(observables), observables);
  }

  private static Short to(Number value) {

    if (value == null) {
      return null;
    } else {
      return Short.valueOf(value.shortValue());
    }
  }

  private static Short negate(Short value) {

    if (value == null) {
      return null;
    }
    return Short.valueOf((short) -value.shortValue());
  }

  @SafeVarargs
  private static Short plusAll(ReadableValue<? extends Number>... observables) {

    short sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = (short) (sum + value.shortValue());
        }
      }
    }
    return Short.valueOf(sum);
  }

  private static Short plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Short plus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Short.valueOf((short) (v1.shortValue() + v2.shortValue()));
  }

  private static Short plus(short v1, Number v2) {

    if (v2 != null) {
      v1 = (short) (v1 + v2.shortValue());
    }
    return Short.valueOf(v1);
  }

}
