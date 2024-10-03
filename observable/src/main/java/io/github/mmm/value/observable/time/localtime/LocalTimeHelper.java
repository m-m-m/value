/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.time.localtime;

import java.time.LocalTime;

/**
 * Internal helper for {@link LocalTime}.
 */
class LocalTimeHelper {

  static boolean isInFuture(LocalTime value) {

    if (value != null) {
      return value.isAfter(LocalTime.now());
    }
    return false;
  }

  static boolean isInPast(LocalTime value) {

    if (value != null) {
      return value.isBefore(LocalTime.now());
    }
    return false;
  }

}
