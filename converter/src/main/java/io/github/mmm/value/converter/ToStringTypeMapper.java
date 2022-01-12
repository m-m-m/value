package io.github.mmm.value.converter;

/**
 * {@link AtomicTypeMapper} for conversion {@link Object#toString() to} {@link String}.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @since 1.0.0
 */
public class ToStringTypeMapper<S> extends AtomicTypeMapper<S, String> {

  /**
   * The constructor.
   *
   * @param sourceType the {@link #getSourceType() source type}.
   * @param declaration the {@link #getDeclaration() SQL type declaration}.
   */
  public ToStringTypeMapper(Class<S> sourceType, String declaration) {

    super(sourceType, declaration);
  }

  @Override
  public Class<String> getTargetType() {

    return String.class;
  }

  @Override
  public S toSource(String target) {

    // not implemented, override to support
    throw new UnsupportedOperationException();
  }

  @Override
  public String toTarget(S source) {

    if (source == null) {
      return null;
    }
    return source.toString();
  }

}
