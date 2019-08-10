package net.sf.mmm.value.observable.numbers.longs;

import java.util.function.Supplier;

import net.sf.mmm.value.ReadableValue;
import net.sf.mmm.value.observable.ObservableValue;
import net.sf.mmm.value.observable.numbers.NumberBinding;
import net.sf.mmm.value.observable.numbers.NumberExpression;

/**
 * {@link net.sf.mmm.value.observable.Binding} for a {@link Long} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class LongBinding extends NumberBinding<Long> implements LongExpression {

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public LongBinding(Supplier<Long> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link LongExpression} to negate.
   * @return a new {@link LongExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link LongExpression}.
   * @see #negate()
   */
  public static LongExpression negate(LongExpression expression) {

    return new LongBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link LongExpression}.
   */
  public static LongExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof LongExpression) {
      return (LongExpression) expression;
    } else {
      return new LongBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link LongExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #getValue() value}s of the first and the second
   *         given {@link ObservableValue}s.
   * @see #add(ObservableLongValue)
   */
  public static LongExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new LongBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link LongExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link LongExpression} with the given {@code constant}.
   * @see #add(ObservableLongValue)
   */
  public static LongExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.longValue());
  }

  /**
   * @param expression the {@link LongExpression} to add.
   * @param constant the constant {@code long} to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link LongExpression} with the given {@code constant}.
   * @see #add(ObservableLongValue)
   */
  public static LongExpression add(NumberExpression<?> expression, long constant) {

    return new LongBinding(() -> plus(constant, expression.getValue()), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link LongExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static LongExpression sum(ObservableValue<? extends Number>... observables) {

    return new LongBinding(() -> plusAll(observables), observables);
  }

  private static Long to(Number value) {

    if (value == null) {
      return null;
    } else if (value instanceof Long) {
      return (Long) value;
    } else {
      return Long.valueOf(value.longValue());
    }
  }

  private static Long negate(Long value) {

    if (value == null) {
      return null;
    }
    return Long.valueOf(-value.longValue());
  }

  @SafeVarargs
  private static Long plusAll(ReadableValue<? extends Number>... observables) {

    long sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = sum + value.longValue();
        }
      }
    }
    return Long.valueOf(sum);
  }

  private static Long plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Long plus(Number v1, Number v2) {

    if ((v1 == null) && (v2 == null)) {
      return null;
    }
    if (v1 == null) {
      return to(v2);
    }
    if (v2 == null) {
      return to(v1);
    }
    return Long.valueOf(v1.longValue() + v2.longValue());
  }

  private static Long plus(long v1, Number v2) {

    if (v2 != null) {
      v1 = v1 + v2.longValue();
    }
    return Long.valueOf(v1);
  }

}
