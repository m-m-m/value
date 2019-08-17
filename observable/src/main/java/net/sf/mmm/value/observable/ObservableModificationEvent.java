/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 *
 */
public class ObservableModificationEvent<C> implements ObservableEvent<C> {

  private final Object change;

  /**
   * The constructor.
   *
   * @param change the {@link #getChange() change}.
   */
  public ObservableModificationEvent(Object change) {

    super();
    this.change = change;
  }

  @Override
  public ObservableValue<C> getObservable() {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public C getValue() {

    return null;
  }

  @Override
  public C getOldValue() {

    return null;
  }

  @Override
  public boolean hasOldValue() {

    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <M> M getChange() {

    return (M) this.change;
  }

}
