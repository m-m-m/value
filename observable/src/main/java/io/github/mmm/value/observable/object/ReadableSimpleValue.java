/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.ReadableTypedValue;
import io.github.mmm.value.ReadableValue;

/**
 * {@link ReadableValue} for a simple datatype (and not a
 * {@link io.github.mmm.value.observable.container.ReadableContainerValue container value}).
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface ReadableSimpleValue<V> extends ReadableTypedValue<V> {

  /**
   * @return the {@link #get() value} as {@link String}.
   */
  default String getAsString() {

    V value = get();
    if (value == null) {
      return null;
    }
    return value.toString();
  }

}
