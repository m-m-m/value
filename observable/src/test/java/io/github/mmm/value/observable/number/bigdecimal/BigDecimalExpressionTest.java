/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link BigDecimalExpression}.
 */
@SuppressWarnings("javadoc")
class BigDecimalExpressionTest extends NumberExpressionTest<BigDecimal> {

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
  void testAddCustom() {

    BigDecimalExpressionMock value = new BigDecimalExpressionMock();
    value.set(BigDecimal.ONE);
    BigDecimalExpression expression = value.expAdd(1D).expAdd(1F).expAdd(1L).expAdd(1).expAdd((short) 1)
        .expAdd((byte) 1).expAdd(BigInteger.ONE).expAdd(BigDecimal.ONE);
    assertThat(expression.get()).isEqualTo(BigDecimal.valueOf(9D));
    value.set(BigDecimal.TEN);
    assertThat(expression.get()).isEqualTo(BigDecimal.valueOf(18D));
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock();
    value2.set(BigDecimal.ONE);
    BigDecimalExpression expression2 = expression.expAdd(value2);
    assertThat(expression2.get()).isEqualTo(BigDecimal.valueOf(19D));
    value2.set(BigDecimal.TEN);
    assertThat(expression2.get()).isEqualTo(BigDecimal.valueOf(28D));
    value.set(BigDecimal.ONE);
    assertThat(expression2.get()).isEqualTo(BigDecimal.valueOf(19D));

    BigDecimalExpression sum = BigDecimalBinding.addAll(value, expression, expression2);
    assertThat(sum.get()).isEqualTo(BigDecimal.valueOf(29D)); // 29 = 1 + 9 + 19
  }

  @Test
  void testSubtractCustom() {

    BigDecimalExpressionMock value = new BigDecimalExpressionMock(BigDecimal.valueOf(8));
    BigDecimalExpression expression = value.expSub(1D).expSub(1F).expSub(1L).expSub(1).expSub((short) 1)
        .expSub((byte) 1).expSub(BigInteger.ONE).expSub(BigDecimal.ONE);
    assertThat(expression.get()).isEqualTo(BigDecimal.valueOf(0D));
    value.set(BigDecimal.TEN);
    assertThat(expression.get()).isEqualTo(BigDecimal.valueOf(2D));
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock(BigDecimal.ONE);
    BigDecimalExpression expression2 = expression.expSub(value2);
    assertThat(expression2.get()).isEqualTo(BigDecimal.valueOf(1D));
    value2.set(BigDecimal.TEN);
    assertThat(expression2.get()).isEqualTo(BigDecimal.valueOf(-8D)); // 2 - 10
    value.set(BigDecimal.ONE);
    assertThat(expression2.get()).isEqualTo(BigDecimal.valueOf(-17D));
    assertThat(expression.get()).isEqualTo(BigDecimal.valueOf(-7D));

    BigDecimalExpression difference = BigDecimalBinding.subtractAll(value, expression, expression2);
    assertThat(difference.get()).isEqualTo(BigDecimal.valueOf(25D)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  void testMultiplyCustom() {

    BigDecimal two = BigDecimal.valueOf(2.0);
    BigDecimalExpressionMock value = new BigDecimalExpressionMock(two);
    BigDecimalExpression expression = value.expMul(2D).expMul(2F).expMul(2L).expMul(2).expMul((short) 2)
        .expMul((byte) 2).expMul(BigInteger.valueOf(2)).expMul(two);

    assertThat(expression.get()).isCloseTo(BigDecimal.valueOf(512D), BD_EPSYLON);
    value.set(BigDecimal.TEN);
    assertThat(expression.get()).isCloseTo(BigDecimal.valueOf(2560D), BD_EPSYLON);
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock(two);
    BigDecimalExpression expression2 = expression.expMul(value2);
    assertThat(expression2.get()).isCloseTo(BigDecimal.valueOf(5120D), BD_EPSYLON);
    value2.set(BigDecimal.TEN);
    assertThat(expression2.get()).isCloseTo(BigDecimal.valueOf(25600D), BD_EPSYLON);
    value.set(BigDecimal.ONE);
    assertThat(expression2.get()).isCloseTo(BigDecimal.valueOf(2560D), BD_EPSYLON);
    assertThat(expression.get()).isCloseTo(BigDecimal.valueOf(256D), BD_EPSYLON);

    BigDecimalExpression product = BigDecimalBinding.multiplyAll(value, expression, expression2);
    assertThat(product.get()).isCloseTo(BigDecimal.valueOf(655360D), BD_EPSYLON); // 655360 = 1 * 256 * 2560
  }

  @Test
  void testDivideCustom() {

    BigDecimal two = BigDecimal.valueOf(2.0);
    BigDecimalExpressionMock value = new BigDecimalExpressionMock(BigDecimal.ONE);
    BigDecimalExpression expression = value.expDiv(2D).expDiv(2F).expDiv(2L).expDiv(2).expDiv((short) 2)
        .expDiv((byte) 2).expDiv(BigInteger.valueOf(2)).expDiv(two);

    assertThat(expression.get()).isCloseTo(BigDecimal.valueOf(1 / 256D), BD_EPSYLON);
    value.set(BigDecimal.TEN);
    assertThat(expression.get()).isCloseTo(BigDecimal.valueOf(10 / 256D), BD_EPSYLON);
    BigDecimalExpressionMock value2 = new BigDecimalExpressionMock(two);
    BigDecimalExpression expression2 = expression.expDiv(value2);
    assertThat(expression2.get()).isCloseTo(BigDecimal.valueOf(10 / 512D), BD_EPSYLON);
    value2.set(BigDecimal.TEN);
    assertThat(expression2.get()).isCloseTo(BigDecimal.valueOf(10 / 2560D), BD_EPSYLON);
    value.set(BigDecimal.ONE);
    assertThat(expression2.get()).isCloseTo(BigDecimal.valueOf(1 / 2560D), BD_EPSYLON);
    assertThat(expression.get()).isCloseTo(BigDecimal.valueOf(1 / 256D), BD_EPSYLON);

    BigDecimalExpression quotient = BigDecimalBinding.divideAll(value, expression, expression2);
    // 655360 = 1 / ( 1 /256) / ( 1 / 2560)
    assertThat(quotient.get()).isCloseTo(BigDecimal.valueOf(655360D), BD_EPSYLON);
  }

}
