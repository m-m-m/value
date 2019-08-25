/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import java.util.Set;

import net.sf.mmm.value.observable.containers.collections.ReadableChangeAwareCollectionValue;

/**
 * {@link ReadableChangeAwareCollectionValue} for {@link ChangeAwareSet} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link Set#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ReadableChangeAwareSetValue<E>
    extends ReadableChangeAwareCollectionValue<Set<E>, E>, ReadableSetValue<E> {

  @Override
  ChangeAwareSet<E> getValue();

  @Override
  default ChangeAwareSet<E> getValueSafe() {

    ChangeAwareSet<E> value = getValue();
    if (value == null) {
      value = ChangeAwareSets.empty();
    }
    return value;
  }

}
