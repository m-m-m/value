package io.github.mmm.value.converter;

/**
 * Abstract base implementation of {@link TypeMapper}.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @param <T> the {@link #getTargetType() target type}.
 * @since 1.0.0
 */
public abstract class AbstractTypeMapper<S, T> implements TypeMapper<S, T> {

  private final String declaration;

  /**
   * The constructor.
   */
  public AbstractTypeMapper() {

    this("");
  }

  /**
   * The constructor.
   *
   * @param declaration the {@link #getDeclaration() declaration}.
   */
  public AbstractTypeMapper(String declaration) {

    super();
    this.declaration = declaration;
  }

  @Override
  public String getDeclaration() {

    return this.declaration;
  }

  @Override
  public String toString() {

    if ((this.declaration == null) || this.declaration.isEmpty()) {
      String string = getClass().getSimpleName();
      Class<?> sourceType = nonNull(getSourceType());
      Class<?> targetType = nonNull(getTargetType());
      if ((sourceType != Object.class) || (targetType != Object.class)) {
        string = string + "[" + toString(sourceType) + "->" + toString(targetType) + "]";
      }
      return string;
    }
    return this.declaration;
  }

  private String toString(Class<?> type) {

    String name = type.getName();
    if (name.startsWith("java.lang.")) {
      return name.substring(10);
    }
    return name;
  }

  private Class<?> nonNull(Class<?> type) {

    if (type == null) {
      return Object.class;
    }
    return type;
  }

}
