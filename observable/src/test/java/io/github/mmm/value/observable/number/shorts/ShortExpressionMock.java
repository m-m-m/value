/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.shorts;

import io.github.mmm.value.observable.AbstractWritableObservableValue;
import io.github.mmm.value.observable.number.shorts.ShortExpression;
import io.github.mmm.value.observable.number.shorts.WritableShortValue;

/**
 * Implementation of {@link ShortExpression} for testing.
 */
public class ShortExpressionMock extends AbstractWritableObservableValue<Short>
    implements ShortExpression, WritableShortValue {

  private Short value;

  /**
   * The constructor.
   */
  public ShortExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public ShortExpressionMock(Short value) {

    super();
    this.value = value;
  }

  @Override
  protected Short doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(Short newValue) {

    this.value = newValue;
  }

}
