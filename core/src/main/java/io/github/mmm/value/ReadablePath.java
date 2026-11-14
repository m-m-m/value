/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

import io.github.mmm.value.impl.PathBuilderImpl;

/// Interface to [read][#path()] a [#path()].
///
/// @since 1.0.0
public interface ReadablePath {

  /// This method is not a regular getter to avoid conflicts with custom properties of beans implementing this interface.
  ///
  /// @return the [path][#path()]-segment of this object. Should be a single property name (e.g. "MyProperty") or
  ///         alias (e.g. "entity").
  String pathSegment();

  /// This method is not a regular getter to avoid conflicts with custom properties of beans implementing this interface.
  ///
  /// @return the path of this object. May be a single property name (e.g. "MyProperty") or a dot-separated path (e.g.
  ///         "MyEntity.MyProperty").
  default String path() {

    ReadablePath parent = parentPath();
    if (parent == null) {
      return pathSegment();
    }
    PathBuilder builder = PathBuilder.of();
    path(builder);
    return builder.toString();
  }

  /// @param fixed `true` to prefer static [segments][#pathSegment()] if available, `false` otherwise.
  /// @return the path of this object. May be a single property name (e.g. "MyProperty") or a dot-separated path (e.g.
  ///         "MyEntity.MyProperty").
  default String path(boolean fixed) {

    return path();
  }

  /// @param builder the [PathBuilder] where to [add][PathBuilder#add(String)] the segments of all properties
  ///        from the root (recursively via [#parentPath()] to this object).
  default void path(PathBuilder builder) {

    ReadablePath parent = parentPath();
    if (parent != null) {
      parent.path(builder);
    }
    builder.add(this);
  }

  /// @return the parent of this path or `null` if this is the root property that has no parent.
  default ReadablePath parentPath() {

    return null;
  }

  /// Interface for a builder to a path.
  interface PathBuilder {

    default void add(ReadablePath path) {

      add(path.pathSegment());
    }

    /// @param segment the [path][ReadablePath#path()] segment to add. Typically the [name of a property][PropertyPath#getName()].
    void add(String segment);

    /// @return the (current) path as [String].
    @Override
    String toString();

    static PathBuilder of() {

      return of(".");
    }

    static PathBuilder of(String separator) {

      return new PathBuilderImpl(separator);
    }
  }

}
