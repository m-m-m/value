package net.sf.mmm.value.observable.container;

import net.sf.mmm.value.observable.ObservableValue;

/**
 * {@link ObservableValue} for container {@link #getValue() value}s.
 *
 * @param <C> type of the container {@link #getValue() value}.
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public interface ObservableContainerValue<C, E> extends ObservableValue<C>, ReadableContainerValue<C, E> {

}
