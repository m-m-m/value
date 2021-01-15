/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * Interface to {@link #path() read} and {@link #path(String) write} the {@link #path()}.
 *
 * @since 1.0.0
 */
public interface WritablePath extends ReadablePath {

  /**
   * This method sets the {@link #path()} of this object. It is not a regular setter to avoid conflicts with custom
   * properties of beans implementing this interface.
   *
   * @param path new value of {@link #path()}.
   * @return the old value of {@link #path()}.
   */
  String path(String path);

}
