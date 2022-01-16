package io.github.mmm.value.converter;

/**
 * {@link AtomicTypeMapper} for conversion {@link Object#toString() to} {@link String}. <b>ATTENTION:</b> By default it
 * can not convert back from {@link String} {@link #toSource(String) to source}.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @since 1.0.0
 */
public class ToStringTypeMapper<S> extends AtomicTypeMapper<S, String> {

  private final Class<? extends S> sourceType;

  /**
   * The constructor.
   *
   * @param sourceType the {@link #getSourceType() source type}.
   * @param declaration the {@link #getDeclaration() SQL type declaration}.
   */
  public ToStringTypeMapper(Class<? extends S> sourceType, String declaration) {

    super(declaration);
    this.sourceType = sourceType;
  }

  @Override
  public Class<? extends S> getSourceType() {

    return this.sourceType;
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
