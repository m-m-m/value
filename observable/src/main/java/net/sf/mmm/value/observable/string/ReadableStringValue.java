/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.string;

import net.sf.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableTypedValue} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableStringValue extends ReadableTypedValue<String> {

  @Override
  default Class<String> getValueClass() {

    return String.class;
  }

  /**
   * @return the current value as primitive {@code boolean}.
   * @see #getValue()
   */
  default String get() {

    return getValue();
  }

  @Override
  default String getValueSafe() {

    final String value = getValue();
    return value == null ? "" : value;
  }

}
