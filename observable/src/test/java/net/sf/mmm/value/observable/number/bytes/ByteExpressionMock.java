/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number.bytes;

import net.sf.mmm.value.observable.AbstractWritableObservableValue;
import net.sf.mmm.value.observable.number.bytes.ByteExpression;
import net.sf.mmm.value.observable.number.bytes.WritableByteValue;

/**
 * Implementation of {@link ByteExpression} for testing.
 */
public class ByteExpressionMock extends AbstractWritableObservableValue<Byte>
    implements ByteExpression, WritableByteValue {

  private Byte value;

  /**
   * The constructor.
   */
  public ByteExpressionMock() {

    super();
  }

  /**
   * The constructor.
   *
   * @param value the initial {@link #getValue() value}.
   */
  public ByteExpressionMock(Byte value) {

    super();
    this.value = value;
  }

  @Override
  protected Byte doGetValue() {

    return this.value;
  }

  @Override
  protected void doSetValue(Byte newValue) {

    this.value = newValue;
  }

}
