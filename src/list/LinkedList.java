package src.list;
import java.util.Iterator;
/**
 * List implementation using Node objects which contain data and a pointer to the next item in the list.
 * The LinkedList object keeps pointers to the head and tail of the list.
 * Often has poor performance due to cache misses.
 * @author Howard Hall-Benn
 * @since v1.0
 */
public class LinkedList<E> extends List<E> implements Iterable<E> {
  private Node<E> head;
  private Node<E> tail;
  /**
   * Constructor for linkedlist.
   */
  public LinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  /**
   * Adds an item to the start of the list.
   * @param e The item to be added.
   */
  public void addFirst(E e){
    Node<E> n = new Node<E>(e);
    this.addFirst(n);
  }
  /**
   * Adds a node to the start of the list.
   * @param n The node to be added.
   */
  public void addFirst(Node<E> n){
    if(this.isEmpty()){
      this.head = n;
      this.tail = n;
      this.size++;
      return;
    }
    n.setNext(this.head);
    this.head = n;
    this.size++;
  }
  /**
   * Adds a node to the end of the list.
   * @param n The node to be added.
   */
  public void addLast(Node<E> n){
    if(this.isEmpty()){
      this.addFirst(n);
      return;
    }
    Node<E> ptr = this.tail;
    ptr.setNext(n);
    this.tail = n;
    this.size++;
  }
  /**
   * Adds an element to the end of the list.
   * @param e The element to be added.
   */
  public void addLast(E e){
    Node<E> n = new Node<E>(e);
    this.addLast(n);
  }
  /**
   * Gets the first thing in the list.
   * @return The element at the start of the list.
   */
  public E first(){
    return this.head.get();
  }
  /**
   * Gets the last thing in the list.
   * @return The element at the end of the list.
   */
  public E last(){
    return this.tail.get();
  }
  /**
   * Gets the item stored at the specified indexOf.
   * @param  index The index of the item.
   * @return       The item stored at specified index.
   */
  public E get(int index){
    if(this.size() <= index || index < 0){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    }
    int counter = 0;
    Node<E> ptr = this.head;
    while(counter < index){
      ptr = ptr.getNext();
      counter++;
    }
    return ptr.get();
  }
  /**
   * Adds an item to the end of the lists.
   * @param e The item to be added.
   */
  public void add(E e){
    this.addLast(e);
  }
  /**
   * Add item to ArrayList
   * @param e     The item to be added.
   * @param index The index to add it at.
   * @return      True if operation was successful, false otherwise
   */
  public boolean add(int index, E e){
    Node<E> n = new Node<E>(e);
    return this.add(index, n);
  }
  /**
   * Adds a node the the list at a specified index.
   * @param  index The index to add the node at
   * @param  n     The node to be added
   * @return       If the operation completed successfully
   */
  public boolean add(int index, Node<E> n){
    if(index < 0 || index > this.size()){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    } else if (index == 0){
      this.addFirst(n);
      return true;
    } else if(index == this.size()){
      this.addLast(n);
      return true;
    }
    Node<E> ptr = this.head;
    int counter = 0;
    while(counter < index-1){
      ptr = ptr.getNext();
      counter++;
    }
    n.setNext(ptr.getNext());
    ptr.setNext(n);
    this.size++;
    return true;
  }
  /**
   * Removes the first item in the array.
   * @return The item at the start of the array.
   */
  public E removeFirst(){
    if(this.isEmpty()){
      return null;
    }
    Node<E> tmp = this.head;
    this.head = tmp.getNext();
    this.size--;
    return tmp.get();
  }
  /**
   * Removes the last item in the array.
   * @return The item at the end of the array.
   */
  public E removeLast(){
    if(this.isEmpty()){
      return null;
    }
    if(this.size() == 1){
      Node<E> ptr = this.head;
      this.head = null;
      this.tail = null;
      this.size--;
      return ptr.get();
    }
    Node<E> ptr = this.head;
    while(ptr.getNext().getNext() != null){
      ptr = ptr.getNext();
    }
    Node<E> tmp = this.tail;
    ptr.clearNext();
    this.size--;
    return tmp.get();
  }
  /**
   * Removes element at specified index and shifts elements down.
   * @param  index The index of the element to remove.
   * @return       The element that has been removed.
   */
  public E remove(int index){
    if(index < 0 || index >= this.size()){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    } else if(index == 0){
      return this.removeFirst();
    } else if(index == this.size()-1){
      return this.removeLast();
    }
    Node<E> ptr = this.head;
    int count = 0;
    while(count < index-1){
      ptr = ptr.getNext();
      count++;
    }
    Node<E> tmp = ptr.getNext();
    ptr.setNext(tmp.getNext());
    this.size--;
    return tmp.get();
  }
  /**
   * Clears the array.
   */
  public void clear(){
    this.head = null;
    this.size = 0;
  }
  /**
   * Checks if the array contains a specified elements.
   * @param  e The element being searched for.
   * @return   If the element was found.
   */
  public boolean contains(E e){
    return (this.indexOf(e) != -1);
  }
  /**
   * Gets the index of specified element.
   * @param  e The element being searched for.
   * @return   The index of the element if found, -1 otherwise.
   */
  public int indexOf(E e){
    Node<E> ptr = this.head;
    int index = 0;
    while(ptr != null){
      if(ptr.get().equals(e)){
        return index;
      }
      index++;
      ptr = ptr.getNext();
    }
    return -1;
  }
  /**
   * Sets the data at a specified index of the array.
   * @param index The index we are updating.
   * @param e     The data to be stored.
   * @return      True of operation was successful, false otherwise.
   */
  public boolean set(int index, E e){
    Node<E> ptr = this.head;
    if (index > this.size() || index < 0){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    }
    for(int i=0;i<index;i++){
      ptr = ptr.getNext();
    }
    ptr.set(e);
    return true;
  }
  /**
   * Searches and removes specified element if found.
   * @param  e The element to remove.
   * @return   The element if it has been found and removed, null otherwise
   */
  public E remove(E e){
    int index = this.indexOf(e);
    if(index != -1){
      this.remove(index);
      return e;
    }
    return null;
  }
  /**
   * Creates a string representation of the array.
   * @return The string containing the data.
   */
  public String toString(){
    return this.toString("[","]");
  }
  /**
   * Creates a string representation of the array with custom start and end syntax.
   * @param  start The string to be prepended to the data.
   * @param  end   The string to be appended to the data.
   * @return       The string containing the data.
   */
  public String toString(String start, String end){
    if(this.isEmpty()){
      return start+end;
    }
    String result = start;
    for(int i=0;i<this.size-1;i++){
      result += this.get(i).toString();
      result += " -> ";
    }
    result += this.get(this.size-1).toString();
    return result + end;
  }
  /**
   * Creates an iterator for the array.
   * @return The iterator for the array.
   */
  public Iterator<E> iterator(){
    return new Iter<E>(this.head);
  }
  /**
   * Nested iterator class
   */
  private class Iter<E> implements Iterator<E>{
    private Node<E> current;
    public Iter(Node<E> n){
      this.current = n;
    }
    public boolean hasNext(){
      return (current != null);
    }
    public E next(){
      E data = current.get();
      current = current.getNext();
      return data;
    }
  }
  /**
   * Nested Node class
   */
  private class Node<E> {
    private E data;
    private Node<E> next;
    public Node(E e){
      this.data = e;
      this.next = null;
    }
    public Node<E> getNext(){
      return this.next;
    }
    public E get(){
      return this.data;
    }
    public void set(E e){
      this.data = e;
    }
    public void setNext(Node<E> n){
      this.next = n;
    }
    public void setNext(E e){
      this.next = new Node<E>(e);
    }
    public void clearNext(){
      this.next = null;
    }
  }
}
