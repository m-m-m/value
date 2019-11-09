/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.collection;

import io.github.mmm.value.observable.container.ContainerChangeListener;

/**
 * {@link ContainerChangeListener} for {@link CollectionChange}s.
 *
 * @param <C> type of the {@link CollectionChange change}.
 * @since 1.0.0
 * @see io.github.mmm.value.observable.ObservableEvent#getChange()
 */
public interface CollectionChangeListener<C extends CollectionChange<?, ?>> extends ContainerChangeListener<C> {

}
