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
   * @param valueAsString the {@link #get() value} as {@link #format(Object) string representation}.
   * @return the parsed value.
   * @see #getAsString()
   */
  default V setAsString(String valueAsString) {

    V value = parse(valueAsString);
    set(value);
    return value;
  }

}
