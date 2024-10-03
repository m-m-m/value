/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.booleans;

import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link ReadableSimpleValue} with {@link Boolean} {@link #get() value}.
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
