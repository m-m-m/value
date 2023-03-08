/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.enumeration;

import io.github.mmm.value.WritableValue;
import io.github.mmm.value.observable.object.WritableSimpleValue;

/**
 * {@link WritableValue} with {@link Enum} {@link #getValue() value}.
 *
 * @param <E> type of {@link Enum} {@link #getValue() value}.
 * @since 1.0.0
 */
public interface WritableEnumValue<E extends Enum<E>> extends WritableSimpleValue<E>, ReadableEnumValue<E> {

  @Override
  default E parse(String value) {

    if (value == null) {
      return null;
    }
    for (E e : getValueClass().getEnumConstants()) {
      if (e.toString().equals(value)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Undefined constant '" + value + "' for enum " + getValueClass().getName());
  }

  /**
   * @param value the value to set.
   * @see #get()
   * @see #set(Object)
   */
  default void setValue(E value) {

    set(value);
  }

}
