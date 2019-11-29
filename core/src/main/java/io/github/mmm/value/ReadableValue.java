/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

import java.util.function.Supplier;

/**
 * This interface gives read access to the {@link #get() value} of an object.
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public abstract interface ReadableValue<V> extends Supplier<V> {

  /**
   * @return the current value of this object. May be {@code null} unless otherwise stated.
   */
  @Override
  V get();

  /**
   * @return the same as {@link #get()} but trying to avoid returning {@code null} where possible. So a neutral element
   *         is returned instead of {@code null} for each type supporting this (e.g. "" for {@link String}, {@code 0}
   *         for any kind of {@link Number}, {@link Boolean#FALSE}, empty collection, etc.).
   */
  V getSafe();

  /**
   * Null-safe access to {@link #get()}.
   *
   * @param <T> type of the {@link #get() value}
   * @param value the {@link ReadableValue} to unwrap.
   * @return the {@link #get() value} of the {@link ReadableValue}. Will be {@code null} if the given
   *         {@link ReadableValue} is {@code null} or its {@link #get() value} is {@code null}.
   */
  static <T> T get(ReadableValue<T> value) {

    if (value == null) {
      return null;
    }
    return value.get();
  }

}
