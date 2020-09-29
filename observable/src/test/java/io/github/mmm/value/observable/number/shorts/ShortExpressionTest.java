/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.shorts;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link ShortExpression}.
 */
@SuppressWarnings("javadoc")
public class ShortExpressionTest extends NumberExpressionTest<Short> {

  private static final Short ZERO = Short.valueOf((short) 0);

  private static final Short ONE = Short.valueOf((short) 1);

  private static final Short TEN = Short.valueOf((short) 10);

  @Override
  protected Class<Short> getValueClass() {

    return Short.class;
  }

  @Override
  protected Short get(int i) {

    return Short.valueOf((short) i);
  }

  @Override
  protected NumberExpression<Short> of(Short value) {

    return new ShortExpressionMock(value);
  }

  @Test
  public void testAddCustom() {

    ShortExpressionMock value = new ShortExpressionMock();
    value.set(ONE);
    ShortExpression expression = value.add((short) 1).add((byte) 6);
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 8));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 17));
    ShortExpressionMock value2 = new ShortExpressionMock();
    value2.set(ONE);
    ShortExpression expression2 = expression.add(value2);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 18));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 27));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 18));

    ShortExpression sum = ShortBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Short.valueOf((short) 27)); // 27 = 1 + 8 + 18
  }

  @Test
  public void testSubtractCustom() {

    ShortExpressionMock value = new ShortExpressionMock(Short.valueOf((short) 8));
    ShortExpression expression = value.subtract((short) 1).subtract((byte) 7);
    assertThat(expression.getValue()).isEqualTo(ZERO);
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 2));
    ShortExpressionMock value2 = new ShortExpressionMock(ONE);
    ShortExpression expression2 = expression.subtract(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) -8)); // 2 - 10
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) -17));
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) -7));

    ShortExpression difference = ShortBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Short.valueOf((short) 25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  public void testMultiplyCustom() {

    Short two = Short.valueOf((short) 2);
    ShortExpressionMock value = new ShortExpressionMock(Short.valueOf((short) 4));
    ShortExpression expression = value.multiply((short) 2).multiply((byte) 64);

    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 512));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 1280));
    ShortExpressionMock value2 = new ShortExpressionMock(two);
    ShortExpression expression2 = expression.multiply(value2);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 2560));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 12800));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 1280));
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 128));

    ShortExpression product = ShortBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Short.valueOf((short) 163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  public void testDivideCustom() {

    ShortExpressionMock value = new ShortExpressionMock(Short.valueOf((short) 4096));
    ShortExpression expression = value.divide((short) 2).divide((byte) 64);

    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 32));
    value.set(Short.valueOf((short) 512));
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 4));
    ShortExpressionMock value2 = new ShortExpressionMock(Short.valueOf((short) 4));
    ShortExpression expression2 = expression.divide(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(Short.valueOf((short) 2));
    assertThat(expression2.getValue()).isEqualTo(Short.valueOf((short) 2));
    value.set(Short.valueOf((short) 256));
    assertThat(expression2.getValue()).isEqualTo(ONE);
    assertThat(expression.getValue()).isEqualTo(Short.valueOf((short) 2));

    ShortExpression quotient = ShortBinding.divideAll(value, expression, expression2);
    // 128 = 256 / 2 / 1
    assertThat(quotient.getValue()).isEqualTo(Short.valueOf((short) 128));
  }

}
