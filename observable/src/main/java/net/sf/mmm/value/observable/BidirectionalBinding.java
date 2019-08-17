/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * {@link ObservableEventListener} for a bidirectional binding.
 *
 * @param <V> type of observed {@link ObservableValue#getValue() value}.
 */
public class BidirectionalBinding<V> implements ObservableEventListener<V> {

  private final WeakReference<WritableObservableValue<V>> propertyRef1;

  private final WeakReference<WritableObservableValue<V>> propertyRef2;

  private boolean updating;

  private int hashCode;

  private BidirectionalBinding(WritableObservableValue<V> property1, WritableObservableValue<V> property2) {

    super();
    this.propertyRef1 = new WeakReference<>(property1);
    this.propertyRef2 = new WeakReference<>(property2);
    this.updating = false;
    this.hashCode = Objects.hash(property1, property2);
  }

  @Override
  public void onEvent(ObservableEvent<V> event) {

    if (!this.updating && !event.isChange()) {
      ObservableValue<V> source = event.getObservable();
      WritableObservableValue<V> v1 = this.propertyRef1.get();
      WritableObservableValue<V> v2 = this.propertyRef2.get();
      if ((v1 == null) || (v2 == null)) {
        if (v1 != null) {
          v1.removeListener(this);
        }
        if (v2 != null) {
          v2.removeListener(this);
        }
      } else {
        try {
          this.updating = true;
          if (v1 == source) {
            v2.setValue(v1.getValue());
          } else {
            v1.setValue(v2.getValue());
          }
        } catch (RuntimeException e) {
          throw new RuntimeException("Bidirectional binding failed!", e);
        } finally {
          this.updating = false;
        }
      }
    }
  }

  @Override
  public boolean isMatchedUsingEquals() {

    return true;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == this) {
      return true;
    }
    Object p1 = this.propertyRef1.get();
    Object p2 = this.propertyRef2.get();
    if ((p1 == null) || (p2 == null)) {
      return false;
    }
    if (obj instanceof BidirectionalBinding) {
      BidirectionalBinding<?> other = (BidirectionalBinding<?>) obj;
      Object o1 = other.propertyRef1.get();
      Object o2 = other.propertyRef1.get();
      if ((o1 == null) || (o2 == null)) {
        return false;
      }
      if ((p1 == o1) && (p2 == o2)) {
        return true;
      }
      if ((p1 == o2) && (p2 == o1)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {

    return this.hashCode;
  }

  /**
   * @see WritableObservableValue#unbindBidirectional(WritableObservableValue)
   */
  public void unbind() {

    WritableObservableValue<V> property1 = this.propertyRef1.get();
    if (property1 != null) {
      property1.removeListener(this);
    }
    WritableObservableValue<V> property2 = this.propertyRef2.get();
    if (property2 != null) {
      property2.removeListener(this);
    }
  }

  private static <V> void checkProperties(WritableObservableValue<V> property1, WritableObservableValue<V> property2) {

    Objects.requireNonNull(property1, "property1");
    Objects.requireNonNull(property2, "property2");
    if (property1 == property2) {
      throw new IllegalArgumentException("Cannot bind property to itself!");
    }
  }

  /**
   * @param <V> type of observed {@link ObservableValue#getValue() value}.
   * @param property1 the first {@link WritableObservableValue} to bind.
   * @param property2 the second {@link WritableObservableValue} to bind.
   *
   * @return the {@link BidirectionalBinding}.
   * @see WritableObservableValue#bindBidirectional(WritableObservableValue)
   */
  public static <V> BidirectionalBinding<V> bind(WritableObservableValue<V> property1,
      WritableObservableValue<V> property2) {

    checkProperties(property1, property2);
    BidirectionalBinding<V> binding = new BidirectionalBinding<>(property1, property2);
    property1.setValue(property2.getValue());
    property1.addListener(binding);
    property2.addListener(binding);
    return binding;
  }

  /**
   * @param <V> type of observed {@link ObservableValue#getValue() value}.
   * @param property1 the first {@link WritableObservableValue} to unbind.
   * @param property2 the second {@link WritableObservableValue} to unbind.
   * @see WritableObservableValue#unbindBidirectional(WritableObservableValue)
   */
  public static <V> void unbind(WritableObservableValue<V> property1, WritableObservableValue<V> property2) {

    checkProperties(property1, property2);
    BidirectionalBinding<V> binding = new BidirectionalBinding<>(property1, property2);
    property1.removeListener(binding);
    property2.removeListener(binding);
  }
}
