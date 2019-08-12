/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.shorts;

import net.sf.mmm.value.observable.AbstractWritableObservableValue;

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
