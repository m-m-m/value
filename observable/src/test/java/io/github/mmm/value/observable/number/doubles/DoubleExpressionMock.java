/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.doubles;

import io.github.mmm.value.observable.AbstractWritableObservableValue;

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
  protected Double doGet() {

    return this.value;
  }

  @Override
  protected void doSet(Double newValue) {

    this.value = newValue;
  }

}
