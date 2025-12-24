/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bytes;

import org.junit.jupiter.api.Test;

import io.github.mmm.value.observable.number.NumberExpression;
import io.github.mmm.value.observable.number.NumberExpressionTest;

/**
 * Test of {@link ByteExpression}.
 */
@SuppressWarnings("javadoc")
public class ByteExpressionTest extends NumberExpressionTest<Byte> {

  private static final Byte ZERO = Byte.valueOf((byte) 0);

  private static final Byte ONE = Byte.valueOf((byte) 1);

  private static final Byte TEN = Byte.valueOf((byte) 10);

  @Override
  protected Class<Byte> getValueClass() {

    return Byte.class;
  }

  @Override
  protected Byte get(int i) {

    return Byte.valueOf((byte) i);
  }

  @Override
  protected NumberExpression<Byte> of(Byte value) {

    return new ByteExpressionMock(value);
  }

  @Test
  public void testAddCustom() {

    ByteExpressionMock value = new ByteExpressionMock();
    value.set(ONE);
    ByteExpression expression = value.expAdd((byte) 1).expAdd((byte) 6);
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 8));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 17));
    ByteExpressionMock value2 = new ByteExpressionMock();
    value2.set(ONE);
    ByteExpression expression2 = expression.expAdd(value2);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 18));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 27));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 18));

    ByteExpression sum = ByteBinding.addAll(value, expression, expression2);
    assertThat(sum.getValue()).isEqualTo(Byte.valueOf((byte) 27)); // 27 = 1 + 8 + 18
  }

  @Test
  public void testSubtractCustom() {

    ByteExpressionMock value = new ByteExpressionMock(Byte.valueOf((byte) 8));
    ByteExpression expression = value.expSub((byte) 1).expSub((byte) 7);
    assertThat(expression.getValue()).isEqualTo(ZERO);
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 2));
    ByteExpressionMock value2 = new ByteExpressionMock(ONE);
    ByteExpression expression2 = expression.expSub(value2);
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) -8)); // 2 - 10
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) -17));
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) -7));

    ByteExpression difference = ByteBinding.subtractAll(value, expression, expression2);
    assertThat(difference.getValue()).isEqualTo(Byte.valueOf((byte) 25)); // 25 = 1 - (-7) - (-17)
  }

  @Test
  public void testMultiplyCustom() {

    Byte two = Byte.valueOf((byte) 2);
    ByteExpressionMock value = new ByteExpressionMock(Byte.valueOf((byte) 4));
    ByteExpression expression = value.expMul((byte) 2).expMul((byte) 64);

    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 512));
    value.set(TEN);
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 1280));
    ByteExpressionMock value2 = new ByteExpressionMock(two);
    ByteExpression expression2 = expression.expMul(value2);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 2560));
    value2.set(TEN);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 12800));
    value.set(ONE);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 1280));
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 128));

    ByteExpression product = ByteBinding.multiplyAll(value, expression, expression2);
    assertThat(product.getValue()).isEqualTo(Byte.valueOf((byte) 163840)); // 163840 = 1 * 128 * 1280
  }

  @Test
  public void testDivideCustom() {

    ByteExpressionMock value = new ByteExpressionMock(Byte.valueOf((byte) 64));
    ByteExpression expression = value.expDiv((byte) 2);

    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 32));
    value.set(Byte.valueOf((byte) 32));
    assertThat(expression.getValue()).isEqualTo(Byte.valueOf((byte) 16));
    ByteExpressionMock value2 = new ByteExpressionMock(Byte.valueOf((byte) 2));
    ByteExpression expression2 = expression.expDiv(value2);
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 8));
    value2.set(Byte.valueOf((byte) 16));
    assertThat(expression2.getValue()).isEqualTo(ONE);
    value.set(Byte.valueOf((byte) 64));
    assertThat(expression2.getValue()).isEqualTo(Byte.valueOf((byte) 2));

    ByteExpression quotient = ByteBinding.divideAll(value, expression, expression2);
    // 1 = 64 / 32 / 2
    assertThat(quotient.getValue()).isEqualTo(Byte.valueOf((byte) 1));
  }

}
