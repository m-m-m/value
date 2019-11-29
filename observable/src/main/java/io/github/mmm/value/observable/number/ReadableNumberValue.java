/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number;

import io.github.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableTypedValue} with {@link Number} {@link #get() value}.
 *
 * @param <N> type of the observable {@link #get() value}.
 * @since 1.0.0
 */
public abstract interface ReadableNumberValue<N extends Number> extends ReadableTypedValue<N> {

  /**
   * @return the value converted to {@code int}. Will be {@code 0} if undefined.
   */
  default int intValue() {

    N value = get();
    if (value == null) {
      return 0;
    }
    return value.intValue();
  }

  /**
   * @return the value converted to {@code long}. Will be {@code 0} if undefined.
   */
  default long longValue() {

    N value = get();
    if (value == null) {
      return 0;
    }
    return value.longValue();
  }

  /**
   * @return the value converted to {@code float}. Will be {@code 0} if undefined.
   */
  default float floatValue() {

    N value = get();
    if (value == null) {
      return 0;
    }
    return value.floatValue();
  }

  /**
   * @return the value converted to {@code double}. Will be {@code 0} if undefined.
   */
  default double doubleValue() {

    N value = get();
    if (value == null) {
      return 0;
    }
    return value.doubleValue();
  }

  /**
   * @return the value converted to {@code short}. Will be {@code 0} if undefined.
   */
  default short shortValue() {

    N value = get();
    if (value == null) {
      return 0;
    }
    return value.shortValue();
  }

  /**
   * @return the value converted to {@code byte}. Will be {@code 0} if undefined.
   */
  default byte byteValue() {

    N value = get();
    if (value == null) {
      return 0;
    }
    return value.byteValue();
  }
}
