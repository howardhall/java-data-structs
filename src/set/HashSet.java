package src.set;
import java.util.Iterator;
import src.list.LinkedList;
/**
 * Set is implemented using a HashTable.
 * Item is hashed to check if it exists.
 * Hash table has great performance even on high load factors.
 * Elements do not remain in order.
 * @author Howard Hall-Benn
 * @since v1.1
 */
public class HashSet<E> extends Set<E> {
  private LinkedList<E>[] data;
  private int buckets;
  /**
   * Constructor creating 17 buckets.
   */
  public HashSet(){
    this(17);
  }
  /**
   * Constructor creating user specified number of buckets.
   * @param c The number of buckets to be used.
   */
  public HashSet(int c){
    @SuppressWarnings("unchecked")
    LinkedList<E>[] tmp = new LinkedList[c];
    this.data = tmp;
    this.buckets = c;
    this.clear();
  }
  /**
   * Adds an item to the set provided it isn't already present.
   * @param e The item to be added.
   */
  public void add(E e){
    int target = e.hashCode() % this.buckets;
    if(!data[target].contains(e)){
      data[target].add(e);
    }
  }
  /**
   * Empties the set.
   */
  public void clear(){
    for(int i=0;i<this.buckets;i++){
      this.data[i] = new LinkedList<E>();
    }
  }
  /**
   * Checks if the set contains an element or not.
   * @param  e The item to be searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(E e){
    int target = e.hashCode() % this.buckets;
    return data[target].contains(e);
  }
  /**
   * Number of items in the set.
   * @return item count.
   */
  public int size(){
    int size = 0;
    for(LinkedList<E> item : this.data){
      size += item.size();
    }
    return size;
  }
  /**
   * Removes an item from the set.
   * @param  e The item to be removed.
   * @return   True if found and removed, false otherwise.
   */
  public boolean remove(E e){
    int target = e.hashCode() % this.buckets;
    return this.data[target].remove(e) == null;
  }
  /**
   * String representation of the set.
   * @return String containing the items in hash table ordering.
   */
  public String toString(){
    String result = "{";
    for(LinkedList<E> list : this.data){
      for(E item : list){
        result += item.toString() + ", ";
      }
    }
    result = result.substring(0, result.length() -2);
    return result + "}";
  }
  /**
   * ITERATOR IS NOT PRESENT.
   * @return null.
   */
  @Override
  public Iterator<E> iterator(){
    return null;
  }
}
