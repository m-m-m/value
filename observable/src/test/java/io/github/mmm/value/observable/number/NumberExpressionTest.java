/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.ObservableEvent;
import io.github.mmm.value.observable.ObservableEventListenerMock;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;

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
    assertThat(expression.get()).isNull();
    assertThat(expression.doubleValue()).isZero();
    assertThat(expression.floatValue()).isZero();
    assertThat(expression.longValue()).isZero();
    assertThat(expression.intValue()).isZero();
    assertThat(expression.shortValue()).isZero();
    assertThat(expression.byteValue()).isZero();
    assertThat(expression.getSafe()).isEqualTo(get(0));
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
    assertThat(expression.get()).isNull();
    assertThat(listener.getEvent()).isNull();
    // test zero
    writable.set(zero);
    assertThat(expression.get()).isSameAs(zero);
    ObservableEvent<N> event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(expression);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getOldValue()).isNull();
    assertThat(event.getValue()).isSameAs(zero);
    assertThat(event.isChange()).isFalse();
    assertThat(expression.getSafe()).isSameAs(zero);
    assertThat(expression.doubleValue()).isZero();
    assertThat(expression.floatValue()).isZero();
    assertThat(expression.longValue()).isZero();
    assertThat(expression.intValue()).isZero();
    assertThat(expression.shortValue()).isZero();
    assertThat(expression.byteValue()).isZero();
    // test one
    writable.set(one);
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
    assertThat(expression.get()).isSameAs(one);
    assertThat(listener.getEvent()).isNull();
    writable.set(two);
    assertThat(expression.get()).isSameAs(two);
    ObservableEvent<N> event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(expression);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getOldValue()).isSameAs(one);
    assertThat(event.getValue()).isSameAs(two);
    assertThat(event.isChange()).isFalse();
    writable.set(three);
    assertThat(expression.get()).isSameAs(three);
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
    NumberExpression<?> term = expression.expAdd(one);
    assertThat(term.get()).isEqualTo(two);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    term = expression.expAdd(expression);
    assertThat(term.get()).isEqualTo(two);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    // BigDecimal
    BigDecimal bd1 = BigDecimal.valueOf(1);
    BigDecimal bd2 = BigDecimal.valueOf(2);
    BigDecimalExpression bdTerm = expression.expAdd(bd1);
    term = bdTerm;
    assertEquals(term.get(), bd2);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term = expression.expAdd(bdTerm);
    assertEquals(term.get(), BigDecimal.valueOf(3));
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
    NumberExpression<?> term = expression.expSub(one);
    assertEquals(term.get(), one);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    // 2-2=0
    term = expression.expSub(expression);
    assertEquals(term.get(), zero);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();

    // BigDecimal: 2-1=1
    BigDecimalExpression bdTerm = expression.expSub(BigDecimal.ONE);
    term = bdTerm;
    assertEquals(term.get(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term = expression.expSub(bdTerm);
    assertEquals(term.get(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    term = bdTerm;
    term = expression.expSub(term);
    assertEquals(term.get(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    term = expression.expSub((Number) BigDecimal.ONE);
    assertEquals(term.get(), BigDecimal.ONE);
    assertThat(term.getValueClass()).isSameAs(BigDecimal.class);
    term.dispose();
    term = expression.expSub((Number) BigInteger.ONE);
    assertThat(term.get().intValue()).isEqualTo(1);
    term.dispose();
  }

  @Test
  public void testMultiply() {

    // given
    N two = get(2);
    N four = get(4);
    NumberExpression<N> expression = of(two);

    // 2*2=4
    NumberExpression<?> term = expression.expMul(two);
    assertEquals(term.get(), four);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    term = expression.expMul(expression);
    assertEquals(term.get(), four);
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
    NumberExpression<?> term = expression.expDiv(four);
    assertEquals(term.get(), two);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
    term = expression.expDiv(expression);
    assertEquals(term.get(), one);
    assertThat(term.getValueClass()).isSameAs(getValueClass());
    term.dispose();
  }

}
