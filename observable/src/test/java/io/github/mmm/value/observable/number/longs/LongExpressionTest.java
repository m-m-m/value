/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.longs;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link LongExpression}.
 */
@SuppressWarnings("javadoc")
class LongExpressionTest extends NumberExpressionTest<Long> {

  private static final Long ZERO = Long.valueOf(0);

  private static final Long ONE = Long.valueOf(1);

  private static final Long TEN = Long.valueOf(10);

  @Override
  protected Class<Long> getValueClass() {

    return Long.class;
  }

  @Override
  protected Long get(int i) {

    return Long.valueOf(i);
  }

  @Override
  protected NumberExpression<Long> of(Long value) {

    return new LongExpressionMock(value);
  }

  @Test
  void testAddCustom() {

    LongExpressionMock value = new LongExpressionMock();
    value.set(ONE);
    LongExpression expression = value.expAdd(1L).expAdd(1).expAdd((short) 1).expAdd((byte) 4);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(8));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(17));
    LongExpressionMock value2 = new LongExpressionMock();
    value2.set(ONE);
    LongExpression expression2 = expression.expAdd(value2);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(18));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(27));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(18));

    LongExpression sum = LongBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Long.valueOf(27)); // 27 = 1 + 8 + 18
  }

  @Test
  void testSubtractCustom() {

    LongExpressionMock value = new LongExpressionMock(Long.valueOf(8));
    LongExpression expression = value.expSub(1L).expSub(1).expSub((short) 1).expSub((byte) 5);
    assertThat(expression.getValue()).isEqualTo(ZERO);
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(2));
    LongExpressionMock value2 = new LongExpressionMock(ONE);
    LongExpression expression2 = expression.expSub(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(-8)); // 2 - 10
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(-17));
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(-7));

    LongExpression difference = LongBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Long.valueOf(25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  void testMultiplyCustom() {

    Long two = Long.valueOf(2);
    LongExpressionMock value = new LongExpressionMock(Long.valueOf(4));
    LongExpression expression = value.expMul(2L).expMul(2).expMul((short) 2).expMul((byte) 16);

    assertThat(expression.getValue()).isEqualTo(Long.valueOf(512));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(1280));
    LongExpressionMock value2 = new LongExpressionMock(two);
    LongExpression expression2 = expression.expMul(value2);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(2560));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(12800));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(1280));
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(128));

    LongExpression product = LongBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Long.valueOf(163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  void testDivideCustom() {

    LongExpressionMock value = new LongExpressionMock(Long.valueOf(4096));
    LongExpression expression = value.expDiv(2L).expDiv(2).expDiv((short) 2).expDiv((byte) 16);

    assertThat(expression.getValue()).isEqualTo(Long.valueOf(32));
    value.set(Long.valueOf(512));
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(4));
    LongExpressionMock value2 = new LongExpressionMock(Long.valueOf(4));
    LongExpression expression2 = expression.expDiv(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(Long.valueOf(2));
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(2));
    value.set(Long.valueOf(256));
    assertThat(expression2.getValue()).isEqualTo(ONE);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(2));

    LongExpression quotient = LongBinding.divideAll(value, expression, expression2);
    // 128 = 256 / 2 / 1
    assertThat(quotient.getValue()).isEqualTo(Long.valueOf(128));
  }

}
