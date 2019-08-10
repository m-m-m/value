/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals.localdatetimes;

import java.time.LocalDateTime;

/**
 * Internal helper for {@link LocalDateTime}.
 */
class LocalDateTimeHelper {

  static boolean isInFuture(LocalDateTime value) {

    if (value != null) {
      return value.isAfter(LocalDateTime.now());
    }
    return false;
  }

  static boolean isInPast(LocalDateTime value) {

    if (value != null) {
      return value.isBefore(LocalDateTime.now());
    }
    return false;
  }

}
