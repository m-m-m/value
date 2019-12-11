/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.offsetdatetime;

import java.time.OffsetDateTime;

/**
 * Internal helper for {@link OffsetDateTime}.
 */
class OffsetDateTimeHelper {

  static boolean isInFuture(OffsetDateTime value) {

    if (value != null) {
      return value.isAfter(OffsetDateTime.now());
    }
    return false;
  }

  static boolean isInPast(OffsetDateTime value) {

    if (value != null) {
      return value.isBefore(OffsetDateTime.now());
    }
    return false;
  }

}
