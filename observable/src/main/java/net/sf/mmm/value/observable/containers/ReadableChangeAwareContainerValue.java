/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers;

/**
 * {@link ReadableContainerValue} for {@link ChangeAwareContainer} {@link #getValue() values} (e.g.
 * {@link net.sf.mmm.value.observable.containers.collections.ChangeAwareCollection} or
 * {@link net.sf.mmm.value.observable.containers.maps.ChangeAwareMap}).
 *
 * @param <C> type of the container {@link #getValue() value}.
 * @param <E> type of the contained elements ({@link java.util.Collection#contains(Object) collection element} or
 *        {@link java.util.Map#containsValue(Object) map value}).
 * @since 1.0.0
 */
public interface ReadableChangeAwareContainerValue<C, E> extends ReadableContainerValue<C, E> {

  /**
   * @see #getOriginalValue()
   */
  @Override
  C getValue();

  /**
   * @return in case this instance is also {@link WritableChangeAwareContainerValue writable} this method returns the
   *         exact same instance that was provided to {@link WritableChangeAwareContainerValue#setValue(Object)
   *         setValue}. In case {@link WritableChangeAwareContainerValue#setValue(Object) setValue} was called with a
   *         regular container (that is not an instance of {@link ChangeAwareContainer}), then {@link #getValue()} will
   *         return a new wrapped instance of that regular container. This method therefore allows to get the unwrapped
   *         original instance of the regular container. Otherwise this method will simply return the same result as
   *         {@link #getValue()}.
   */
  C getOriginalValue();

}
