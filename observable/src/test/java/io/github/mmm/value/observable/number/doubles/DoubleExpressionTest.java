/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.doubles;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;
import io.github.mmm.value.observable.number.doubles.DoubleBinding;
import io.github.mmm.value.observable.number.doubles.DoubleExpression;

/**
 * Test of {@link DoubleExpression}.
 */
@SuppressWarnings("javadoc")
public class DoubleExpressionTest extends NumberExpressionTest<Double> {

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
  public void testAddCustom() {

    DoubleExpressionMock value = new DoubleExpressionMock(ONE);
    DoubleExpression expression = value.add(1D).add(1F).add(1L).add(1).add((short) 1).add((byte) 1);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(7));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(16));
    DoubleExpressionMock value2 = new DoubleExpressionMock();
    value2.setValue(ONE);
    DoubleExpression expression2 = expression.add(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(17));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(26));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(17));

    DoubleExpression sum = DoubleBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Double.valueOf(25)); // 25 = 1 + 7 + 17
  }

  @Test
  public void testSubtractCustom() {

    DoubleExpressionMock value = new DoubleExpressionMock(Double.valueOf(8));
    DoubleExpression expression = value.subtract(1D).subtract(1F).subtract(1L).subtract(1).subtract((short) 1)
        .subtract((byte) 1);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(2));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(4));
    DoubleExpressionMock value2 = new DoubleExpressionMock(ONE);
    DoubleExpression expression2 = expression.subtract(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(3));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(-6));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(-15));
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(-5));

    DoubleExpression difference = DoubleBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Double.valueOf(21)); // 25 = 1 - (-5) - (-15)
  }

  @Test
  public void testMultiplyCustom() {

    Double two = Double.valueOf(2.0);
    DoubleExpressionMock value = new DoubleExpressionMock(two);
    DoubleExpression expression = value.multiply(2D).multiply(2F).multiply(2L).multiply(2).multiply((short) 8)
        .multiply((byte) 2);

    assertThat(expression.getValue()).isEqualTo(Double.valueOf(512));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(2560));
    DoubleExpressionMock value2 = new DoubleExpressionMock(two);
    DoubleExpression expression2 = expression.multiply(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(5120));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(25600));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(2560));
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(256));

    DoubleExpression product = DoubleBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Double.valueOf(655360D)); // 655360 = 1 * 256 * 2560
  }

  @Test
  public void testDivideCustom() {

    Double two = Double.valueOf(2.0);
    DoubleExpressionMock value = new DoubleExpressionMock(ONE);
    DoubleExpression expression = value.divide(2D).divide(2F).divide(2L).divide(2).divide((short) 2).divide((byte) 8);

    assertThat(expression.getValue()).isEqualTo(Double.valueOf(1 / 256D));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(10 / 256D));
    DoubleExpressionMock value2 = new DoubleExpressionMock(two);
    DoubleExpression expression2 = expression.divide(value2);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(10 / 512D));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(10 / 2560D));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Double.valueOf(1 / 2560D));
    assertThat(expression.getValue()).isEqualTo(Double.valueOf(1 / 256D));

    DoubleExpression quotient = DoubleBinding.divideAll(value, expression, expression2);
    // 655360 = 1 / ( 1 /256) / ( 1 / 2560)
    assertThat(quotient.getValue()).isEqualTo(Double.valueOf(655360D));
  }

}
