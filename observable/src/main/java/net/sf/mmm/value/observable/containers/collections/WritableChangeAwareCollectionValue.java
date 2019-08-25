/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.collections;

import java.util.Collection;

import net.sf.mmm.value.observable.containers.WritableChangeAwareContainerValue;

/**
 * {@link WritableCollectionValue} for {@link ChangeAwareCollection} {@link #getValue() value}s.
 *
 * @param <C> type of the {@link ChangeAwareCollection} {@link #getValue() value}.
 * @param <E> type of the {@link ChangeAwareCollection#contains(Object) elements}.
 * @since 1.0.0
 */
public interface WritableChangeAwareCollectionValue<C extends Collection<E>, E> extends WritableCollectionValue<C, E>,
    WritableChangeAwareContainerValue<C, E>, ReadableChangeAwareCollectionValue<C, E> {

}
