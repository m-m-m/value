package io.github.mmm.value.converter;

/**
 * Abstract base implementation of {@link TypeMapper}.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @param <T> the {@link #getTargetType() target type}.
 * @since 1.0.0
 */
public abstract class AbstractTypeMapper<S, T> implements TypeMapper<S, T> {

  @Override
  public String toString() {

    String declaration = getDeclaration();
    if ((declaration == null) || declaration.isEmpty()) {
      String string = getClass().getSimpleName();
      Class<?> sourceType = nonNull(getSourceType());
      Class<?> targetType = nonNull(getTargetType());
      if ((sourceType != Object.class) || (targetType != Object.class)) {
        string = string + "[" + toString(sourceType) + "->" + toString(targetType) + "]";
      }
      return string;
    }
    return declaration;
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
