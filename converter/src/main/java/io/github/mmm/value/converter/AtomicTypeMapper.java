package io.github.mmm.value.converter;

/// Implementation of [TypeMapper] for an atomic type mapping.
///
/// @param <S> the [source type][#getSourceType()].
/// @param <T> the [target type][#getTargetType()].
/// @since 1.0.0
public abstract class AtomicTypeMapper<S, T> extends AbstractTypeMapper<S, T> {

  @Override
  public final TypeMapper<S, ?> next() {

    return null;
  }

}
