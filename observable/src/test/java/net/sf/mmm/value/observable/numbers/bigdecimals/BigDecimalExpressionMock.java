/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;

import net.sf.mmm.value.observable.AbstractWritableObservableValue;

/**
 * Implementation of {@link BigDecimalExpression} for testing.
 */
public class BigDecimalExpressionMock extends AbstractWritableObservableValue<BigDecimal>
    implements BigDecimalExpression, WritableBigDecimalValue {

  private BigDecimal value;

  @Override
  protected BigDecimal doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(BigDecimal newValue) {

    this.value = newValue;
  }

}
