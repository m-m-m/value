/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

import java.util.Objects;

/**
 * Abstract base implementation of {@link WritableObservableValue} that handles bindings.
 *
 * @param <V> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AbstractWritableObservableValue<V> extends AbstractObservableValue<V>
    implements WritableObservableValue<V> {

  private ObservableValue<? extends V> binding;

  private BindingListener bindingListener;

  @Override
  public V getValue() {

    if (this.binding != null) {
      return this.binding.getValue();
    }
    return doGetValue();
  }

  /**
   * @return the internal {@link #getValue() value}.
   */
  protected abstract V doGetValue();

  @Override
  public void bind(ObservableValue<? extends V> observable) {

    Objects.requireNonNull(observable, "observable");
    if (!observable.equals(this.binding)) {
      requireWritable();
      unbind();
      bindInternal(observable);
    }
  }

  /**
   * Internal method of {@link #bind(ObservableValue)}. Do not call.
   *
   * @param observable the {@link ObservableValue} to bind.
   * @see #bind(ObservableValue)
   */
  protected void bindInternal(ObservableValue<? extends V> observable) {

    this.binding = observable;
    if (observable == null) {
      return;
    }
    if (this.bindingListener == null) {
      this.bindingListener = new BindingListener(this);
    }
    observable.addListener(this.bindingListener);
    fireEvent();
  }

  @Override
  public void unbind() {

    if (this.binding != null) {
      requireWritable();
      setValue(this.binding.getValue());
      this.binding.removeListener(this.bindingListener);
      this.binding = null;
      this.bindingListener = null;
    }
  }

  @Override
  public boolean isBound() {

    return (this.binding != null);
  }

  @Override
  public void bindBidirectional(WritableObservableValue<V> other) {

    BidirectionalBinding.bind(this, other);
  }

  @Override
  public void unbindBidirectional(WritableObservableValue<V> other) {

    BidirectionalBinding.unbind(this, other);
  }

  @Override
  public void setValue(V value) {

    requireWritable();
    V oldValue = doGetValue();
    if (!Objects.equals(oldValue, value)) {
      doSetValue(value);
      fireEventWithOldValue(oldValue);
    }
  }

  /**
   * @throws IllegalStateException if this property is not writable.
   */
  protected void requireWritable() throws IllegalStateException {

    if (isBound()) {
      throw new IllegalStateException(toString() + ": The value cannot be set if bound unidirectional.");
    }
  }

  /**
   * @param newValue the new {@link #getValue() value} to set.
   * @see #setValue(Object)
   */
  protected abstract void doSetValue(V newValue);

}
