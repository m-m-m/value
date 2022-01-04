/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * Interface to {@link #path() read} and {@link #pathSegment(String) write} the {@link #path()}.
 *
 * @since 1.0.0
 */
public interface WritablePath extends ReadablePath {

  /**
   * This method is not a regular setter to avoid conflicts with custom properties of beans implementing this interface.
   *
   * @param pathSegment new value of {@link #pathSegment()}.
   */
  void pathSegment(String pathSegment);

  /**
   * This method is not a regular setter to avoid conflicts with custom properties of beans implementing this interface.
   *
   * @param parentPath new value of {@link #parentPath()}.
   */
  void parentPath(ReadablePath parentPath);

}
