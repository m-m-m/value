/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.integers;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link IntegerExpression}.
 */
@SuppressWarnings("javadoc")
class IntegerExpressionTest extends NumberExpressionTest<Integer> {

  private static final Integer ZERO = Integer.valueOf(0);

  private static final Integer ONE = Integer.valueOf(1);

  private static final Integer TEN = Integer.valueOf(10);

  @Override
  protected Class<Integer> getValueClass() {

    return Integer.class;
  }

  @Override
  protected Integer get(int i) {

    return Integer.valueOf(i);
  }

  @Override
  protected NumberExpression<Integer> of(Integer value) {

    return new IntegerExpressionMock(value);
  }

  @Test
  void testAddCustom() {

    IntegerExpressionMock value = new IntegerExpressionMock();
    value.set(ONE);
    IntegerExpression expression = value.expAdd(1).expAdd((short) 1).expAdd((byte) 5);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(8));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(17));
    IntegerExpressionMock value2 = new IntegerExpressionMock();
    value2.set(ONE);
    IntegerExpression expression2 = expression.expAdd(value2);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(18));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(27));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(18));

    IntegerExpression sum = IntegerBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Integer.valueOf(27)); // 27 = 1 + 8 + 18
  }

  @Test
  void testSubtractCustom() {

    IntegerExpressionMock value = new IntegerExpressionMock(Integer.valueOf(8));
    IntegerExpression expression = value.expSub(1).expSub((short) 1).expSub((byte) 6);
    assertThat(expression.getValue()).isEqualTo(ZERO);
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(2));
    IntegerExpressionMock value2 = new IntegerExpressionMock(ONE);
    IntegerExpression expression2 = expression.expSub(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(-8)); // 2 - 10
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(-17));
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(-7));

    IntegerExpression difference = IntegerBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Integer.valueOf(25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  void testMultiplyCustom() {

    Integer two = Integer.valueOf(2);
    IntegerExpressionMock value = new IntegerExpressionMock(Integer.valueOf(4));
    IntegerExpression expression = value.expMul(2).expMul((short) 2).expMul((byte) 32);

    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(512));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(1280));
    IntegerExpressionMock value2 = new IntegerExpressionMock(two);
    IntegerExpression expression2 = expression.expMul(value2);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(2560));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(12800));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(1280));
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(128));

    IntegerExpression product = IntegerBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Integer.valueOf(163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  void testDivideCustom() {

    IntegerExpressionMock value = new IntegerExpressionMock(Integer.valueOf(4096));
    IntegerExpression expression = value.expDiv(2).expDiv((short) 2).expDiv((byte) 32);

    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(32));
    value.set(Integer.valueOf(512));
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(4));
    IntegerExpressionMock value2 = new IntegerExpressionMock(Integer.valueOf(4));
    IntegerExpression expression2 = expression.expDiv(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(Integer.valueOf(2));
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(2));
    value.set(Integer.valueOf(256));
    assertThat(expression2.getValue()).isEqualTo(ONE);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(2));

    IntegerExpression quotient = IntegerBinding.divideAll(value, expression, expression2);
    // 128 = 256 / 2 / 1
    assertThat(quotient.getValue()).isEqualTo(Integer.valueOf(128));
  }

}
