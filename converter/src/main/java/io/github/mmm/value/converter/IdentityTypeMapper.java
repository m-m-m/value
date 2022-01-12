package io.github.mmm.value.converter;

/**
 * {@link AtomicTypeMapper} for identity conversion.
 *
 * @param <V> type of the value to map. Due to identity conversion same as {@link #getSourceType() source} and
 *        {@link #getTargetType() target}.
 * @since 1.0.0
 */
public class IdentityTypeMapper<V> extends AtomicTypeMapper<V, V> {

  /**
   * The constructor.
   *
   * @param sourceType the {@link #getSourceType() source type}.
   * @param declaration the {@link #getDeclaration() SQL type declaration}.
   */
  public IdentityTypeMapper(Class<? extends V> sourceType, String declaration) {

    super(sourceType, declaration);
  }

  @Override
  public Class<? extends V> getTargetType() {

    return getSourceType();
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
