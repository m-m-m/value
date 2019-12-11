/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bytes;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Byte} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface WritableByteValue extends ReadableByteValue, WritableNumberValue<Byte> {

  @Override
  default Byte parse(String value) {

    if (value == null) {
      return null;
    }
    return Byte.valueOf(value);
  }

  /**
   * @param value the new {@link #get() primitive value}.
   * @see #set(Byte)
   */
  default void setValue(byte value) {

    set(Byte.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Byte)) {
      set((Byte) value);
    } else {
      set(Byte.valueOf(value.byteValue()));
    }
  }

}
