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
   * @return the value of {@link #get()} but in case this is {@code null} it will return
   *         {@link #getFallbackSafeValue()}. So unless {@link #getFallbackSafeValue()} also returns {@code null} this
   *         method a null-safe variant of {@link #get()}.
   * @see #getFallbackSafeValue()
   */
  default V getSafe() {

    V value = get();
    if (value == null) {
      value = getFallbackSafeValue();
    }
    return value;
  }

  /**
   * @return a neutral element to be used instead of {@code null} if supported for this type of value (e.g. "" for
   *         {@link String}, {@code 0} for any kind of {@link Number}, {@link Boolean#FALSE}, empty collection, etc.).
   *         May still be {@code null} for types that have no such neutral element.
   */
  V getFallbackSafeValue();

  /**
   * @return {@code true} if the value is empty, {@code false} otherwise. The value {@code null} is always considered
   *         empty. Further, depending on the type of the value, also a non-{@code null} value can be considered empty
   *         such as {@link String#isEmpty() empty strings} or {@link java.util.Collection#isEmpty() empty collections}.
   */
  default boolean isEmpty() {

    return (get() == null);
  }

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

  /**
   * @return the {@link Class} reflecting the type of {@link #get() value}. Even if the {@link #get() value} is
   *         {@code null} the property must support returning the value class.
   */
  Class<V> getValueClass();

}
