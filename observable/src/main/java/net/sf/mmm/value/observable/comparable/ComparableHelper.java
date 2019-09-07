/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.comparable;

import net.sf.mmm.value.ReadableValue;

/**
 * Internal helper for {@link Comparable}s.
 */
class ComparableHelper {

  static <V extends Comparable<? super V>> int compare(ReadableValue<V> v1, ReadableValue<V> v2) {

    return compare(v1.getValue(), v2.getValue());
  }

  static <V extends Comparable<? super V>> int compare(V v1, V v2) {

    if (v1 == null) {
      if (v2 == null) {
        return 0;
      } else {
        return 1;
      }
    } else if (v2 == null) {
      return -1;
    }
    return v1.compareTo(v2);
  }

}
