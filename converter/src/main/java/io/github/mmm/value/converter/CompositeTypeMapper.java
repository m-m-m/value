package io.github.mmm.value.converter;

import io.github.mmm.base.lang.Builder;

/**
 * Implementation of {@link TypeMapper} for a composite type mapping. It will decompose the {@link #getSourceType()
 * source type} into multiple segments and has to have at least one {@link #next()} {@link TypeMapper}.
 *
 * @param <S> the {@link #getSourceType() source type}.
 * @param <T> the {@link #getTargetType() target type}.
 * @since 1.0.0
 */
public abstract class CompositeTypeMapper<S, T> extends AbstractTypeMapper<S, T> {

  /** @see #getSuffix() */
  protected final String suffix;

  private final CompositeTypeMapper<S, ?> next;

  /**
   * The constructor.
   *
   * @param suffix the {@link #getSuffix() suffix}.
   * @param next the {@link #next()} mapper. May be {@code null} for last (but not for first) segment.
   */
  public CompositeTypeMapper(String suffix, CompositeTypeMapper<S, ?> next) {

    this(suffix, next, "");
  }

  /**
   * The constructor.
   *
   * @param suffix the {@link #getSuffix() suffix}.
   * @param next the {@link #next()} mapper. May be {@code null} for last (but not for first) segment.
   * @param declaration the {@link #getDeclaration() declaration}.
   */
  public CompositeTypeMapper(String suffix, CompositeTypeMapper<S, ?> next, String declaration) {

    super(declaration);
    if ((suffix == null) || suffix.isEmpty()) {
      throw new IllegalArgumentException("Invalid suffix:" + suffix);
    }
    this.suffix = suffix;
    this.next = next;
  }

  /**
   * @return the suffix to {@link #mapName(String, String) append to the name}.
   */
  public String getSuffix() {

    return this.suffix;
  }

  @Override
  public String mapName(String name, String separator) {

    return name + separator + this.suffix;
  }

  @Override
  public CompositeTypeMapper<S, ?> next() {

    return this.next;
  }

  @Override
  public S toSource(T target) {

    // you shall not call this method on composite type mappers, read the JavaDocs...
    throw new IllegalStateException(
        "Composite mapper (" + getClass().getSimpleName() + ") shall only be used via builder!");
  }

  @Override
  public abstract Builder<S> sourceBuilder();

  @Override
  public abstract void with(Builder<S> builder, T targetSegment);

}
