/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.longs;

import io.github.mmm.value.observable.AbstractWritableObservableValue;
import io.github.mmm.value.observable.number.longs.LongExpression;
import io.github.mmm.value.observable.number.longs.WritableLongValue;

/**
 * Implementation of {@link LongExpression} for testing.
 */
public class LongExpressionMock extends AbstractWritableObservableValue<Long>
    implements LongExpression, WritableLongValue {

  private Long value;

  /**
   * The constructor.
   */
  public LongExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public LongExpressionMock(Long value) {

    super();
    this.value = value;
  }

  @Override
  protected Long doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(Long newValue) {

    this.value = newValue;
  }

}
