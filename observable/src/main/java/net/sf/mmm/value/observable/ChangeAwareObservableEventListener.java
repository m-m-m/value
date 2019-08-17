/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 * {@link ObservableEventListener} that is also {@link #isChangeAware() change aware}.
 *
 * @param <V> type of observed {@link ObservableValue#getValue() value}.
 * @since 1.0.0
 */
@FunctionalInterface
public interface ChangeAwareObservableEventListener<V> extends ObservableEventListener<V> {

  @Override
  default boolean isChangeAware() {

    return true;
  }

}
