/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

import java.util.function.Supplier;

/// This interface gives read access to the [value][#get()] of an object.
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public abstract interface ReadableValue<V> extends Supplier<V> {

  /// @return the current value of this object. May be `null` unless otherwise stated.
  @Override
  V get();

  /// @return the value of [#get()] but in case this is `null` it will return
  ///         [#getFallbackSafeValue()]. So unless [#getFallbackSafeValue()] also returns `null` this
  ///         method a null-safe variant of [#get()].
  /// @see #getFallbackSafeValue()
  default V getSafe() {

    V value = get();
    if (value == null) {
      value = getFallbackSafeValue();
    }
    return value;
  }

  /// @return a neutral element to be used instead of `null` if supported for this type of value (e.g. "" for
  ///         [String], `0` for any kind of [Number], [Boolean#FALSE], empty collection, etc.).
  ///         May still be `null` for types that have no such neutral element.
  V getFallbackSafeValue();

  /// @return `true` if the value is empty, `false` otherwise. The value `null` is always considered
  ///         empty. Further, depending on the type of the value, also a non-`null` value can be considered empty
  ///         such as [empty strings][String#isEmpty()] or [empty collections][java.util.Collection#isEmpty()].
  default boolean isEmpty() {

    return (get() == null);
  }

  /// Null-safe access to [#get()].
  ///
  /// @param <T> type of the [value][#get()]
  /// @param value the [ReadableValue] to unwrap.
  /// @return the [value][#get()] of the [ReadableValue]. Will be `null` if the given
  ///         [ReadableValue] is `null` or its [value][#get()] is `null`.
  static <T> T get(ReadableValue<T> value) {

    if (value == null) {
      return null;
    }
    return value.get();
  }

  /// @return the [Class] reflecting the type of [value][#get()]. Even if the [value][#get()] is
  ///         `null` the property must support returning the value class.
  Class<V> getValueClass();

}
