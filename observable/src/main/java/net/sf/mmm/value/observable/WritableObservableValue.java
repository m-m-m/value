package net.sf.mmm.value.observable;

import net.sf.mmm.value.WritableValue;

/**
 * {@link ObservableValue} that is {@link WritableValue writable} and allows to {@link #setValue(Object) set} its value.
 *
 * @param <V> is the generic type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface WritableObservableValue<V> extends ObservableValue<V>, WritableValue<V> {

}
