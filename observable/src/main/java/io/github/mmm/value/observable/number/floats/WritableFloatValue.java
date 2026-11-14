/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.floats;

import io.github.mmm.value.observable.number.WritableNumberValue;

/// [WritableNumberValue] with [Float] [value][#get()].
///
/// @since 1.0.0
public interface WritableFloatValue extends ReadableFloatValue, WritableNumberValue<Float> {

  @Override
  void set(Float value);

  /// @param value the new [primitive value][#getValue()].
  /// @see #set(Float)
  default void setValue(float value) {

    set(Float.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Float)) {
      set((Float) value);
    } else {
      set(Float.valueOf(value.floatValue()));
    }
  }

}
