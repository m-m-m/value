/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number;

import io.github.mmm.value.WritableValue;

/**
 * {@link WritableValue} with {@link Number} {@link #getValue() value}.
 *
 * @param <N> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface WritableNumberValue<N extends Number> extends ReadableNumberValue<N>, WritableValue<N> {

  /**
   * @param value the new value as generic {@link Number} instance.
   */
  void setValueAsNumber(Number value);

}
