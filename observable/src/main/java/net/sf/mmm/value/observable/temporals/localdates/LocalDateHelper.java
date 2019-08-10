/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals.localdates;

import java.time.LocalDate;

/**
 * Internal helper for {@link LocalDate}.
 */
class LocalDateHelper {

  static boolean isInFuture(LocalDate value) {

    if (value != null) {
      return value.isAfter(LocalDate.now());
    }
    return false;
  }

  static boolean isInPast(LocalDate value) {

    if (value != null) {
      return value.isBefore(LocalDate.now());
    }
    return false;
  }

}
