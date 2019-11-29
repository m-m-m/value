/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.biginteger;

import java.math.BigInteger;

import io.github.mmm.value.observable.AbstractWritableObservableValue;

/**
 * Implementation of {@link BigIntegerExpression} for testing.
 */
public class BigIntegerExpressionMock extends AbstractWritableObservableValue<BigInteger>
    implements BigIntegerExpression, WritableBigIntegerValue {

  private BigInteger value;

  /**
   * The constructor.
   */
  public BigIntegerExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #get() value}.
   */
  public BigIntegerExpressionMock(BigInteger value) {

    super();
    this.value = value;
  }

  @Override
  protected BigInteger doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(BigInteger newValue) {

    this.value = newValue;
  }

}
