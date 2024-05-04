/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.locale;

import java.util.Locale;

import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.object.ObservableSimpleValue;

/**
 * {@link ObservableValue} with {@link Locale} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface ObservableLocaleValue extends ObservableSimpleValue<Locale>, ReadableLocaleValue {

}
