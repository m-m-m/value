/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.shorts;

import io.github.mmm.value.observable.number.ReadableNumberValue;

/// [ReadableNumberValue] with [Short] [value][#get()].
///
/// @since 1.0.0
public interface ReadableShortValue extends ReadableNumberValue<Short> {

  @Override
  default Class<Short> getValueClass() {

    return Short.class;
  }

  /// @return the current value as primitive. Will be `0` if undefined.
  default short getValue() {

    return shortValue();
  }

  @Override
  default Short getFallbackSafeValue() {

    return Short.valueOf((short) 0);
  }

  @Override
  default Short parse(String value) {

    if (value == null) {
      return null;
    }
    return Short.valueOf(value);
  }
}
