/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * Interface for a valued path. May be a property itself, a reference on a property or a query criteria to match a
 * property.
 *
 * @param <V> type of the {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface PropertyPath<V> extends ReadableValue<V> {

  /**
   * @return the name of this path. May be a single property (e.g. "MyProperty") or a dot-separated path (e.g.
   *         "MyEntity.MyProperty").
   */
  String getName();

}
