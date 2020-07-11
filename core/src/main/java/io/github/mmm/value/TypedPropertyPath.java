/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * A {@link PropertyPath} holding its {@link #getValueClass() type}.
 *
 * @param <V> type of the {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface TypedPropertyPath<V> extends PropertyPath<V>, ReadableTypedValue<V> {

}
