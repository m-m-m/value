/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.enumeration;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.object.ObservableSimpleValue;

/// [ObservableValue] with [Enum] [value][#getValue()].
///
/// @param <E> type of [Enum] [value][#getValue()].
/// @since 1.0.0
public interface ObservableEnumValue<E extends Enum<E>> extends ObservableSimpleValue<E>, ReadableEnumValue<E> {

}
