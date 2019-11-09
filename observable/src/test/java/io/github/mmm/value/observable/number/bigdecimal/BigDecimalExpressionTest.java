/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalBinding;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;

/**
 * Test of {@link BigDecimalExpression}.
 */
@SuppressWarnings("javadoc")
public class BigDecimalExpressionTest extends NumberExpressionTest<BigDecimal> {

  @Override
  protected Class<BigDecimal> getValueClass() {

    return BigDecimal.class;
  }

  @Override
  protected BigDecimal get(int i) {

    return BigDecimal.valueOf(i);
  }

  @Override
  protected NumberExpression<BigDecimal> of(BigDecimal value) {

    return new BigDecimalExpressionMock(value);
  }

  @Test
  public void testAddCustom() {

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

    BigDecimalExpression sum = BigDecimalBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(BigDecimal.valueOf(29D)); // 29 = 1 + 9 + 19
  }

  @Test
  public void testSubtractCustom() {

    BigDecimalExpressionMock value = new BigDecimalExpressionMock(BigDecimal.valueOf(8));
    BigDecimalExpression expression = value.subtract(1D).subtract(1F).subtract(1L).subtract(1).subtract((short) 1)
        .subtract((byte) 1).subtract(BigInteger.ONE).subtract(BigDecimal.ONE);
    assertThat(expression.getValue()).isEqualTo(BigDecimal.valueOf(0D));
    value.setValue(BigDecimal.TEN);
    assertThat(expression.getValue()).isEqualTo(BigDecimal.valueOf(2D));
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock(BigDecimal.ONE);
    BigDecimalExpression expression2 = expression.subtract(value2);
    assertThat(expression2.getValue()).isEqualTo(BigDecimal.valueOf(1D));
    value2.setValue(BigDecimal.TEN);
    assertThat(expression2.getValue()).isEqualTo(BigDecimal.valueOf(-8D)); // 2 - 10
    value.setValue(BigDecimal.ONE);
    assertThat(expression2.getValue()).isEqualTo(BigDecimal.valueOf(-17D));
    assertThat(expression.getValue()).isEqualTo(BigDecimal.valueOf(-7D));

    BigDecimalExpression difference = BigDecimalBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(BigDecimal.valueOf(25D)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  public void testMultiplyCustom() {

    BigDecimal two = BigDecimal.valueOf(2.0);
    BigDecimalExpressionMock value = new BigDecimalExpressionMock(two);
    BigDecimalExpression expression = value.multiply(2D).multiply(2F).multiply(2L).multiply(2).multiply((short) 2)
        .multiply((byte) 2).multiply(BigInteger.valueOf(2)).multiply(two);

    assertThat(expression.getValue()).isCloseTo(BigDecimal.valueOf(512D), BD_EPSYLON);
    value.setValue(BigDecimal.TEN);
    assertThat(expression.getValue()).isCloseTo(BigDecimal.valueOf(2560D), BD_EPSYLON);
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock(two);
    BigDecimalExpression expression2 = expression.multiply(value2);
    assertThat(expression2.getValue()).isCloseTo(BigDecimal.valueOf(5120D), BD_EPSYLON);
    value2.setValue(BigDecimal.TEN);
    assertThat(expression2.getValue()).isCloseTo(BigDecimal.valueOf(25600D), BD_EPSYLON);
    value.setValue(BigDecimal.ONE);
    assertThat(expression2.getValue()).isCloseTo(BigDecimal.valueOf(2560D), BD_EPSYLON);
    assertThat(expression.getValue()).isCloseTo(BigDecimal.valueOf(256D), BD_EPSYLON);

    BigDecimalExpression product = BigDecimalBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isCloseTo(BigDecimal.valueOf(655360D), BD_EPSYLON); // 655360 = 1 * 256 * 2560
  }

  @Test
  public void testDivideCustom() {

    BigDecimal two = BigDecimal.valueOf(2.0);
    BigDecimalExpressionMock value = new BigDecimalExpressionMock(BigDecimal.ONE);
    BigDecimalExpression expression = value.divide(2D).divide(2F).divide(2L).divide(2).divide((short) 2)
        .divide((byte) 2).divide(BigInteger.valueOf(2)).divide(two);

    assertThat(expression.getValue()).isCloseTo(BigDecimal.valueOf(1 / 256D), BD_EPSYLON);
    value.setValue(BigDecimal.TEN);
    assertThat(expression.getValue()).isCloseTo(BigDecimal.valueOf(10 / 256D), BD_EPSYLON);
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock(two);
    BigDecimalExpression expression2 = expression.divide(value2);
    assertThat(expression2.getValue()).isCloseTo(BigDecimal.valueOf(10 / 512D), BD_EPSYLON);
    value2.setValue(BigDecimal.TEN);
    assertThat(expression2.getValue()).isCloseTo(BigDecimal.valueOf(10 / 2560D), BD_EPSYLON);
    value.setValue(BigDecimal.ONE);
    assertThat(expression2.getValue()).isCloseTo(BigDecimal.valueOf(1 / 2560D), BD_EPSYLON);
    assertThat(expression.getValue()).isCloseTo(BigDecimal.valueOf(1 / 256D), BD_EPSYLON);

    BigDecimalExpression quotient = BigDecimalBinding.divideAll(value, expression, expression2);
    // 655360 = 1 / ( 1 /256) / ( 1 / 2560)
    assertThat(quotient.getValue()).isCloseTo(BigDecimal.valueOf(655360D), BD_EPSYLON);
  }

}
