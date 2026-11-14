/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.bytes;

import io.github.mmm.value.observable.number.WritableNumberValue;

/// [WritableNumberValue] with [Byte] [value][#get()].
///
/// @since 1.0.0
public interface WritableByteValue extends ReadableByteValue, WritableNumberValue<Byte> {

  @Override
  void set(Byte value);

  /// @param value the new [primitive value][#get()].
  /// @see #set(Byte)
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
