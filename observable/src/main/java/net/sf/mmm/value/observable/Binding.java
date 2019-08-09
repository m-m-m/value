/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 * {@link ObservableValue} that calculates its {@link #getValue() value} dynamically from other {@link ObservableValue}s
 * (dependencies).
 *
 * @param <V> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public interface Binding<V> extends ObservableValue<V> {

  /**
   * Called if this {@code Binding} will not be used anymore and any references can be removed. Any
   * {@link ObservableEventListener} {@link ObservableValue#addListener(net.sf.mmm.event.EventListener) added} to
   * dependent {@link ObservableValue}s will be {@link ObservableValue#removeListener(net.sf.mmm.event.EventListener)
   * removed}.
   */
  void dispose();

}
