package io.github.mmm.value.impl;

import java.util.Objects;

import io.github.mmm.value.ReadablePath.PathBuilder;

/**
 * Default implementation of {@link PathBuilder}.
 *
 * @since 1.0.0
 */
public class PathBuilderImpl implements PathBuilder {

  private final String separator;

  private final StringBuilder buffer;

  /**
   * The constructor.
   *
   * @param separator the separator used to separate {@link #add(String) path segments}.
   */
  public PathBuilderImpl(String separator) {

    super();
    Objects.requireNonNull(separator, "separator");
    if (separator.isEmpty()) {
      throw new IllegalArgumentException("Separator must not be empty!");
    }
    this.separator = separator;
    this.buffer = new StringBuilder();
  }

  @Override
  public void add(String segment) {

    if ((segment == null) || segment.isEmpty()) {
      return;
    }
    if (this.buffer.length() > 0) {
      this.buffer.append(this.separator);
    }
    assert ((segment != null) && !segment.isEmpty());
    this.buffer.append(segment);
  }

  @Override
  public String toString() {

    return this.buffer.toString();
  }

}
