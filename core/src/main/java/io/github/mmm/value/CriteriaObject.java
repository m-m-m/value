package io.github.mmm.value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Interface for a generic criteria expression. Can be different things such as e.g. a {@link PropertyPath property}, a
 * criteria expression or a literal value.
 *
 * @param <V> type of the value to select.
 * @since 1.0.0
 */
public interface CriteriaObject<V> {

  /**
   * @return a new {@link List} with all {@link PropertyPath}s found in this predicate.
   */
  default List<PropertyPath<?>> collectProperties() {

    List<PropertyPath<?>> properties = new ArrayList<>();
    collectProperties(properties);
    return properties;
  }

  /**
   * @param properties the {@link Collection} where to add contained properties.
   * @see #collectProperties()
   */
  void collectProperties(Collection<PropertyPath<?>> properties);

}
