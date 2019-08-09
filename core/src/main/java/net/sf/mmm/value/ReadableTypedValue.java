/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value;

/**
 * {@link ReadableValue} knowing its {@link #getValueClass() value class}.
 *
 * @param <V> is the generic type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableTypedValue<V> extends ReadableValue<V> {

  /**
   * @return the {@link Class} reflecting the type of {@link #getValue() values} that can be stored by this property.
   *         Even if the {@link #getValue() value} is {@code null} the property must support returning the property
   *         class.
   */
  Class<V> getValueClass();

}
