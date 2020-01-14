package io.github.mmm.value.observable;

import io.github.mmm.value.WritableValue;

/**
 * {@link ObservableValue} that is {@link WritableValue writable} and allows to {@link #set(Object) set} its value.
 *
 * @param <V> type of the {@link #get() value}.
 * @since 1.0.0
 */
public interface WritableObservableValue<V> extends ObservableValue<V>, WritableValue<V> {

  /**
   * Creates a unidirection binding for this object.<br>
   * <b>ATTENTION:</b><br>
   * An unidirectional binding is very strict. It makes this object to appear exactly as the {@link ObservableValue} it
   * is bound to. After creating the unidirectional binding, calls to {@link #set(Object)} will fail. This is very
   * different to an {@link #bindTwoWay(WritableObservableValue) bidirectional binding}.
   *
   * @param observable the {@link ObservableValue} this object should be bound to.
   * @see #unbindOneWay()
   * @see #isBoundOneWay()
   */
  void bindOneWay(ObservableValue<? extends V> observable);

  /**
   * Removes the {@link #bindOneWay(ObservableValue) unidirectional binding} from this object. If this object is not
   * {@link #isBoundOneWay() bound}, this method has no effect.
   *
   * @see #bindOneWay(ObservableValue)
   */
  void unbindOneWay();

  /**
   * @return {@code true} if this object is {@link #bindOneWay(ObservableValue) bound}, {@code false} otherwise.
   * @see #bindOneWay(ObservableValue)
   */
  boolean isBoundOneWay();

  /**
   * Create a bidirectional binding between this object and the given one. After a bidirectional binding,
   * {@link #set(Object)} on this object will propagate its value to the bound one and vice versa. Bidirectional
   * bindings exists independently of {@link #bindOneWay(ObservableValue) unidirectional bindings}. However, it is bad
   * practice to combine both. It is possible to have multiple bidirectional bindings for the same object.
   *
   * @param other the other {@code WritableObservableValue} to bind bidirectional.
   * @see #unbindTwoWay(WritableObservableValue)
   */
  void bindTwoWay(WritableObservableValue<V> other);

  /**
   * Removes a {@link #bindTwoWay(WritableObservableValue) bidirectional binding} between this object and the
   * given one. If no bidirectional binding between these objects exists, this method has no effect. It is possible to
   * {@link #unbindTwoWay(WritableObservableValue) unbind} in inverse order. So to unbind two
   * {@link #bindTwoWay(WritableObservableValue) bidirectional bound} objects it does not matter if you call
   * {@link #unbindTwoWay(WritableObservableValue) unbindBidirectional} on the first with the second as argument
   * or vice versa.
   *
   * @param other the other {@code WritableObservableValue} to unbind bidirectional.
   * @see #bindTwoWay(WritableObservableValue)
   */
  void unbindTwoWay(WritableObservableValue<V> other);
}
