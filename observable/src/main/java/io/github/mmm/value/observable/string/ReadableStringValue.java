/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.string;

import io.github.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableTypedValue} with {@link String} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableStringValue extends ReadableTypedValue<String> {

  @Override
  default Class<String> getValueClass() {

    return String.class;
  }

  /**
   * Same as {@link #get()}.
   *
   * @return the current {@link #get() value}.
   */
  default String getValue() {

    return get();
  }

  @Override
  default String getSafe() {

    final String value = get();
    return value == null ? "" : value;
  }

}
