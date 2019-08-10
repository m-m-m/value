/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.booleans;

import net.sf.mmm.value.WritableValue;

/**
 * {@link WritableValue} with {@link Boolean} {@link #getValue() value}.
 */
public interface WritableBooleanValue extends WritableValue<Boolean>, ReadableBooleanValue {

  /**
   * @param value the value to set.
   * @see #get()
   * @see #setValue(Boolean)
   */
  default void set(boolean value) {

    setValue(Boolean.valueOf(value));
  }

}
