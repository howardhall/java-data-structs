package src.list;
import java.util.Iterator;
import java.util.Arrays;
/**
 * List implementation using a resizable array.
 * Array will expand when there is no extra space.
 * Expansion will incur a performance penalty, hence chosing the correct base size is a good idea.
 * @author Howard Hall-Benn
 * @since v1.0
 */
public class ArrayList<E> extends List<E>{
  private Object[] data;
  protected int capacity;
  /**
   * Constructor with custom initial size of internal array.
   * @param c Initial capacity.
   */
  public ArrayList(int c){
    this.data = new Object[c];
    this.size = 0;
    this.capacity = c;
  }
  /**
   * Constructor with default capacity (10).
   */
  public ArrayList(){
    this(10);
  }
  /**
   * Add item to ArrayList
   * @param e     The item to be added.
   * @param index The index to add it at.
   */
  public void add(E e, int index){
    if(index < 0 ){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    }
    if(index >= capacity){
      this.extend();
    }
    this.data[index] = e;
    this.size++;
  }
  /**
   * Adds an item to the end of the lists.
   * @param e The item to be added.
   */
  public void add(E e){
    this.add(e,this.size);
  }
  /**
   * Gets the item stored at the specified indexOf.
   * @param  index The index of the item.
   * @return       The item stored at specified index.
   */
  public E get(int index){
    if(index < 0 || index > this.capacity){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    }
    @SuppressWarnings("unchecked")
    final E e = (E) this.data[index];
    return e;
  }
  /**
   * Method to extend the array to ensure extra data can be added.
   */
  public void extend(){
    this.extend((int) (this.capacity*1.5)+1);
  }
  /**
   * Method to extend the array to a specified capacity.
   * @param c The new capacity.
   */
  public void extend(int c){
    this.capacity = c;
    this.data = Arrays.copyOf(this.data,c);
  }
  /**
   * Clears the array.
   */
  public void clear(){
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
    int index = 0;
    for(int i=0;i<this.size;i++){
      if(this.get(i).equals(e)){
        return i;
      }
    }
    return -1;
  }
  /**
   * Removes element at specified index and shifts elements down.
   * @param  index The index of the element to remove.
   * @return       The element that has been removed.
   */
  public E remove(int index){
    final E e = this.get(index);
    Object[] temp = new Object[this.capacity];
    if(index < 0 || index > this.size){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(index));
    }
    if(index > 0){
      System.arraycopy(this.data,0,temp,0,index);
    }
    if(index < this.size-1){
      System.arraycopy(this.data,index+1,temp,index,this.size-index-1);
    }
    this.data = temp;
    this.size--;
    return e;
  }
  /**
   * Searches and removes specified element if found.
   * @param  e The element to remove.
   * @return   The element if it has been found and removed, null otherwise
   */
  public E remove(E e){
    final int index = this.indexOf(e);
    if(index == -1){
      return null;
    }
    return this.remove(index);
  }
  /**
   * Removes the first item in the array.
   * @return The item at the start of the array.
   */
  public E removeFirst(){
    return this.remove(0);
  }
  /**
   * Removes the last item in the array.
   * @return The item at the end of the array.
   */
  public E removeLast(){
    return this.remove(this.size() - 1);
  }
  /**
   * Sets the data at a specified index of the array.
   * @param index The index we are updating.
   * @param e     The data to be stored.
   */
  public void set(int index, E e){
    if(index < 0 || index >= this.capacity){
      return;
    }
    this.data[index] = e;
  }
  /**
   * Ensures internal array is of specified size or larger.
   * @param i the minimum size.
   */
  public void ensureCapacity(int i){
    if(this.capacity < i){
      this.extend(i);
    }
  }
  /**
   * Removes elements between a given range of indexes.
   * @param start The first index to start removing from.
   * @param end   The last index to remove from.
   */
  public void removeRange(int start, int end){
    if(end < start || start < 0 || end > this.capacity){
      throw new ArrayIndexOutOfBoundsException(String.valueOf(start) + " to " + String.valueOf(end));
    }
    for(int i = start;i <= end; i++){
      this.remove(i);
    }
  }
  /**
   * Reduces the size of the internal array to it's current size.
   */
  public void trimToSize(){
    this.extend(this.size);
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
      result += ", ";
    }
    result += this.get(this.size-1).toString();
    return result + end;
  }
  /**
   * Creates an iterator for the array.
   * @return The iterator for the array.
   */
  @Override
  public Iterator<E> iterator() {
    return new Iter();
  }
  /**
   * Nested iterator class
   */
  private class Iter implements Iterator<E>{
    private int index;
    public Iter(){
      this.index = 0;
    }
    public boolean hasNext(){
      return (this.index < size);
    }
    public E next(){
      return get(this.index++);
    }
  }
}
