package io.github.mmm.value.converter;

/**
 * {@link AtomicTypeMapper} for identity conversion.
 *
 * @param <V> type of the value to map. Due to identity conversion same as {@link #getSourceType() source} and
 *        {@link #getTargetType() target}.
 * @since 1.0.0
 */
public class IdentityTypeMapper<V> extends AtomicTypeMapper<V, V> {

  private final Class<? extends V> type;

  /**
   * The constructor.
   *
   * @param type the {@link #getSourceType() source type} and {@link #getTargetType() target type}.
   * @param declaration the {@link #getDeclaration() SQL type declaration}.
   */
  public IdentityTypeMapper(Class<? extends V> type, String declaration) {

    super(declaration);
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
