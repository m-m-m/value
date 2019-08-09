/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value;

/**
 * Interface for a typed path.
 *
 * @param <V> the generic type of the property value identified by this path.
 *
 * @author hohwille
 * @since 1.0.0
 */
public interface PropertyPath<V> extends ReadableValue<V> {

  /**
   * @return the name what is the {@link String} representation of this path. May be a single property (e.g.
   *         "MyProperty") or a dot-separated path (e.g. "MyEntity.MyProperty").
   */
  String getName();

}
