/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container;

import io.github.mmm.event.EventListener;

/// [EventListener] for [ContainerChange]s.
///
/// @param <C> type of the [change][ContainerChange].
/// @since 1.0.0
/// @see io.github.mmm.value.observable.ObservableEvent#getChange()
public interface ContainerChangeListener<C extends ContainerChange<?, ?>> extends EventListener<C> {

}
