/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

import io.github.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableObjectValue} that is also a {@link ReadableTypedValue}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableTypedObjectValue<V> extends ReadableTypedValue<V>, ReadableObjectValue<V> {

}
