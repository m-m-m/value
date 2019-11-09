/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.temporal.instant;

import java.time.Instant;

/**
 * Internal helper for {@link Instant}.
 */
class InstantHelper {

  static boolean isInFuture(Instant value) {

    if (value != null) {
      return value.isAfter(Instant.now());
    }
    return false;
  }

  static boolean isInPast(Instant value) {

    if (value != null) {
      return value.isBefore(Instant.now());
    }
    return false;
  }

}
