/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number.biginteger;

import java.math.BigInteger;

import net.sf.mmm.value.observable.number.NumberExpression;
import net.sf.mmm.value.observable.number.NumberExpressionTest;
import net.sf.mmm.value.observable.number.biginteger.BigIntegerBinding;
import net.sf.mmm.value.observable.number.biginteger.BigIntegerExpression;

import org.junit.jupiter.api.Test;

/**
 * Test of {@link BigIntegerExpression}.
 */
@SuppressWarnings("javadoc")
public class BigIntegerExpressionTest extends NumberExpressionTest<BigInteger> {

  @Override
  protected Class<BigInteger> getValueClass() {

    return BigInteger.class;
  }

  @Override
  protected BigInteger get(int i) {

    return BigInteger.valueOf(i);
  }

  @Override
  protected NumberExpression<BigInteger> of(BigInteger value) {

    return new BigIntegerExpressionMock(value);
  }

  @Test
  public void testAddCustom() {

    BigIntegerExpressionMock value = new BigIntegerExpressionMock();
    value.setValue(BigInteger.ONE);
    BigIntegerExpression expression = value.add(1L).add(1).add((short) 1).add((byte) 3).add(BigInteger.ONE);
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(8));
    value.setValue(BigInteger.TEN);
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(17));
    BigIntegerExpressionMock value2 = new BigIntegerExpressionMock();
    value2.setValue(BigInteger.ONE);
    BigIntegerExpression expression2 = expression.add(value2);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(18));
    value2.setValue(BigInteger.TEN);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(27));
    value.setValue(BigInteger.ONE);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(18));

    BigIntegerExpression sum = BigIntegerBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(BigInteger.valueOf(27)); // 27 = 1 + 8 + 18
  }

  @Test
  public void testSubtractCustom() {

    BigIntegerExpressionMock value = new BigIntegerExpressionMock(BigInteger.valueOf(8));
    BigIntegerExpression expression = value.subtract(1L).subtract(1).subtract((short) 1).subtract((byte) 3)
        .subtract(BigInteger.ONE).subtract(BigInteger.ONE);
    assertThat(expression.getValue()).isEqualTo(BigInteger.ZERO);
    value.setValue(BigInteger.TEN);
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(2));
    BigIntegerExpressionMock value2 = new BigIntegerExpressionMock(BigInteger.ONE);
    BigIntegerExpression expression2 = expression.subtract(value2);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.ONE);
    value2.setValue(BigInteger.TEN);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(-8)); // 2 - 10
    value.setValue(BigInteger.ONE);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(-17));
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(-7));

    BigIntegerExpression difference = BigIntegerBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(BigInteger.valueOf(25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  public void testMultiplyCustom() {

    BigInteger two = BigInteger.valueOf(2);
    BigIntegerExpressionMock value = new BigIntegerExpressionMock(BigInteger.valueOf(4));
    BigIntegerExpression expression = value.multiply(2L).multiply(2).multiply((short) 2).multiply((byte) 8)
        .multiply(two);

    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(512));
    value.setValue(BigInteger.TEN);
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(1280));
    BigIntegerExpressionMock value2 = new BigIntegerExpressionMock(two);
    BigIntegerExpression expression2 = expression.multiply(value2);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(2560));
    value2.setValue(BigInteger.TEN);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(12800));
    value.setValue(BigInteger.ONE);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(1280));
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(128));

    BigIntegerExpression product = BigIntegerBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(BigInteger.valueOf(163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  public void testDivideCustom() {

    BigIntegerExpressionMock value = new BigIntegerExpressionMock(BigInteger.valueOf(4096));
    BigIntegerExpression expression = value.divide(2L).divide(2).divide((short) 2).divide((byte) 8)
        .divide(BigInteger.valueOf(2));

    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(32));
    value.setValue(BigInteger.valueOf(512));
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(4));
    BigIntegerExpressionMock value2 = new BigIntegerExpressionMock(BigInteger.valueOf(4));
    BigIntegerExpression expression2 = expression.divide(value2);
    assertThat(expression2.getValue()).isEqualTo(BigInteger.ONE);
    value2.setValue(BigInteger.valueOf(2));
    assertThat(expression2.getValue()).isEqualTo(BigInteger.valueOf(2));
    value.setValue(BigInteger.valueOf(256));
    assertThat(expression2.getValue()).isEqualTo(BigInteger.ONE);
    assertThat(expression.getValue()).isEqualTo(BigInteger.valueOf(2));

    BigIntegerExpression quotient = BigIntegerBinding.divideAll(value, expression, expression2);
    // 128 = 256 / 2 / 1
    assertThat(quotient.getValue()).isEqualTo(BigInteger.valueOf(128));
  }

}
