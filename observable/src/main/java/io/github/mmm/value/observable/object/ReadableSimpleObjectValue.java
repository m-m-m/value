/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

/// [ReadableSimpleValue] that is also a [ReadableObjectValue].
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface ReadableSimpleObjectValue<V> extends ReadableSimpleValue<V>, ReadableObjectValue<V> {

}
