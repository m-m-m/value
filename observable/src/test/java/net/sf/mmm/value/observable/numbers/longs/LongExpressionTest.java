/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.longs;

import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.NumberExpressionTest;

import org.junit.jupiter.api.Test;

/**
 * Test of {@link LongExpression}.
 */
@SuppressWarnings("javadoc")
public class LongExpressionTest extends NumberExpressionTest<Long> {

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
  public void testAddCustom() {

    LongExpressionMock value = new LongExpressionMock();
    value.setValue(ONE);
    LongExpression expression = value.add(1L).add(1).add((short) 1).add((byte) 4);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(8));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(17));
    LongExpressionMock value2 = new LongExpressionMock();
    value2.setValue(ONE);
    LongExpression expression2 = expression.add(value2);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(18));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(27));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(18));

    LongExpression sum = LongBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Long.valueOf(27)); // 27 = 1 + 8 + 18
  }

  @Test
  public void testSubtractCustom() {

    LongExpressionMock value = new LongExpressionMock(Long.valueOf(8));
    LongExpression expression = value.subtract(1L).subtract(1).subtract((short) 1).subtract((byte) 5);
    assertThat(expression.getValue()).isEqualTo(ZERO);
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(2));
    LongExpressionMock value2 = new LongExpressionMock(ONE);
    LongExpression expression2 = expression.subtract(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(-8)); // 2 - 10
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(-17));
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(-7));

    LongExpression difference = LongBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Long.valueOf(25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  public void testMultiplyCustom() {

    Long two = Long.valueOf(2);
    LongExpressionMock value = new LongExpressionMock(Long.valueOf(4));
    LongExpression expression = value.multiply(2L).multiply(2).multiply((short) 2).multiply((byte) 16);

    assertThat(expression.getValue()).isEqualTo(Long.valueOf(512));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(1280));
    LongExpressionMock value2 = new LongExpressionMock(two);
    LongExpression expression2 = expression.multiply(value2);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(2560));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(12800));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(1280));
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(128));

    LongExpression product = LongBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Long.valueOf(163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  public void testDivideCustom() {

    LongExpressionMock value = new LongExpressionMock(Long.valueOf(4096));
    LongExpression expression = value.divide(2L).divide(2).divide((short) 2).divide((byte) 16);

    assertThat(expression.getValue()).isEqualTo(Long.valueOf(32));
    value.setValue(Long.valueOf(512));
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(4));
    LongExpressionMock value2 = new LongExpressionMock(Long.valueOf(4));
    LongExpression expression2 = expression.divide(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.setValue(Long.valueOf(2));
    assertThat(expression2.getValue()).isEqualTo(Long.valueOf(2));
    value.setValue(Long.valueOf(256));
    assertThat(expression2.getValue()).isEqualTo(ONE);
    assertThat(expression.getValue()).isEqualTo(Long.valueOf(2));

    LongExpression quotient = LongBinding.divideAll(value, expression, expression2);
    // 128 = 256 / 2 / 1
    assertThat(quotient.getValue()).isEqualTo(Long.valueOf(128));
  }

}
