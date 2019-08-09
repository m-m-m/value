/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.objects;

import net.sf.mmm.value.ReadableValue;

/**
 * {@link ReadableValue} for generic objects that do not have their own customer {@link ReadableValue} interface in this
 * library.
 *
 * @param <V> is the generic type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableObjectValue<V> extends ReadableValue<V> {

  /**
   * Same as {@link #getValue()}.
   *
   * @return the current {@link #getValue() value}.
   */
  default V get() {

    return getValue();
  }

  @Override
  default V getValueSafe() {

    return getValue();
  }

}
