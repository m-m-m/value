package io.github.mmm.value.converter;

/**
 * Implementation of {@link TypeMapper} for an atomic type mapping.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @param <T> the {@link #getTargetType() target type}.
 * @since 1.0.0
 */
public abstract class AtomicTypeMapper<S, T> extends AbstractTypeMapper<S, T> {

  private final Class<? extends S> sourceType;

  /**
   * The constructor.
   *
   * @param sourceType the {@link #getSourceType() source type}.
   * @param declaration the {@link #getDeclaration() SQL type declaration}.
   */
  public AtomicTypeMapper(Class<? extends S> sourceType, String declaration) {

    super(declaration);
    this.sourceType = sourceType;
  }

  @Override
  public Class<? extends S> getSourceType() {

    return this.sourceType;
  }

  @Override
  public final TypeMapper<S, ?> next() {

    return null;
  }

}
