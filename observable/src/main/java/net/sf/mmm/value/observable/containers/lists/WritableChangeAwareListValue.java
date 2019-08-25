/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.collections.WritableChangeAwareCollectionValue;

/**
 * {@link WritableChangeAwareCollectionValue} for {@link ChangeAwareList} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link List#contains(Object) elements}.
 * @since 1.0.0
 */
public interface WritableChangeAwareListValue<E> extends WritableListValue<E>, ReadableChangeAwareListValue<E> {

  @Override
  default ChangeAwareList<E> getOrCreateValue() {

    ChangeAwareList<E> value = getValue();
    if (value == null) {
      value = ChangeAwareLists.of();
      setValue(value);
    }
    return value;
  }

}
