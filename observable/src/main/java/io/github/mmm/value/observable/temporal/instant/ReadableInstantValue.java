/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.instant;

import java.time.Instant;

import io.github.mmm.value.observable.temporal.ReadableTemporalValue;

/**
 * {@link io.github.mmm.value.ReadableValue} containing a {@link Instant} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableInstantValue extends ReadableTemporalValue<Instant> {

  @Override
  default Class<Instant> getValueClass() {

    return Instant.class;
  }

  @Override
  default Instant getFallbackSafeValue() {

    return Instant.MIN;
  }

}
