/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * Interface to {@link #path() read} a {@link #path()}.
 *
 * @since 1.0.0
 */
public interface ReadablePath {

  /**
   * This method gets the path of this object. It is not a regular getter to avoid conflicts with custom properties of
   * beans implementing this interface.
   *
   * @return the path of this object. May be a single property name (e.g. "MyProperty") or a dot-separated path (e.g.
   *         "MyEntity.MyProperty").
   */
  String path();

}
