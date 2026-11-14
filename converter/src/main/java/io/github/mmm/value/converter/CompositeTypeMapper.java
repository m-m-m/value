package io.github.mmm.value.converter;

import io.github.mmm.base.lang.Builder;

/// Implementation of [TypeMapper] for a composite type mapping. It will decompose the [source type][#getSourceType()] into multiple segments and has to have at least one [#next()] [TypeMapper].
///
/// @param <S> the [source type][#getSourceType()].
/// @param <T> the [target type][#getTargetType()].
/// @since 1.0.0
public abstract class CompositeTypeMapper<S, T> extends AbstractTypeMapper<S, T> {

  /// @see #getSuffix()
  protected final String suffix;

  private final CompositeTypeMapper<S, ?> next;

  /// The constructor.
  ///
  /// @param suffix the [suffix][#getSuffix()].
  /// @param next the [#next()] mapper. May be `null` for last (but not for first) segment.
  public CompositeTypeMapper(String suffix, CompositeTypeMapper<S, ?> next) {

    if ((suffix == null) || suffix.isEmpty()) {
      throw new IllegalArgumentException("Invalid suffix:" + suffix);
    }
    this.suffix = suffix;
    this.next = next;
  }

  @Override
  public String getDeclaration() {

    return "";
  }

  @Override
  public String getSuffix() {

    return this.suffix;
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
