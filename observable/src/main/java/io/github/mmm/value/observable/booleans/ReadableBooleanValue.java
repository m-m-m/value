/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.booleans;

import io.github.mmm.value.ReadableTypedValue;
import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link ReadableTypedValue} with {@link Boolean} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableBooleanValue extends ReadableSimpleValue<Boolean> {

  @Override
  default Class<Boolean> getValueClass() {

    return Boolean.class;
  }

  /**
   * @return the current value as primitive {@code boolean}.
   * @see #get()
   */
  default boolean getValue() {

    Boolean value = get();
    if (value == null) {
      return false;
    }
    return value.booleanValue();
  }

  @Override
  default Boolean getFallbackSafeValue() {

    return Boolean.FALSE;
  }

}
