/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Regular implementation of {@link net.sf.mmm.value.observable.containers.lists.ChangeAwareList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class ChangeAwareSetImpl<E> extends AbstractChangeAwareSet<E> {

  private final Set<E> set;

  /**
   * The constructor.
   */
  public ChangeAwareSetImpl() {

    this(new HashSet<>());
  }

  /**
   * The constructor.
   *
   * @param capacity the initial capacity.
   */
  public ChangeAwareSetImpl(int capacity) {

    this(new HashSet<>(capacity));
  }

  /**
   * The constructor.
   *
   * @param set the {@link Set} to adopt.
   */
  public ChangeAwareSetImpl(Set<E> set) {

    super();
    if (set == null) {
      this.set = new HashSet<>();
    } else {
      this.set = set;
    }
  }

  @Override
  public Iterator<E> iterator() {

    return new Itr(this.set.iterator());
  }

  @Override
  public int size() {

    return this.set.size();
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean addAll(E... elements) {

    boolean modified = this.set.addAll(Arrays.asList(elements));
    fireAdd(elements);
    return modified;
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean setAll(E... elements) {

    boolean modified = false;
    if (!this.set.isEmpty()) {
      Object[] oldElements = this.set.toArray();
      this.set.clear();
      fireRemove(oldElements);
      modified = true;
    }
    modified = this.set.addAll(Arrays.asList(elements));
    fireAdd(elements);
    return modified;
  }

  @Override
  public boolean setAll(Collection<? extends E> collection) {

    boolean modified = false;
    if (!this.set.isEmpty()) {
      Object[] oldElements = this.set.toArray();
      this.set.clear();
      fireRemove(oldElements);
      modified = true;
    }
    modified = this.set.addAll(collection);
    fireAdd(collection.toArray());
    return modified;
  }

  @Override
  public boolean remove(Object element) {

    boolean modified = this.set.remove(element);
    if (modified) {
      fireRemove(element);
    }
    return modified;
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean removeAll(E... elements) {

    boolean modified = this.set.removeAll(Arrays.asList(elements));
    fireRemove(elements);
    return modified;
  }

  @Override
  public boolean removeAll(Collection<?> collection) {

    boolean modified = this.set.removeAll(collection);
    fireRemove(collection.toArray());
    return modified;
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean retainAll(E... elements) {

    // TODO Auto-generated method stub
    return super.retainAll(elements);
  }

  @Override
  public Object[] toArray() {

    return this.set.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {

    return this.set.toArray(a);
  }

  @Override
  public boolean add(E e) {

    // TODO Auto-generated method stub
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {

    // TODO Auto-generated method stub
    return super.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {

    // TODO Auto-generated method stub
    return super.retainAll(c);
  }

  @Override
  public void clear() {

    if (this.set.isEmpty()) {
      return;
    }
    Object[] oldElements = this.set.toArray();
    this.set.clear();
    fireRemove(oldElements);
  }

  private class Itr implements Iterator<E> {

    private final Iterator<E> itr;

    private E lastElement;

    public Itr(Iterator<E> itr) {

      super();
      this.itr = itr;
    }

    @Override
    public boolean hasNext() {

      return this.itr.hasNext();
    }

    @Override
    public E next() {

      this.lastElement = this.itr.next();
      return this.lastElement;
    }

    @Override
    public void remove() {

      this.itr.remove();
      fireRemove(this.lastElement);
    }

  }

}
