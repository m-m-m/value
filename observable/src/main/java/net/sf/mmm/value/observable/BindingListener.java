/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import java.lang.ref.WeakReference;

/**
 * This is an implementation of {@link ObservableEventListener} for an unidirectional binding.
 *
 * @since 1.0.0
 */
public class BindingListener implements ObservableEventListener<Object> {

  private final WeakReference<AbstractObservableValue<?>> weakReference;

  /**
   * The constructor.
   *
   * @param value the property to {@link WritableObservableValue#bind(ObservableValue) bind}.
   */
  public BindingListener(AbstractObservableValue<?> value) {

    this.weakReference = new WeakReference<>(value);
  }

  @Override
  public void onEvent(ObservableEvent<Object> event) {

    AbstractObservableValue<?> binding = this.weakReference.get();
    if (binding == null) {
      event.getObservable().removeListener(this);
    } else {
      binding.invalidate();
    }
  }

}
