/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals.instants;

import java.time.Instant;

import net.sf.mmm.value.observable.temporals.ReadableTemporalValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link Instant} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface ReadableInstantValue extends ReadableTemporalValue<Instant> {

  @Override
  default Class<Instant> getValueClass() {

    return Instant.class;
  }

}
