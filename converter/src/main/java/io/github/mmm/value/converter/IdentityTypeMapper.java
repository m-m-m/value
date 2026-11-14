package io.github.mmm.value.converter;

/// [AtomicTypeMapper] for identity conversion.
///
/// @param <V> type of the value to map. Due to identity conversion same as [source][#getSourceType()] and
///        [target][#getTargetType()].
/// @since 1.0.0
public class IdentityTypeMapper<V> extends AtomicTypeMapper<V, V> {

  private final Class<? extends V> type;

  /// The constructor.
  ///
  /// @param type the [source type][#getSourceType()] and [target type][#getTargetType()].
  public IdentityTypeMapper(Class<? extends V> type) {

    super();
    this.type = type;
  }

  @Override
  public Class<? extends V> getSourceType() {

    return this.type;
  }

  @Override
  public Class<? extends V> getTargetType() {

    return this.type;
  }

  @Override
  public V toSource(V target) {

    return target;
  }

  @Override
  public V toTarget(V source) {

    return source;
  }

}
