package io.github.mmm.value.observable;

import io.github.mmm.value.WritableValue;

/// [ObservableValue] that is [writable][WritableValue] and allows to [set][#set(Object)] its value.
///
/// @param <V> type of the [value][#get()].
/// @since 1.0.0
public interface WritableObservableValue<V> extends ObservableValue<V>, WritableValue<V> {

  /// Creates a unidirection binding for this object.
  /// **ATTENTION:**
  /// An unidirectional binding is very strict. It makes this object to appear exactly as the [ObservableValue] it
  /// is bound to. After creating the unidirectional binding, calls to [#set(Object)] will fail. This is very
  /// different to an [bidirectional binding][#bindTwoWay(WritableObservableValue)].
  ///
  /// @param observable the [ObservableValue] this object should be bound to.
  /// @see #unbindOneWay()
  /// @see #isBoundOneWay()
  void bindOneWay(ObservableValue<? extends V> observable);

  /// Removes the [unidirectional binding][#bindOneWay(ObservableValue)] from this object. If this object is not
  /// [bound][#isBoundOneWay()], this method has no effect.
  ///
  /// @see #bindOneWay(ObservableValue)
  void unbindOneWay();

  /// @return `true` if this object is [bound][#bindOneWay(ObservableValue)], `false` otherwise.
  /// @see #bindOneWay(ObservableValue)
  boolean isBoundOneWay();

  /// Create a bidirectional binding between this object and the given one. After a bidirectional binding,
  /// [#set(Object)] on this object will propagate its value to the bound one and vice versa. Bidirectional
  /// bindings exists independently of [unidirectional bindings][#bindOneWay(ObservableValue)]. However, it is bad
  /// practice to combine both. It is possible to have multiple bidirectional bindings for the same object.
  ///
  /// @param other the other `WritableObservableValue` to bind bidirectional.
  /// @see #unbindTwoWay(WritableObservableValue)
  void bindTwoWay(WritableObservableValue<V> other);

  /// Removes a [bidirectional binding][#bindTwoWay(WritableObservableValue)] between this object and the
  /// given one. If no bidirectional binding between these objects exists, this method has no effect. It is possible to
  /// [unbind][#unbindTwoWay(WritableObservableValue)] in inverse order. So to unbind two
  /// [bidirectional bound][#bindTwoWay(WritableObservableValue)] objects it does not matter if you call
  /// [unbindBidirectional][#unbindTwoWay(WritableObservableValue)] on the first with the second as argument
  /// or vice versa.
  ///
  /// @param other the other `WritableObservableValue` to unbind bidirectional.
  /// @see #bindTwoWay(WritableObservableValue)
  void unbindTwoWay(WritableObservableValue<V> other);
}
