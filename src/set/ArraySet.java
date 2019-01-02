package src.set;
import java.util.Iterator;
import src.list.ArrayList;
/**
 * Set is implemented using an ArrayList.
 * Linear search used to check if element already exists.
 * Low memory overhead, ideal for small sets.
 * Order of insertion is retained.
 * @author Howard Hall-Benn
 * @since v1.0
 */
public class ArraySet<E> extends Set<E> {
  private ArrayList<E> data;
  /**
   * Simple constructor.
   */
  public ArraySet(){
    this.clear();
  }
  /**
   * Adds an item to the set provided it isn't already present.
   * @param e The item to be added.
   */
  public void add(E e){
    if(!this.contains(e)){
      this.data.add(e);
    }
  }
  /**
   * Empties the set.
   */
  public void clear(){
    this.data = new ArrayList<E>();
  }
  /**
   * Checks if the set contains an element or not.
   * @param  e The item to be searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(E e){
    return this.data.contains(e);
  }
  /**
   * Number of items in the set.
   * @return item count.
   */
  public int size(){
    return this.data.size();
  }
  /**
   * Removes an item from the set.
   * @param  e The item to be removed.
   * @return   True if found and removed, false otherwise.
   */
  public boolean remove(E e){
    return this.data.remove(e) == null;
  }
  /**
   * String representation of the set.
   * @return String containing the items in insertion order.
   */
  public String toString(){
    return this.data.toString("{","}");
  }
  /**
   * Iterator for the set.
   * @return Items in the order they were inserted in.
   */
  @Override
  public Iterator<E> iterator(){
    return data.iterator();
  }
}
