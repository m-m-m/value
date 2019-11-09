/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bigdecimal;

import java.math.BigDecimal;

import io.github.mmm.value.observable.AbstractWritableObservableValue;
import io.github.mmm.value.observable.number.bigdecimal.BigDecimalExpression;
import io.github.mmm.value.observable.number.bigdecimal.WritableBigDecimalValue;

/**
 * Implementation of {@link BigDecimalExpression} for testing.
 */
public class BigDecimalExpressionMock extends AbstractWritableObservableValue<BigDecimal>
    implements BigDecimalExpression, WritableBigDecimalValue {

  private BigDecimal value;

  /**
   * The constructor.
   */
  public BigDecimalExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public BigDecimalExpressionMock(BigDecimal value) {

    super();
    this.value = value;
  }

  @Override
  protected BigDecimal doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(BigDecimal newValue) {

    this.value = newValue;
  }

}
