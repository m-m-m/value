/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers;

import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link ObservableValue} with {@link Number} {@link #getValue() value}.
 *
 * @param <N> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface ObservableNumberValue<N extends Number> extends ObservableValue<N>, ReadableNumberValue<N> {

}
