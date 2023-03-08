/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.enumeration;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.object.ObservableSimpleValue;

/**
 * {@link ObservableValue} with {@link Enum} {@link #getValue() value}.
 *
 * @param <E> type of {@link Enum} {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ObservableEnumValue<E extends Enum<E>> extends ObservableSimpleValue<E>, ReadableEnumValue<E> {

}
