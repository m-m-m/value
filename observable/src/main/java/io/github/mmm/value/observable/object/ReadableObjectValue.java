/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.ReadableValue;

/**
 * {@link ReadableValue} for {@link Object} {@link #get() value} that has no primitive type.
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface ReadableObjectValue<V> extends ReadableValue<V> {

  /**
   * Same as {@link #get()}.
   *
   * @return the current {@link #get() value}.
   */
  default V getValue() {

    return get();
  }

  @Override
  default V getSafe() {

    return get();
  }

}
