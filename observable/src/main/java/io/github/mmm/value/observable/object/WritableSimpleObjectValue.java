/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

/**
 * {@link WritableSimpleValue} that is also a {@link WritableObjectValue}.
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface WritableSimpleObjectValue<V> extends WritableSimpleValue<V>, WritableObjectValue<V> {

}
