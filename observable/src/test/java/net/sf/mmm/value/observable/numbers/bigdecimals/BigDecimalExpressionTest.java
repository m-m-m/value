/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.mmm.value.observable.ObservableEvent;
import net.sf.mmm.value.observable.ObservableEventListenerMock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link BigDecimalExpression}.
 */
@SuppressWarnings("javadoc")
public class BigDecimalExpressionTest extends Assertions {

  @Test
  public void testEmpty() {

    BigDecimalExpressionMock value = new BigDecimalExpressionMock();
    assertThat(value.getValueClass()).isSameAs(BigDecimal.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.isBound()).isFalse();
    assertThat(value.doubleValue()).isZero();
    assertThat(value.floatValue()).isZero();
    assertThat(value.longValue()).isZero();
    assertThat(value.intValue()).isZero();
    assertThat(value.shortValue()).isZero();
    assertThat(value.byteValue()).isZero();
    assertThat(value.getValueSafe()).isSameAs(BigDecimal.ZERO);
    assertThat(value.getValue()).isNull();
  }

  @Test
  public void testModify() {

    BigDecimalExpressionMock value = new BigDecimalExpressionMock();

    ObservableEventListenerMock<BigDecimal> listener = new ObservableEventListenerMock<>();
    value.addListener(listener);
    assertThat(value.getValue()).isNull();
    assertThat(listener.getEvent()).isNull();
    value.setValue(BigDecimal.ZERO);
    assertThat(value.getValue()).isSameAs(BigDecimal.ZERO);
    ObservableEvent<BigDecimal> event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(value);
    assertThat(event.getOldValue()).isNull();
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getValue()).isSameAs(BigDecimal.ZERO);
    assertThat(event.getModification()).isNull();
    assertThat(event.isChangedObservable()).isTrue();
    assertThat(event.isChangedValue()).isFalse();
    value.setValue(BigDecimal.ONE);
    event = listener.getEvent();
    assertThat(event).isNotNull();
    assertThat(event.getObservable()).isSameAs(value);
    assertThat(event.getOldValue()).isSameAs(BigDecimal.ZERO);
    assertThat(event.hasOldValue()).isTrue();
    assertThat(event.getValue()).isSameAs(BigDecimal.ONE);
    assertThat(event.getModification()).isNull();
    assertThat(event.isChangedObservable()).isTrue();
    assertThat(event.isChangedValue()).isFalse();
  }

  @Test
  public void testAdd() {

    BigDecimalExpressionMock value = new BigDecimalExpressionMock();
    value.setValue(BigDecimal.ONE);
    BigDecimalExpression expression = value.add(1D).add(1F).add(1L).add(1).add((short) 1).add((byte) 1)
        .add(BigInteger.ONE).add(BigDecimal.ONE);
    assertThat(expression.getValue()).isEqualTo(BigDecimal.valueOf(9D));
    value.setValue(BigDecimal.TEN);
    assertThat(expression.getValue()).isEqualTo(BigDecimal.valueOf(18D));
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock();
    value2.setValue(BigDecimal.ONE);
    BigDecimalExpression expression2 = expression.add(value2);
    assertThat(expression2.getValue()).isEqualTo(BigDecimal.valueOf(19D));
    value2.setValue(BigDecimal.TEN);
    assertThat(expression2.getValue()).isEqualTo(BigDecimal.valueOf(28D));
    value.setValue(BigDecimal.ONE);
    assertThat(expression2.getValue()).isEqualTo(BigDecimal.valueOf(19D));
  }

}
