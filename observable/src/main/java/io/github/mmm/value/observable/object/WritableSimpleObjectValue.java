/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.object;

/// [WritableSimpleValue] that is also a [WritableObjectValue].
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface WritableSimpleObjectValue<V> extends WritableSimpleValue<V>, WritableObjectValue<V> {

}
