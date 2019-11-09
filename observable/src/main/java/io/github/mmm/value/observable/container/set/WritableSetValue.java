/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.HashSet;
import java.util.Set;

import io.github.mmm.value.observable.container.collection.WritableCollectionValue;

/**
 * {@link WritableCollectionValue} for {@link Set} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link Set#contains(Object) elements}.
 * @since 1.0.0
 */
public interface WritableSetValue<E> extends WritableCollectionValue<Set<E>, E>, ReadableSetValue<E> {

  @Override
  default Set<E> getOrCreateValue() {

    Set<E> value = getValue();
    if (value == null) {
      value = new HashSet<>();
      setValue(value);
    }
    return value;
  }

}
