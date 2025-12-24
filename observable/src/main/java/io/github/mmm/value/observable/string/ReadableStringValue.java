/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.string;

import io.github.mmm.value.observable.object.ReadableSimpleObjectValue;

/**
 * {@link ReadableSimpleObjectValue} with {@link String} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ReadableStringValue extends ReadableSimpleObjectValue<String> {

  @Override
  default String getAsString() {

    return get();
  }

  @Override
  default String format(String value) {

    return value;
  }

  @Override
  default Class<String> getValueClass() {

    return String.class;
  }

  @Override
  default String getFallbackSafeValue() {

    return "";
  }

  @Override
  default String parse(String value) {

    return value;
  }

  @Override
  default boolean isEmpty() {

    String string = get();
    return (string == null) || string.isEmpty();
  }

}
