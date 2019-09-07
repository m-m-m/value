/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporal;

import java.time.temporal.Temporal;

import net.sf.mmm.value.observable.object.ReadableTypedObjectValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link Temporal} {@link #getValue() value}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableTemporalValue<V extends Temporal> extends ReadableTypedObjectValue<V> {

}
