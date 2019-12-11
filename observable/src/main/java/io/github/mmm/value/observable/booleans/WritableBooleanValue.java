/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.booleans;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link WritableValue} with {@link Boolean} {@link #getValue() value}.
 */
public interface WritableBooleanValue extends WritableSimpleValue<Boolean>, ReadableBooleanValue {

  /**
   * @param value the value to set.
   * @see #get()
   * @see #set(Boolean)
   */
  default void setValue(boolean value) {

    set(Boolean.valueOf(value));
  }

  @Override
  default Boolean parse(String value) {

    if (value == null) {
      return null;
    } else if ("true".equalsIgnoreCase(value)) {
      return Boolean.TRUE;
    } else if ("false".equalsIgnoreCase(value)) {
      return Boolean.FALSE;
    } else {
      throw new IllegalArgumentException(value);
    }
  }

}
