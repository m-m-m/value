/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers;

import net.sf.mmm.value.observable.objects.ReadableTypedObjectValue;

/**
 * {@link ReadableTypedObjectValue} for container {@link #getValue() values} (e.g. {@link java.util.Collection} or
 * {@link java.util.Map}).
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableContainerValue<V> extends ReadableTypedObjectValue<V> {

}
