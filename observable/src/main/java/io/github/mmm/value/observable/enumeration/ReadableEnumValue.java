/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.enumeration;

import io.github.mmm.value.ReadableTypedValue;
import io.github.mmm.value.observable.object.ReadableSimpleValue;

/**
 * {@link ReadableTypedValue} with {@link Enum} {@link #get() value}.
 *
 * @param <E> type of {@link Enum} {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableEnumValue<E extends Enum<E>> extends ReadableSimpleValue<E> {

  @Override
  default String getAsString() {

    E e = get();
    if (e == null) {
      return null;
    }
    return e.toString();
  }

  /**
   * Same as {@link #get()}.
   *
   * @return the current {@link #get() value}.
   */
  default E getValue() {

    return get();
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

}
