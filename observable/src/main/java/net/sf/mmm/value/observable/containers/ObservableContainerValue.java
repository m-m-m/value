package net.sf.mmm.value.observable.containers;

import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link ObservableValue} for container {@link #getValue() values}
 *
 * @param <V> the type of the container.
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public interface ObservableContainerValue<V, E> extends ObservableValue<V>, ReadableContainerValue<V> {

}
