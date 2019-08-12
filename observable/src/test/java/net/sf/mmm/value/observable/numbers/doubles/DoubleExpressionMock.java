/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.doubles;

import net.sf.mmm.value.observable.AbstractWritableObservableValue;

/**
 * Implementation of {@link DoubleExpression} for testing.
 */
public class DoubleExpressionMock extends AbstractWritableObservableValue<Double>
    implements DoubleExpression, WritableDoubleValue {

  private Double value;

  /**
   * The constructor.
   */
  public DoubleExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public DoubleExpressionMock(Double value) {

    super();
    this.value = value;
  }

  @Override
  protected Double doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(Double newValue) {

    this.value = newValue;
  }

}
