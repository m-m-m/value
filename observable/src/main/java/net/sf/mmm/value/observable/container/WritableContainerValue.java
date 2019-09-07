/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container;

import net.sf.mmm.value.observable.object.WritableObjectValue;

/**
 * {@link WritableObjectValue} for container {@link #getValue() values} (e.g. {@link java.util.Collection} or
 * {@link java.util.Map}).
 *
 * @param <C> type of the container {@link #getValue() value}.
 * @param <E> type of the contained elements ({@link java.util.Collection#contains(Object) collection element} or
 *        {@link java.util.Map#containsValue(Object) map value}).
 * @since 1.0.0
 */
public interface WritableContainerValue<C, E> extends ReadableContainerValue<C, E>, WritableObjectValue<C> {

  /**
   * @return the current null-safe {@link #getValue() value}. Unlike {@link #getValueSafe()} this method will modify and
   *         initialize the {@link #getValue() value} with an empty mutable container if it was {@code null}.
   */
  C getOrCreateValue();

}
