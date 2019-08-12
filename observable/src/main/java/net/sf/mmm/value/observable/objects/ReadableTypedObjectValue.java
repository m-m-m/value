/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.objects;

import net.sf.mmm.value.ReadableTypedValue;

/**
 * {@link ReadableObjectValue} that is also a {@link ReadableTypedValue}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableTypedObjectValue<V> extends ReadableTypedValue<V>, ReadableObjectValue<V> {

}
