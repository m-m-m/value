/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.container.set;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import io.github.mmm.value.observable.container.list.ChangeAwareList;
import io.github.mmm.value.observable.container.set.impl.ChangeAwareSetImpl;
import io.github.mmm.value.observable.container.set.impl.EmptyChangeAwareSet;
import io.github.mmm.value.observable.container.set.impl.ImmutableChangeAwareSet;
import io.github.mmm.value.observable.container.set.impl.ImmutableChangeAwareSetView;

/**
 * Factory for {@link ChangeAwareSet}.
 *
 * @since 1.0.0
 */
public final class ChangeAwareSets {

  private ChangeAwareSets() {

    super();
  }

  /**
   * @param <E> the type of the elements.
   * @return an empty, immutable {@link ChangeAwareSet}.
   */
  public static <E> ChangeAwareSet<E> empty() {

    return EmptyChangeAwareSet.INSTANCE;
  }

  /**
   * @param <E> the type of the elements.
   * @return a new empty mutable {@link ChangeAwareSet}.
   */
  public static <E> ChangeAwareSet<E> of() {

    return new ChangeAwareSetImpl<>();
  }

  /**
   * @param <E> the type of the elements.
   * @param capacity the initial capacity of the set.
   * @return a new empty mutable {@link ChangeAwareSet}.
   */
  public static <E> ChangeAwareSet<E> of(int capacity) {

    return new ChangeAwareSetImpl<>(capacity);
  }

  /**
   * @param <E> the type of the elements.
   * @param set the existing {@link Set} implementation to wrap as {@link ChangeAwareSet}. Please avoid to modify this
   *        {@link Set} afterwards, as this will not trigger modification events.
   * @return a new empty mutable {@link ChangeAwareSet}.
   */
  public static <E> ChangeAwareSet<E> of(Set<E> set) {

    if (set instanceof ChangeAwareSet) {
      return (ChangeAwareSet<E>) set;
    }
    return new ChangeAwareSetImpl<>(set);
  }

  /**
   * @param <E> the type of the elements.
   * @param set the existing {@link List} implementation to wrap as {@link ChangeAwareList}. Modifying such {@link List}
   *        afterwards will not trigger modification events in the read-only view returned by this method.
   * @return an unmodifiable {@link ChangeAwareList} that acts as a view on the given {@link Set}.
   */
  public static <E> ChangeAwareSet<E> ofUnmodifiable(Set<E> set) {

    if (set instanceof ImmutableChangeAwareSet) {
      return (ChangeAwareSet<E>) set;
    }
    return new ImmutableChangeAwareSet<>(set);
  }

  /**
   * @param <E> the type of the elements.
   * @param setSupplier the existing {@link List} implementation to wrap as {@link ChangeAwareList}. Modifying such
   *        {@link List} afterwards will not trigger modification events in the read-only view returned by this method.
   * @return an unmodifiable {@link ChangeAwareList} that acts as a view on the {@link Supplier#get() supplied}
   *         {@link Set}.
   */
  public static <E> ChangeAwareSet<E> ofUnmodifiable(Supplier<Set<E>> setSupplier) {

    return new ImmutableChangeAwareSetView<>(setSupplier);
  }

}
