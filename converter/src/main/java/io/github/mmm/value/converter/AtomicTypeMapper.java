package io.github.mmm.value.converter;

/**
 * Implementation of {@link TypeMapper} for an atomic type mapping.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @param <T> the {@link #getTargetType() target type}.
 * @since 1.0.0
 */
public abstract class AtomicTypeMapper<S, T> extends AbstractTypeMapper<S, T> {

  /**
   * The constructor.
   */
  public AtomicTypeMapper() {

    this("");
  }

  /**
   * The constructor.
   *
   * @param declaration the {@link #getDeclaration() SQL type declaration}.
   */
  public AtomicTypeMapper(String declaration) {

    super(declaration);
  }

  @Override
  public final TypeMapper<S, ?> next() {

    return null;
  }

}
