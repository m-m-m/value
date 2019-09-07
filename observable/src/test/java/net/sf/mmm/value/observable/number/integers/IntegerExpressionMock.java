/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number.integers;

import net.sf.mmm.value.observable.AbstractWritableObservableValue;
import net.sf.mmm.value.observable.number.integers.IntegerExpression;
import net.sf.mmm.value.observable.number.integers.WritableIntegerValue;

/**
 * Implementation of {@link IntegerExpression} for testing.
 */
public class IntegerExpressionMock extends AbstractWritableObservableValue<Integer>
    implements IntegerExpression, WritableIntegerValue {

  private Integer value;

  /**
   * The constructor.
   */
  public IntegerExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public IntegerExpressionMock(Integer value) {

    super();
    this.value = value;
  }

  @Override
  protected Integer doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(Integer newValue) {

    this.value = newValue;
  }

}
