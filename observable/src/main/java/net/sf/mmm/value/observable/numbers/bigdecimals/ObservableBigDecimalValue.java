/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.numbers.bigdecimals;

import java.math.BigDecimal;

import net.sf.mmm.value.observable.numbers.ObservableNumberValue;

/**
 * {@link net.sf.mmm.value.observable.ObservableValue} containing a {@link BigDecimal} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ObservableBigDecimalValue extends ObservableNumberValue<BigDecimal>, ReadableBigDecimalValue {

}
