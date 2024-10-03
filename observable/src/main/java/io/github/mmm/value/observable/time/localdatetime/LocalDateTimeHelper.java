/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localdatetime;

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
