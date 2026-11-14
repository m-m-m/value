/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.doubles;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/// [ReadableNumberValue] with [Double] [value][#get()].
///
/// @since 1.0.0
public interface ReadableDoubleValue extends ReadableNumberValue<Double> {

  @Override
  default Class<Double> getValueClass() {

    return Double.class;
  }

  /// @return the current value as primitive. Will be `0` if undefined.
  default double getValue() {

    return doubleValue();
  }

  @Override
  default Double getFallbackSafeValue() {

    return Double.valueOf(0);
  }

  @Override
  default Double parse(String value) {

    if (value == null) {
      return null;
    }
    return Double.valueOf(value);
  }

}
