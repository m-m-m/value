package io.github.mmm.value.observable.container;

import io.github.mmm.value.observable.ObservableValue;

/// [ObservableValue] for container [value][#get()]s.
///
/// @param <C> type of the container [value][#get()].
/// @param <E> the type of the elements in the container.
/// @since 1.0.0
public interface ObservableContainerValue<C, E> extends ObservableValue<C>, ReadableContainerValue<C, E> {

}
