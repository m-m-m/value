/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.number;

import net.sf.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableTypedValue} with {@link Number} {@link #getValue() value}.
 *
 * @param <N> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface ReadableNumberValue<N extends Number> extends ReadableTypedValue<N> {

  /**
   * @return the value converted to {@code int}. Will be {@code 0} if undefined.
   */
  default int intValue() {

    N value = getValue();
    if (value == null) {
      return 0;
    }
    return value.intValue();
  }

  /**
   * @return the value converted to {@code long}. Will be {@code 0} if undefined.
   */
  default long longValue() {

    N value = getValue();
    if (value == null) {
      return 0;
    }
    return value.longValue();
  }

  /**
   * @return the value converted to {@code float}. Will be {@code 0} if undefined.
   */
  default float floatValue() {

    N value = getValue();
    if (value == null) {
      return 0;
    }
    return value.floatValue();
  }

  /**
   * @return the value converted to {@code double}. Will be {@code 0} if undefined.
   */
  default double doubleValue() {

    N value = getValue();
    if (value == null) {
      return 0;
    }
    return value.doubleValue();
  }

  /**
   * @return the value converted to {@code short}. Will be {@code 0} if undefined.
   */
  default short shortValue() {

    N value = getValue();
    if (value == null) {
      return 0;
    }
    return value.shortValue();
  }

  /**
   * @return the value converted to {@code byte}. Will be {@code 0} if undefined.
   */
  default byte byteValue() {

    N value = getValue();
    if (value == null) {
      return 0;
    }
    return value.byteValue();
  }
}
