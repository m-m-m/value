/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.enumeration;

import io.github.mmm.value.observable.object.ReadableSimpleObjectValue;
import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link ReadableSimpleValue} with {@link Enum} {@link #get() value}.
 *
 * @param <E> type of {@link Enum} {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableEnumValue<E extends Enum<E>> extends ReadableSimpleObjectValue<E> {

  @Override
  default String getAsString() {

    E e = get();
    if (e == null) {
      return null;
    }
    return e.toString();
  }

  @Override
  default E getFallbackSafeValue() {

    Class<E> valueClass = getValueClass();
    if (valueClass == null) {
      return null;
    }
    E[] constants = valueClass.getEnumConstants();
    if (constants.length == 0) {
      return null;
    }
    return constants[0];
  }

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

}
