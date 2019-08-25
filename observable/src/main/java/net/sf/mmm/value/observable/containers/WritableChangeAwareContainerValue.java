/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers;

/**
 * {@link WritableContainerValue} for {@link ChangeAwareContainer} {@link #getValue() values} (e.g.
 * {@link net.sf.mmm.value.observable.containers.collections.ChangeAwareCollection} or
 * {@link net.sf.mmm.value.observable.containers.maps.ChangeAwareMap}).
 *
 * @param <C> type of the container {@link #getValue() value}.
 * @param <E> type of the contained elements ({@link java.util.Collection#contains(Object) collection element} or
 *        {@link java.util.Map#containsValue(Object) map value}).
 * @since 1.0.0
 */
public interface WritableChangeAwareContainerValue<C, E>
    extends ReadableChangeAwareContainerValue<C, E>, WritableContainerValue<C, E> {

}
