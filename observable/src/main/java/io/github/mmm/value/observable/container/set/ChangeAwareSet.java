/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.Set;

import io.github.mmm.value.observable.container.collection.ChangeAwareCollection;

/**
 * {@link io.github.mmm.value.observable.container.ChangeAwareContainer} that is a {@link Set}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public interface ChangeAwareSet<E>
    extends ChangeAwareCollection<E, SetChange<E>, SetChangeListener<E>>, Set<E> {

}
