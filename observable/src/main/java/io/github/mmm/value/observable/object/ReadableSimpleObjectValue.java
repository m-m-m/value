/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

/**
 * {@link ReadableSimpleValue} that is also a {@link ReadableObjectValue}.
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface ReadableSimpleObjectValue<V> extends ReadableSimpleValue<V>, ReadableObjectValue<V> {

}
