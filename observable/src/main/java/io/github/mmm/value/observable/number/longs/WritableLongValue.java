/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.longs;

import io.github.mmm.value.observable.number.WritableNumberValue;

/// [WritableNumberValue] with [Long] [value][#get()].
///
/// @since 1.0.0
public interface WritableLongValue extends ReadableLongValue, WritableNumberValue<Long> {

  @Override
  void set(Long value);

  /// @param value the new [primitive value][#getValue()].
  /// @see #set(Long)
  default void setValue(long value) {

    set(Long.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Long)) {
      set((Long) value);
    } else {
      set(Long.valueOf(value.longValue()));
    }
  }
}
