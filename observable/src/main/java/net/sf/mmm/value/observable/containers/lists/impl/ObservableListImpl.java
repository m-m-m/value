/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.mmm.value.observable.containers.lists.ListChange;

/**
 * Regular implementation of {@link net.sf.mmm.value.observable.containers.lists.ObservableList}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public class ObservableListImpl<E> extends AbstractObservableList<E> {

  private final List<E> list;

  /**
   * The constructor.
   */
  public ObservableListImpl() {

    this(new ArrayList<>());
  }

  /**
   * The constructor.
   *
   * @param capacity the initial capacity.
   */
  public ObservableListImpl(int capacity) {

    this(new ArrayList<>(capacity));
  }

  /**
   * The constructor.
   *
   * @param list the internal {@link List} to adopt.
   */
  public ObservableListImpl(List<E> list) {

    super();
    this.list = list;
  }

  @Override
  public E get(int index) {

    return this.list.get(index);
  }

  @Override
  public int size() {

    return this.list.size();
  }

  @Override
  public int indexOf(Object element) {

    return this.list.indexOf(element);
  }

  @Override
  public int lastIndexOf(Object element) {

    return this.list.lastIndexOf(element);
  }

  @Override
  public boolean contains(Object element) {

    return this.list.contains(element);
  }

  @Override
  public boolean containsAll(Collection<?> collection) {

    return this.list.containsAll(collection);
  }

  @Override
  public boolean add(E element) {

    int from = this.list.size();
    this.list.add(element);
    fireAdd(from, 1);
    return true;
  }

  @Override
  public void add(int index, E element) {

    this.list.add(index, element);
    fireAdd(index, 1);
  }

  @Override
  public boolean addAll(Collection<? extends E> collection) {

    if (collection == null) {
      return false;
    }
    int count = collection.size();
    if (count == 0) {
      return false;
    }
    int index = this.list.size();
    boolean modified = this.list.addAll(collection);
    if (!modified) {
      return false;
    }
    fireAdd(index, count);
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> collection) {

    if (collection == null) {
      return false;
    }
    int count = collection.size();
    if (count == 0) {
      return false;
    }
    boolean modified = this.list.addAll(index, collection);
    if (!modified) {
      return false;
    }
    fireAdd(index, count);
    return true;
  }

  @Override
  public E set(int index, E element) {

    E oldElement = this.list.set(index, element);
    fireUpdate(index, 1);
    return oldElement;
  }

  @Override
  public void clear() {

    ListChange<E> modification = modRemoveAll();
    this.list.clear();
    fireEvent(modification);
  }

  @Override
  public E remove(int index) {

    E element = this.list.remove(index);
    fireRemove(index, element);
    return element;
  }

  @Override
  public boolean remove(Object element) {

    int index = indexOf(element);
    if (index < 0) {
      return false;
    }
    remove(index);
    return true;
  }

  @Override
  protected void removeRange(int from, int to) {

    ListChange<E> modification = modRemove(from, to);
    this.list.subList(from, to).clear();
    fireEvent(modification);
  }

  @Override
  public boolean removeAll(Collection<?> collection) {

    if (hasListeners()) {
      return super.removeAll(collection);
    } else {
      return this.list.removeAll(collection);
    }
  }

  @Override
  public boolean retainAll(Collection<?> collection) {

    if (hasListeners()) {
      return super.retainAll(collection);
    } else {
      return this.list.removeAll(collection);
    }
  }

}
