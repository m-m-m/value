/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.offsettime;

import java.time.OffsetTime;

/**
 * Internal helper for {@link OffsetTime}.
 */
class OffsetTimeHelper {

  static boolean isInFuture(OffsetTime value) {

    if (value != null) {
      return value.isAfter(OffsetTime.now());
    }
    return false;
  }

  static boolean isInPast(OffsetTime value) {

    if (value != null) {
      return value.isBefore(OffsetTime.now());
    }
    return false;
  }

}
