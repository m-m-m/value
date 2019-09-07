/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number.bytes;

import net.sf.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Byte} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableByteValue extends ReadableByteValue, WritableNumberValue<Byte> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Byte)
   */
  default void set(byte value) {

    setValue(Byte.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Byte)) {
      setValue((Byte) value);
    } else {
      setValue(Byte.valueOf(value.byteValue()));
    }
  }

}
