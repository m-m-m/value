/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.value.observable.containers.ReadableChangeAwareContainerValue;
import net.sf.mmm.value.observable.containers.ReadableContainerValue;

/**
 * {@link ReadableContainerValue} for {@link ChangeAwareMap} {@link #getValue() value}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface ReadableChangeAwareMapValue<K, V>
    extends ReadableMapValue<K, V>, ReadableChangeAwareContainerValue<Map<K, V>, V> {

  @Override
  ChangeAwareMap<K, V> getValue();

  @Override
  default ChangeAwareMap<K, V> getValueSafe() {

    ChangeAwareMap<K, V> value = getValue();
    if (value == null) {
      value = ChangeAwareMaps.empty();
    }
    return value;
  }

}
