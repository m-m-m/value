/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.doubles;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link DoubleExpression}.
 */
@SuppressWarnings("javadoc")
class DoubleExpressionTest extends NumberExpressionTest<Double> {

  private static final Double ONE = Double.valueOf(1);

  private static final Double TEN = Double.valueOf(10);

  @Override
  protected Class<Double> getValueClass() {

    return Double.class;
  }

  @Override
  protected Double get(int i) {

    return Double.valueOf(i);
  }

  @Override
  protected NumberExpression<Double> of(Double value) {

    return new DoubleExpressionMock(value);
  }

  @Test
  void testAddCustom() {

    DoubleExpressionMock value = new DoubleExpressionMock(ONE);
    DoubleExpression expression = value.expAdd(1D).expAdd(1F).expAdd(1L).expAdd(1).expAdd((short) 1).expAdd((byte) 1);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(7));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(16));
    DoubleExpressionMock value2 = new DoubleExpressionMock();
    value2.set(ONE);
    DoubleExpression expression2 = expression.expAdd(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(17));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(26));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(17));

    DoubleExpression sum = DoubleBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Double.valueOf(25)); // 25 = 1 + 7 + 17
  }

  @Test
  void testSubtractCustom() {

    DoubleExpressionMock value = new DoubleExpressionMock(Double.valueOf(8));
    DoubleExpression expression = value.expSub(1D).expSub(1F).expSub(1L).expSub(1).expSub((short) 1).expSub((byte) 1);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(2));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(4));
    DoubleExpressionMock value2 = new DoubleExpressionMock(ONE);
    DoubleExpression expression2 = expression.expSub(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(3));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(-6));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(-15));
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(-5));

    DoubleExpression difference = DoubleBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Double.valueOf(21)); // 25 = 1 - (-5) - (-15)
  }

  @Test
  void testMultiplyCustom() {

    Double two = Double.valueOf(2.0);
    DoubleExpressionMock value = new DoubleExpressionMock(two);
    DoubleExpression expression = value.expMul(2D).expMul(2F).expMul(2L).expMul(2).expMul((short) 8).expMul((byte) 2);

    assertThat(expression.getValue()).isEqualTo(Double.valueOf(512));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(2560));
    DoubleExpressionMock value2 = new DoubleExpressionMock(two);
    DoubleExpression expression2 = expression.expMul(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(5120));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(25600));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(2560));
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(256));

    DoubleExpression product = DoubleBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Double.valueOf(655360D)); // 655360 = 1 * 256 * 2560
  }

  @Test
  void testDivideCustom() {

    Double two = Double.valueOf(2.0);
    DoubleExpressionMock value = new DoubleExpressionMock(ONE);
    DoubleExpression expression = value.expDiv(2D).expDiv(2F).expDiv(2L).expDiv(2).expDiv((short) 2).expDiv((byte) 8);

    assertThat(expression.getValue()).isEqualTo(Double.valueOf(1 / 256D));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(10 / 256D));
    DoubleExpressionMock value2 = new DoubleExpressionMock(two);
    DoubleExpression expression2 = expression.expDiv(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(10 / 512D));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(10 / 2560D));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(1 / 2560D));
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(1 / 256D));

    DoubleExpression quotient = DoubleBinding.divideAll(value, expression, expression2);
    // 655360 = 1 / ( 1 /256) / ( 1 / 2560)
    assertThat(quotient.getValue()).isEqualTo(Double.valueOf(655360D));
  }

}
