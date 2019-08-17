/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableEvent;
import net.sf.mmm.value.observable.ObservableEventListenerMock;
import net.sf.mmm.value.observable.numbers.bigdecimals.BigDecimalExpression;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

/**
 * Abstract test-case for {@link NumberExpression}.
 */
@SuppressWarnings("javadoc")
public abstract class NumberExpressionTest<N extends Number & Comparable<? super N>> extends Assertions {

  protected static final Offset<BigDecimal> BD_EPSYLON = Offset.offset(BigDecimal.valueOf(0.0000000000000001D));

  protected abstract Class<N> getValueClass();

  protected abstract N get(int i);

  protected NumberExpression<N> of() {

    return of(null);
  }

  protected NumberExpression<N> of(int i) {

    return of(get(i));
  }

  protected abstract NumberExpression<N> of(N value);

  @Test
  public void testEmpty() {

    // given
    NumberExpression<N> expression = of();

    // when + then
    assertThat(expression.getValueClass()).isSameAs(getValueClass());
    assertThat(expression.getValue()).isNull();
    assertThat(expression.doubleValue()).isZero();
    assertThat(expression.floatValue()).isZero();
    assertThat(expression.longValue()).isZero();
    assertThat(expression.intValue()).isZero();
    assertThat(expression.shortValue()).isZero();
    assertThat(expression.byteValue()).isZero();
    assertThat(expression.getValueSafe()).isEqualTo(get(0));
  }

  @Test
  public void testModifications() {

    // given
    NumberExpression<N> expression = of();
    @SuppressWarnings("unchecked")
    WritableNumberValue<N> writable = (WritableNumberValue<N>) expression;
    N zero = get(0);
    N one = get(1);

    // when + then
    ObservableEventListenerMock<N> listener = new ObservableEventListenerMock<>();
    expression.addListener(listener);
    assertThat(expression.getValue()).isNull();
    assertThat(listener.getEvent()).isNull();
    // test zero
    writable.setValue(zero);
    assertThat(expression.getValue()).isSameAs(zero);
    ObservableEvent<N> event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(expression);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getOldValue()).isNull();
    assertThat(event.getValue()).isSameAs(zero);
    assertThat(event.isChange()).isFalse();
    assertThat(expression.getValueSafe()).isSameAs(zero);
    assertThat(expression.doubleValue()).isZero();
    assertThat(expression.floatValue()).isZero();
    assertThat(expression.longValue()).isZero();
    assertThat(expression.intValue()).isZero();
    assertThat(expression.shortValue()).isZero();
    assertThat(expression.byteValue()).isZero();
    // test one
    writable.setValue(one);
    event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(expression);
    assertThat(event.getOldValue()).isSameAs(zero);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getValue()).isSameAs(one);
    assertThat(event.isChange()).isFalse();
  }

  private static void assertEquals(Number actual, Number expected) {

    if ((actual instanceof BigDecimal) && (expected instanceof BigDecimal)) {
      assertThat((BigDecimal) actual).isCloseTo((BigDecimal) expected, BD_EPSYLON);
    } else {
      assertThat(actual).isEqualTo(expected);
    }
  }

  @Test
  public void testInitialValue() {

    // given
    N one = get(1);
    N two = get(2);
    N three = get(3);
    NumberExpression<N> expression = of(one);
    @SuppressWarnings("unchecked")
    WritableNumberValue<N> writable = (WritableNumberValue<N>) expression;
    ObservableEventListenerMock<N> listener = new ObservableEventListenerMock<>();

    // when + then
    expression.addListener(listener);
    assertThat(expression.getValue()).isSameAs(one);
    assertThat(listener.getEvent()).isNull();
    writable.setValue(two);
    assertThat(expression.getValue()).isSameAs(two);
    ObservableEvent<N> event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(expression);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getOldValue()).isSameAs(one);
    assertThat(event.getValue()).isSameAs(two);
    assertThat(event.isChange()).isFalse();
    writable.setValue(three);
    assertThat(expression.getValue()).isSameAs(three);
    event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(expression);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getOldValue()).isSameAs(two);
    assertThat(event.getValue()).isSameAs(three);
    assertThat(event.isChange()).isFalse();
  }

  @Test
  public void testAdd() {

    // given
    N one = get(1);
    N two = get(2);
    NumberExpression<N> expression = of(one);

    // add (1+1=2)
    NumberExpression<?> term = expression.add(one);
    assertThat(term.getValue()).isEqualTo(two);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    term = expression.add(expression);
    assertThat(term.getValue()).isEqualTo(two);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    // BigDecimal
    BigDecimal bd1 = BigDecimal.valueOf(1);
    BigDecimal bd2 = BigDecimal.valueOf(2);
    BigDecimalExpression bdTerm = expression.add(bd1);
    term = bdTerm;
    assertEquals(term.getValue(), bd2);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term = expression.add(bdTerm);
    assertEquals(term.getValue(), BigDecimal.valueOf(3));
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    bdTerm.dispose();
  }

  @Test
  public void testSubtract() {

    // given
    N zero = get(0);
    N one = get(1);
    N two = get(2);
    NumberExpression<N> expression = of(two);

    // 2-1=1
    NumberExpression<?> term = expression.subtract(one);
    assertEquals(term.getValue(), one);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    // 2-2=0
    term = expression.subtract(expression);
    assertEquals(term.getValue(), zero);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();

    // BigDecimal: 2-1=1
    BigDecimalExpression bdTerm = expression.subtract(BigDecimal.ONE);
    term = bdTerm;
    assertEquals(term.getValue(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term = expression.subtract(bdTerm);
    assertEquals(term.getValue(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    term = bdTerm;
    term = expression.subtract(term);
    assertEquals(term.getValue(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    term = expression.subtract((Number) BigDecimal.ONE);
    assertEquals(term.getValue(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    term = expression.subtract((Number) BigInteger.ONE);
    assertThat(term.getValue().intValue()).isEqualTo(1);
    term.dispose();
  }

  @Test
  public void testMultiply() {

    // given
    N two = get(2);
    N four = get(4);
    NumberExpression<N> expression = of(two);

    // 2*2=4
    NumberExpression<?> term = expression.multiply(two);
    assertEquals(term.getValue(), four);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    term = expression.multiply(expression);
    assertEquals(term.getValue(), four);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
  }

  @Test
  public void testDivide() {

    // given
    N eight = get(8);
    N four = get(4);
    N two = get(2);
    N one = get(1);
    NumberExpression<N> expression = of(eight);

    // 8/4=2
    NumberExpression<?> term = expression.divide(four);
    assertEquals(term.getValue(), two);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    term = expression.divide(expression);
    assertEquals(term.getValue(), one);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
  }

}
