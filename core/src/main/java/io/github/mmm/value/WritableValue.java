/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * A {@link WritableValue} wraps a {@link #getValue() value} that can be {@link #getValue() read} and
 * {@link #setValue(Object) set}. In general this interface should not be implemented directly but one of its
 * sub-interfaces.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface WritableValue<V> extends ReadableValue<V> {

  /**
   * @param value the new {@link #getValue() value}.
   */
  void setValue(V value);

}