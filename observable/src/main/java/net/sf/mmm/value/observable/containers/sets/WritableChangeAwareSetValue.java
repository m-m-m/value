/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import java.util.Set;

import net.sf.mmm.value.observable.containers.collections.WritableChangeAwareCollectionValue;

/**
 * {@link WritableChangeAwareCollectionValue} for {@link ChangeAwareSet} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link ChangeAwareSet#contains(Object) elements}.
 * @since 1.0.0
 */
public interface WritableChangeAwareSetValue<E>
    extends WritableChangeAwareCollectionValue<Set<E>, E>, WritableSetValue<E>, ReadableChangeAwareSetValue<E> {

  @Override
  default ChangeAwareSet<E> getOrCreateValue() {

    ChangeAwareSet<E> value = getValue();
    if (value == null) {
      value = ChangeAwareSets.of();
      setValue(value);
    }
    return value;
  }

}
