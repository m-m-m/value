/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.object;

import net.sf.mmm.value.WritableValue;

/**
 * {@link WritableValue} for {@link Object} {@link #getValue() value} that has no primitive type.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface WritableObjectValue<V> extends ReadableObjectValue<V>, WritableValue<V> {

  /**
   * Same as {@link #setValue(Object)}.
   *
   * @param value the new value.
   */
  default void set(V value) {

    setValue(value);
  }

}
