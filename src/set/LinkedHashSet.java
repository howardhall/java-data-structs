package src.set;
import src.list.LinkedList;
import java.util.Iterator;
/**
 * Set is implemented using a HastTable, with a LinkedList to retain the order.
 * Item is hashed to check if it exists.
 * Hash table has great performance even on high load factors.
 * Certain operations have reduced performance due to the LinkedList.
 * Elements do remain in order.
 * @author Howard Hall-Benn
 * @since v1.1
 */
public class LinkedHashSet<E> extends Set<E>  {
  private HashSet<E> set;
  private LinkedList<E> order;
  /**
   * Constructor creating 17 buckets.
   */
  public LinkedHashSet(){
    this(17);
  }
  /**
   * Constructor creating user specified number of buckets.
   * @param s The number of buckets to be used.
   */
  public LinkedHashSet(int s){
    set = new HashSet<E>(s);
    order = new LinkedList<E>();
  }
  /**
   * Adds an item to the set provided it isn't already present.
   * @param e The item to be added.
   */
  public void add(E e){
    if(!this.contains(e)){
      set.add(e);
      order.addLast(e);
    }
  }
  /**
   * Empties the set.
   */
  public void clear(){
    set.clear();
    order.clear();
  }
  /**
   * Checks if the set contains an element or not.
   * @param  e The item to be searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(E e){
    return set.contains(e);
  }
  /**
   * Number of items in the set.
   * @return item count.
   */
  public int size(){
    return order.size();
  }
  /**
   * Removes an item from the set.
   * @param  e The item to be removed.
   * @return   True if found and removed, false otherwise.
   */
  public boolean remove(E e){
    order.remove(e);
    return set.remove(e);
  }
  /**
   * String representation of the set.
   * @return String containing the items in insertion order.
   */
  public String toString(){
    return order.toString();
  }
  /**
   * Iterator for the set.
   * @return Items in the order they were inserted in.
   */
  @Override
  public Iterator<E> iterator(){
    return order.iterator();
  }
}
