/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.floats;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link FloatExpression}.
 */
@SuppressWarnings("javadoc")
public class FloatExpressionTest extends NumberExpressionTest<Float> {

  private static final Float ONE = Float.valueOf(1);

  private static final Float TEN = Float.valueOf(10);

  @Override
  protected Class<Float> getValueClass() {

    return Float.class;
  }

  @Override
  protected Float get(int i) {

    return Float.valueOf(i);
  }

  @Override
  protected NumberExpression<Float> of(Float value) {

    return new FloatExpressionMock(value);
  }

  @Test
  public void testAddCustom() {

    FloatExpressionMock value = new FloatExpressionMock(ONE);
    FloatExpression expression = value.expAdd(1F).expAdd(1L).expAdd(1).expAdd((short) 1).expAdd((byte) 2);
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(7));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(16));
    FloatExpressionMock value2 = new FloatExpressionMock();
    value2.set(ONE);
    FloatExpression expression2 = expression.expAdd(value2);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(17));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(26));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(17));

    FloatExpression sum = FloatBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Float.valueOf(25)); // 25 = 1 + 7 + 17
  }

  @Test
  public void testSubtractCustom() {

    FloatExpressionMock value = new FloatExpressionMock(Float.valueOf(8));
    FloatExpression expression = value.expSub(1F).expSub(1L).expSub(1).expSub((short) 2).expSub((byte) 1);
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(2));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(4));
    FloatExpressionMock value2 = new FloatExpressionMock(ONE);
    FloatExpression expression2 = expression.expSub(value2);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(3));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(-6));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(-15));
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(-5));

    FloatExpression difference = FloatBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Float.valueOf(21)); // 25 = 1 - (-5) - (-15)
  }

  @Test
  public void testMultiplyCustom() {

    Float two = Float.valueOf(2.0F);
    FloatExpressionMock value = new FloatExpressionMock(two);
    FloatExpression expression = value.expMul(2F).expMul(2L).expMul(2).expMul((short) 16).expMul((byte) 2);

    assertThat(expression.getValue()).isEqualTo(Float.valueOf(512));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(2560));
    FloatExpressionMock value2 = new FloatExpressionMock(two);
    FloatExpression expression2 = expression.expMul(value2);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(5120));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(25600));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(2560));
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(256));

    FloatExpression product = FloatBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Float.valueOf(655360)); // 655360 = 1 * 256 * 2560
  }

  @Test
  public void testDivideCustom() {

    Float two = Float.valueOf(2.0F);
    FloatExpressionMock value = new FloatExpressionMock(ONE);
    FloatExpression expression = value.expDiv(2F).expDiv(2L).expDiv(2).expDiv((short) 2).expDiv((byte) 16);

    assertThat(expression.getValue()).isEqualTo(Float.valueOf(1 / 256F));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(10 / 256F));
    FloatExpressionMock value2 = new FloatExpressionMock(two);
    FloatExpression expression2 = expression.expDiv(value2);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(10 / 512F));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(10 / 2560F));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Float.valueOf(1 / 2560F));
    assertThat(expression.getValue()).isEqualTo(Float.valueOf(1 / 256F));

    FloatExpression quotient = FloatBinding.divideAll(value, expression, expression2);
    // 655360 = 1 / ( 1 /256) / ( 1 / 2560)
    assertThat(quotient.getValue()).isEqualTo(Float.valueOf(655360));
  }

}
