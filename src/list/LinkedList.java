package src.list;
import java.util.Iterator;
public class LinkedList<E> implements Iterable<E>, iList<E>{
  private Node<E> head;
  private Node<E> tail;
  private int size;
  public LinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  public void addFirst(E e){
    Node<E> n = new Node<E>(e);
    this.addFirst(n);
  }
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
  public void addLast(E e){
    Node<E> n = new Node<E>(e);
    this.addLast(n);
  }
  public E first(){
    return this.head.get();
  }
  public E last(){
    return this.tail.get();
  }
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
  public void add(E e){
    this.addLast(e);
  }
  public boolean add(int index, E e){
    Node<E> n = new Node<E>(e);
    return this.add(index, n);
  }
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
  public boolean isEmpty(){
    return this.size == 0;
  }
  public E removeFirst(){
    if(this.isEmpty()){
      return null;
    }
    Node<E> tmp = this.head;
    this.head = tmp.getNext();
    this.size--;
    return tmp.get();
  }
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
  public int size(){
    return this.size;
  }
  public void clear(){
    this.head = null;
    this.size = 0;
  }
  public boolean contains(E e){
    return (this.indexOf(e) != -1);
  }
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
  public E remove(E e){
    int index = this.indexOf(e);
    if(index != -1){
      this.remove(index);
      return e;
    }
    return null;
  }
  public String toString(){
    return this.toString("[","]");
  }
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
  public Iterator<E> iterator(){
    return new Iter<E>(this.head);
  }
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
