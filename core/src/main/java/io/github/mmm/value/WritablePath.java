/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

import java.util.function.Supplier;

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
   */
  void path(String path);

  /**
   * This method sets the {@link #path()} of this object as dynamic reference to the given {@link Supplier}. It is not a
   * regular setter to avoid conflicts with custom properties of beans implementing this interface.
   *
   * @param pathSupplier the {@link Supplier} that {@link Supplier#get() provides} the {@link #path()}.
   */
  void path(Supplier<String> pathSupplier);

}
