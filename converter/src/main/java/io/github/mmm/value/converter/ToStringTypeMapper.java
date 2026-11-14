package io.github.mmm.value.converter;

/// [AtomicTypeMapper] for conversion [to][Object#toString()] [String]. **ATTENTION:** By default it
/// can not convert back from [String] [to source][#toSource(String)].
///
/// @param <S> the [source type][#getSourceType()].
/// @since 1.0.0
public class ToStringTypeMapper<S> extends AtomicTypeMapper<S, String> {

  private final Class<? extends S> sourceType;

  /// The constructor.
  ///
  /// @param sourceType the [source type][#getSourceType()].
  public ToStringTypeMapper(Class<? extends S> sourceType) {

    super();
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
