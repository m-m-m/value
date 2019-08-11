/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import java.util.function.Supplier;

/**
 * {@link Expression} that calculates its {@link #getValue() value} dynamically from other {@link ObservableValue}s
 * (dependencies).
 *
 * @param <V> type of the observable {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class Binding<V> extends AbstractObservableValue<V> implements Expression<V> {

  private boolean valid;

  private V value;

  private Supplier<? extends V> expression;

  private BindingListener observer;

  private ObservableValue<?>[] dependencies;

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public Binding(Supplier<? extends V> expression, ObservableValue<?>... dependencies) {

    super();
    this.expression = expression;
    this.valid = false;
    this.dependencies = dependencies;
    bind(dependencies);
  }

  /**
   * Start observing the dependencies for changes. If the value of one of the dependencies changes, the binding is
   * marked as invalid.
   *
   * @param observables the dependencies to observe
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  protected final void bind(ObservableValue<?>... observables) {

    if ((observables != null) && (observables.length > 0)) {
      if (this.observer == null) {
        this.observer = new BindingListener(this);
      }
      for (ObservableValue dependency : observables) {
        dependency.addListener(this.observer);
      }
    }
  }

  /**
   * Stop observing the dependencies for changes.
   *
   * @param observables the dependencies to stop observing
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  protected final void unbind(ObservableValue<?>... observables) {

    if (this.observer != null) {
      for (ObservableValue dependency : observables) {
        dependency.removeListener(this.observer);
      }
      this.observer = null;
    }
  }

  @Override
  public void dispose() {

    if (this.dependencies != null) {
      unbind(this.dependencies);
      this.dependencies = null;
    }
  }

  @Override
  public V getValue() {

    if ((this.dependencies != null) && (this.dependencies.length == 0)) {
      return this.expression.get();
    }
    if (!this.valid) {
      this.value = this.expression.get();
      this.valid = true;
    }
    return this.value;
  }

  @Override
  protected final void invalidate() {

    if (this.valid) {
      this.valid = false;
      fireEventOldValue(this.value);
    }
  }

  /**
   * @return {@code true} if the cached {@link #getValue() value} is still valid, {@code false} otherwise
   *         (re-calculation required).
   */
  protected final boolean isValid() {

    return this.valid;
  }

  @Override
  protected void toString(StringBuilder sb) {

    if (this.valid) {
      super.toString(sb);
    } else {
      sb.append("invalid");
    }
  }

}
