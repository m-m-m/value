/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.value.observable.containers.WritableChangeAwareContainerValue;
import net.sf.mmm.value.observable.containers.WritableContainerValue;

/**
 * {@link WritableContainerValue} for {@link ChangeAwareMap} {@link #getValue() value}s.
 *
 * @param <K> type of the {@link ChangeAwareMap#containsKey(Object) keys}.
 * @param <V> type of the {@link ChangeAwareMap#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface WritableChangeAwareMapValue<K, V>
    extends WritableChangeAwareContainerValue<Map<K, V>, V>, WritableMapValue<K, V>, ReadableChangeAwareMapValue<K, V> {

  @Override
  default ChangeAwareMap<K, V> getOrCreateValue() {

    ChangeAwareMap<K, V> value = getValue();
    if (value == null) {
      value = ChangeAwareMaps.of();
      setValue(value);
    }
    return value;
  }

}
