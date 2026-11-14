/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/// A [WritableValue] wraps a [value][#get()] that can be [read][#get()] and [set][#set(Object)]. In general this interface should not be implemented directly but one of its sub-interfaces.
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface WritableValue<V> extends ReadableValue<V> {

  /// @param value the new [value][#get()].
  void set(V value);

}