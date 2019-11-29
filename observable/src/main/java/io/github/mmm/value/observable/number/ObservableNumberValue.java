/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number;

import io.github.mmm.value.observable.ObservableValue;

/**
 * {@link ObservableValue} with {@link Number} {@link #get() value}.
 *
 * @param <N> type of the observable {@link #get() value}.
 * @since 1.0.0
 */
public abstract interface ObservableNumberValue<N extends Number> extends ObservableValue<N>, ReadableNumberValue<N> {

}
