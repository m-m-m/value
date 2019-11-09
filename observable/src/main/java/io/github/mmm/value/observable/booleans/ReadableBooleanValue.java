/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.booleans;

import io.github.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableTypedValue} with {@link Boolean} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableBooleanValue extends ReadableTypedValue<Boolean> {

  @Override
  default Class<Boolean> getValueClass() {

    return Boolean.class;
  }

  /**
   * @return the current value as primitive {@code boolean}.
   * @see #getValue()
   */
  default boolean get() {

    Boolean value = getValue();
    if (value == null) {
      return false;
    }
    return value.booleanValue();
  }

  @Override
  default Boolean getValueSafe() {

    Boolean value = getValue();
    if (value == null) {
      return Boolean.FALSE;
    }
    return value;
  }

}
