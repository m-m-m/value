/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.floats;

import io.github.mmm.value.observable.AbstractWritableObservableValue;
import io.github.mmm.value.observable.number.floats.FloatExpression;
import io.github.mmm.value.observable.number.floats.WritableFloatValue;

/**
 * Implementation of {@link FloatExpression} for testing.
 */
public class FloatExpressionMock extends AbstractWritableObservableValue<Float>
    implements FloatExpression, WritableFloatValue {

  private Float value;

  /**
   * The constructor.
   */
  public FloatExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public FloatExpressionMock(Float value) {

    super();
    this.value = value;
  }

  @Override
  protected Float doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(Float newValue) {

    this.value = newValue;
  }

}
