/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.doubles;

import io.github.mmm.value.observable.number.WritableNumberValue;

/// [WritableNumberValue] with [Double] [value][#get()].
///
/// @since 1.0.0
public interface WritableDoubleValue extends ReadableDoubleValue, WritableNumberValue<Double> {

  @Override
  void set(Double value);

  /// @param value the new [primitive value][#getValue()].
  /// @see #set(Double)
  default void setValue(double value) {

    set(Double.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Double)) {
      set((Double) value);
    } else {
      set(Double.valueOf(value.doubleValue()));
    }
  }

}
