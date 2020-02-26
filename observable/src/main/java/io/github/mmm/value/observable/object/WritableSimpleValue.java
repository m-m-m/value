/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.WritableValue;

/**
 * {@link WritableValue} for a simple datatype (and not a
 * {@link io.github.mmm.value.observable.container.ReadableContainerValue container value}).
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface WritableSimpleValue<V> extends ReadableSimpleValue<V>, WritableValue<V> {

  /**
   * @param valueAsString the value as {@link String}. May be {@code null}.
   * @return the parsed {@code value}. May be {@code null} (e.g. if the given {@link String} is {@code null}).
   */
  V parse(String valueAsString);

  /**
   * @param value
   */
  default void setAsString(String value) {

    set(parse(value));
  }

}
