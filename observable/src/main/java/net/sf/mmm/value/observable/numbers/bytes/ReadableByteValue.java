/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bytes;

import net.sf.mmm.value.observable.numbers.ReadableNumberValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link Byte} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableByteValue extends ReadableNumberValue<Byte> {

  @Override
  default Class<Byte> getValueClass() {

    return Byte.class;
  }

  /**
   * @return the current value as primitive. Will be {@code 0} if undefined.
   */
  default byte get() {

    return byteValue();
  }

  @Override
  default Byte getValueSafe() {

    Byte value = getValue();
    if (value == null) {
      return Byte.valueOf((byte) 0);
    }
    return value;
  }
}
