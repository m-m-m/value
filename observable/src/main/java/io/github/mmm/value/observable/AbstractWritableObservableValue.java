/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable;

import java.util.Objects;

/**
 * Abstract base implementation of {@link WritableObservableValue} that handles bindings.
 *
 * @param <V> type of the observable {@link #get() value}.
 * @since 1.0.0
 */
public abstract class AbstractWritableObservableValue<V> extends AbstractObservableValue<V>
    implements WritableObservableValue<V> {

  private ObservableValue<? extends V> binding;

  private BindingListener bindingListener;

  @Override
  public V get() {

    if (this.binding != null) {
      return this.binding.get();
    }
    return doGet();
  }

  /**
   * @return the internal {@link #get() value}.
   */
  protected abstract V doGet();

  @Override
  public void bindOneWay(ObservableValue<? extends V> observable) {

    Objects.requireNonNull(observable, "observable");
    if (!observable.equals(this.binding)) {
      requireWritable();
      unbindOneWay();
      bindInternal(observable);
    }
  }

  /**
   * Internal method of {@link #bindOneWay(ObservableValue)}. Do not call.
   *
   * @param observable the {@link ObservableValue} to bind.
   * @see #bindOneWay(ObservableValue)
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
  public void unbindOneWay() {

    if (this.binding != null) {
      requireWritable();
      set(this.binding.get());
      this.binding.removeListener(this.bindingListener);
      this.binding = null;
      this.bindingListener = null;
    }
  }

  @Override
  public boolean isBoundOneWay() {

    return (this.binding != null);
  }

  @Override
  public void bindTwoWay(WritableObservableValue<V> other) {

    BidirectionalBinding.bind(this, other);
  }

  @Override
  public void unbindTwoWay(WritableObservableValue<V> other) {

    BidirectionalBinding.unbind(this, other);
  }

  @Override
  public void set(V value) {

    requireWritable();
    V oldValue = doGet();
    if (!isValueEqual(value, oldValue)) {
      setWithChange(oldValue, value);
    }
  }

  /**
   * Null-safe check if two {@link #get() values} are considered equal (unchanged).
   *
   * @param newValue the new value.
   * @param oldValue the old value.
   * @return {@code true} if equal (unchanged), {@code false} otherwise (changed),
   */
  protected boolean isValueEqual(V newValue, V oldValue) {

    return Objects.equals(oldValue, newValue);
  }

  /**
   * Internal method called from {@link #set(Object)} if the value actually changed.
   *
   * @param oldValue the old value.
   * @param value the new value.
   */
  protected void setWithChange(V oldValue, V value) {

    doSet(value);
    fireEventWithOldValue(oldValue);
  }

  /**
   * @throws IllegalStateException if this property is not writable.
   */
  protected void requireWritable() throws IllegalStateException {

    if (isBoundOneWay()) {
      throw new IllegalStateException(toString() + ": The value cannot be set if bound unidirectional.");
    }
  }

  /**
   * @param newValue the new {@link #get() value} to set.
   * @see #set(Object)
   */
  protected abstract void doSet(V newValue);

}
