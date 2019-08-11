package net.sf.mmm.value.observable;

import net.sf.mmm.value.WritableValue;

/**
 * {@link ObservableValue} that is {@link WritableValue writable} and allows to {@link #setValue(Object) set} its value.
 *
 * @param <V> is the generic type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface WritableObservableValue<V> extends ObservableValue<V>, WritableValue<V> {

  /**
   * Creates a unidirection binding for this object.<br>
   * <b>ATTENTION:</b><br>
   * An unidirectional binding is very strict. It makes this object to appear exactly as the {@link ObservableValue} it
   * is bound to. After creating the unidirectional binding, calls to {@link #setValue(Object)} will fail. This is very
   * different to an {@link #bindBidirectional(WritableObservableValue) bidirectional binding}.
   *
   * @param observable the {@link ObservableValue} this object should be bound to.
   * @see #unbind()
   * @see #isBound()
   */
  void bind(ObservableValue<? extends V> observable);

  /**
   * Removes the {@link #bind(ObservableValue) unidirectional binding} from this object. If this object is not
   * {@link #isBound() bound}, this method has no effect.
   *
   * @see #bind(ObservableValue)
   */
  void unbind();

  /**
   * @return {@code true} if this object is {@link #bind(ObservableValue) bound}, {@code false} otherwise.
   * @see #bind(ObservableValue)
   */
  boolean isBound();

  /**
   * Create a bidirectional binding between this object and the given one. After a bidirectional binding,
   * {@link #setValue(Object)} on this object will propagate its value to the bound one and vice versa. Bidirectional
   * bindings exists independently of {@link #bind(ObservableValue) unidirectional bindings}. However, it is bad
   * practice to combine both. It is possible to have multiple bidirectional bindings for the same object.
   *
   * @param other the other {@code WritableObservableValue} to bind bidirectional.
   * @see #unbindBidirectional(WritableObservableValue)
   */
  void bindBidirectional(WritableObservableValue<V> other);

  /**
   * Removes a {@link #bindBidirectional(WritableObservableValue) bidirectional binding} between this object and the
   * given one. If no bidirectional binding between these objects exists, this method has no effect. It is possible to
   * {@link #unbindBidirectional(WritableObservableValue) unbind} in inverse order. So to unbind two
   * {@link #bindBidirectional(WritableObservableValue) bidirectional bound} objects it does not matter if you call
   * {@link #unbindBidirectional(WritableObservableValue) unbindBidirectional} on the first with the second as argument
   * or vice versa.
   *
   * @param other the other {@code WritableObservableValue} to unbind bidirectional.
   * @see #bindBidirectional(WritableObservableValue)
   */
  void unbindBidirectional(WritableObservableValue<V> other);
}
