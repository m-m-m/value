/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value;

/**
 * Implementation of {@link PropertyPath} for a plain path without {@link #get() value}.
 *
 * @since 1.0.0
 */
public final class SimplePath implements PropertyPath<Object> {

  /** Name of the {@link #path() path} property for marshalling. */
  public static final String NAME_PATH = "path";

  private final ReadablePath parent;

  private final String name;

  /**
   * The constructor.
   *
   * @param parent the {@link #parentPath() parent path} or {@code null} for root.
   * @param name the {@link #getName() name} and {@link #pathSegment() segment}.
   */
  public SimplePath(ReadablePath parent, String name) {

    super();
    this.parent = parent;
    this.name = name;
  }

  @Override
  public Object get() {

    return null;
  }

  @Override
  public Object getFallbackSafeValue() {

    return null;
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public ReadablePath parentPath() {

    return this.parent;
  }

  @Override
  public Class<Object> getValueClass() {

    return Object.class;
  }

  @Override
  public String toString() {

    return path();
  }

  /**
   * @param path the entire {@link #path()}.
   * @return the given {@code path} parsed as {@link SimplePath}.
   */
  public static SimplePath of(String path) {

    int start = 0;
    SimplePath result = null;
    while (true) {
      int i = path.indexOf('.', start);
      if (i == -1) {
        return new SimplePath(result, path.substring(start));
      } else {
        String segment = path.substring(start, i);
        result = new SimplePath(result, segment);
        start = i + 1;
      }
    }
  }

}
