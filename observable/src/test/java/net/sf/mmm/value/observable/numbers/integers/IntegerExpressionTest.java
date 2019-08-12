/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.integers;

import net.sf.mmm.value.observable.numbers.NumberExpression;
import net.sf.mmm.value.observable.numbers.NumberExpressionTest;

import org.junit.jupiter.api.Test;

/**
 * Test of {@link IntegerExpression}.
 */
@SuppressWarnings("javadoc")
public class IntegerExpressionTest extends NumberExpressionTest<Integer> {

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
  public void testAddCustom() {

    IntegerExpressionMock value = new IntegerExpressionMock();
    value.setValue(ONE);
    IntegerExpression expression = value.add(1).add((short) 1).add((byte) 5);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(8));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(17));
    IntegerExpressionMock value2 = new IntegerExpressionMock();
    value2.setValue(ONE);
    IntegerExpression expression2 = expression.add(value2);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(18));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(27));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(18));

    IntegerExpression sum = IntegerBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Integer.valueOf(27)); // 27 = 1 + 8 + 18
  }

  @Test
  public void testSubtractCustom() {

    IntegerExpressionMock value = new IntegerExpressionMock(Integer.valueOf(8));
    IntegerExpression expression = value.subtract(1).subtract((short) 1).subtract((byte) 6);
    assertThat(expression.getValue()).isEqualTo(ZERO);
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(2));
    IntegerExpressionMock value2 = new IntegerExpressionMock(ONE);
    IntegerExpression expression2 = expression.subtract(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(-8)); // 2 - 10
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(-17));
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(-7));

    IntegerExpression difference = IntegerBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Integer.valueOf(25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  public void testMultiplyCustom() {

    Integer two = Integer.valueOf(2);
    IntegerExpressionMock value = new IntegerExpressionMock(Integer.valueOf(4));
    IntegerExpression expression = value.multiply(2).multiply((short) 2).multiply((byte) 32);

    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(512));
    value.setValue(TEN);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(1280));
    IntegerExpressionMock value2 = new IntegerExpressionMock(two);
    IntegerExpression expression2 = expression.multiply(value2);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(2560));
    value2.setValue(TEN);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(12800));
    value.setValue(ONE);
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(1280));
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(128));

    IntegerExpression product = IntegerBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Integer.valueOf(163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  public void testDivideCustom() {

    IntegerExpressionMock value = new IntegerExpressionMock(Integer.valueOf(4096));
    IntegerExpression expression = value.divide(2).divide((short) 2).divide((byte) 32);

    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(32));
    value.setValue(Integer.valueOf(512));
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(4));
    IntegerExpressionMock value2 = new IntegerExpressionMock(Integer.valueOf(4));
    IntegerExpression expression2 = expression.divide(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.setValue(Integer.valueOf(2));
    assertThat(expression2.getValue()).isEqualTo(Integer.valueOf(2));
    value.setValue(Integer.valueOf(256));
    assertThat(expression2.getValue()).isEqualTo(ONE);
    assertThat(expression.getValue()).isEqualTo(Integer.valueOf(2));

    IntegerExpression quotient = IntegerBinding.divideAll(value, expression, expression2);
    // 128 = 256 / 2 / 1
    assertThat(quotient.getValue()).isEqualTo(Integer.valueOf(128));
  }

}
