/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.zoneddatetime;

import java.time.ZonedDateTime;

/**
 * Internal helper for {@link ZonedDateTime}.
 */
class ZonedDateTimeHelper {

  static boolean isInFuture(ZonedDateTime value) {

    if (value != null) {
      return value.isAfter(ZonedDateTime.now());
    }
    return false;
  }

  static boolean isInPast(ZonedDateTime value) {

    if (value != null) {
      return value.isBefore(ZonedDateTime.now());
    }
    return false;
  }

}
