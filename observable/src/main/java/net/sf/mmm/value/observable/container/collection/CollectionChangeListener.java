/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.collection;

import net.sf.mmm.value.observable.container.ContainerChangeListener;

/**
 * {@link ContainerChangeListener} for {@link CollectionChange}s.
 *
 * @param <C> type of the {@link CollectionChange change}.
 * @since 1.0.0
 * @see net.sf.mmm.value.observable.ObservableEvent#getChange()
 */
public interface CollectionChangeListener<C extends CollectionChange<?, ?>> extends ContainerChangeListener<C> {

}
