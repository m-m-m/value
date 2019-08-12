/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import java.util.Set;

import net.sf.mmm.value.observable.containers.collections.ReadableCollectionValue;

/**
 * {@link ReadableCollectionValue} for {@link Set} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link Set#contains(Object) elements}.
 * @since 1.0.0
 */
public interface ReadableSetValue<E> extends ReadableCollectionValue<Set<E>, E> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  default Class<Set<E>> getValueClass() {

    return (Class) Set.class;
  }

}
