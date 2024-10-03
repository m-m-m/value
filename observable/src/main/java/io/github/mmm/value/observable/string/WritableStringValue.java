/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.string;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link WritableValue} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableStringValue extends WritableSimpleValue<String>, ReadableStringValue {

  @Override
  default void setAsString(String value) {

    set(value);
  }

  /**
   * @param value the value to set.
   * @see #get()
   * @see #set(String)
   */
  default void setValue(String value) {

    set(value);
  }

}
