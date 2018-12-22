package src.list;

import java.util.Iterator;

/**
 * A generic implementation of the IList interface.
 *
 * <p>MODIFY THIS FILE. Based on MyArrayList.java from CS126 lab 1. See adt/Readme.md
 *
 * @author Till Bretschneider
 *
 * @param <E> the type of elements in this list.
 */
public class MyArrayList<E> implements Iterable<E> {

  private Object[] array;
  private int size;
  private int capacity;

  /**
   * Create empty list with initial capacity.
   */
  public MyArrayList() {
    this.capacity = 100;
    this.array = new Object[capacity];
    this.size = 0;
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#add(java.lang.Object)
   */
  public boolean add(E element) {
    // INCOMPLETE.
    // Adds element to the list, returns true on success and false otherwise.
	if (this.size == capacity) {
          int newCapacity = this.capacity + 100;
          Object[] newArray = new Object[newCapacity];
          System.arraycopy(this.array, 0, newArray, 0, capacity);
          this.array = newArray;
          this.capacity = newCapacity;
        }

        this.array[size] = element;
        size++;

        return true;
    //throw new RuntimeException("not yet implemented");
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#contains(java.lang.Object)
   */
  public boolean contains(E element) {
    // INCOMPLETE.
    // Returns true when element is in the list, false otherwise.
	for (Object o: this.array) {
          if (element.equals(o)) {
            return true;
          }
        }
        return false;
    //throw new RuntimeException("not yet implemented");
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#clear()
   */
  public void clear() {
    this.capacity = 100;
    this.array = new Object[capacity];
    this.size = 0;
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#isEmpty()
   */
  public boolean isEmpty() {
    return this.size() == 0;
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#size()
   */
  public int size() {
    return size;
  }

  // This line allows us to cast our object to type (E) without any warnings.
  // For further details, please see:
  // http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/SuppressWarnings.html
  @SuppressWarnings("unchecked")
  public E get(int index) {
    return (E) this.array[index];
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#indexOf(java.lang.Object)
   */
  public int indexOf(E element) {
    for (int i = 0; i < this.size(); i++) {
      if (element.equals(this.get(i))) {
        return i;
      }
    }
    return -1;
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#remove(java.lang.Object)
   */
  public boolean remove(E element) {
    int index = this.indexOf(element);
    if (index >= 0) {
      E removed = this.get(index);
      for (int i = index + 1; i < this.size(); i++) {
        this.set(i - 1, this.get(i));
      }
      this.array[size - 1] = null;
      size--;
      return true;
    }
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see adt.list.IList#set(int, java.lang.Object)
   */
  public E set(int index, E element) {
    if (index >= this.size()) {
      throw new ArrayIndexOutOfBoundsException("index > size: " + index + " >= " + size);
    }
    E replaced = this.get(index);
    this.array[index] = element;
    return replaced;
  }

  /*
   * (non-Javadoc)
   * Example for use of for-each loop.
   * modified by Till Bretschneider
   *
   * @see java.lang.Object#toString()
   */
  public String toString() {
    if (this.isEmpty())
      return "[]";

    String s = "[";

    for (E e : this)
      s += e.toString() + ", ";

    return s.substring(0, s.length() - 2) + "]";
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<E> iterator() {
    // INCOMPLETE.
    //throw new RuntimeException("not yet implemented");
    return new MyArrayListIterator();
  }
  private class MyArrayListIterator implements Iterator<E>{
	private int index;
	public boolean hasNext(){
	  return (index < size);
	}
	public E next() {
		return get(index++);
	}
  }
}
