package src.map;
import src.list.LinkedList;
import src.util.Pair;
import java.util.Iterator;
/**
 * Map implementation using a HashTable with a LinkedList for retaining order.
 * No major penalty to insertion as inserting to tail of LinkedList is O(1).
 * Remove operation slowed by LinkedList.
 * @author Howard Hall-Benn
 * @since v1.1
 */
public class LinkedHashMap<K,V> extends Map<K,V> {
  private HashMap<K,V> map;
  private LinkedList<Pair<K,V>> order;
  /**
   * Default constructor, creating 31 buckets.
   */
  public LinkedHashMap(){
    this(31);
  }
  /**
   * constructor creating specified number of buckets.
   * @param s Number of buckets to be created.
   */
  public LinkedHashMap(int s){
    map = new HashMap<K,V>(s);
    order = new LinkedList<Pair<K,V>>();
  }
  /**
   * Adds a new entry to the map.
   * @param k The key to be added.
   * @param v The value to be added.
   */
  public void add(K k, V v){
    map.add(k,v);
    order.addLast(new Pair<K,V>(k,v));
  }
  /**
   * Gets the entry with the specified key.
   * @param  k The key being searched for.
   * @return   The value stored with that key
   */
  public V get(K k){
    return map.get(k);
  }
  /**
   * Checks the map contains specified key.
   * @param  k The key being searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(K k){
    return map.contains(k);
  }
  /**
   * Checks the map contains a stated value under a specified key.
   * @param  k The key being searched for.
   * @param  v The value being searched for.
   * @return   True if found and equal, false othwersise.
   */
  public boolean contains(K k, V v){
    return map.contains(k,v);
  }
  /**
   * Clears the map.
   */
  public void clear(){
    map.clear();
    order.clear();
  }
  /**
   * Sets the value at a specified key.
   * @param k The key being searched for.
   * @param v The value to be stored.
   */
  public void set(K k, V v){
    map.set(k,v);
    for(Pair<K,V> p : order){
      if(p.equalsKey(k)){
        p.setValue(v);
      }
    }
  }
  /**
   * Sets the value at a specified key and current value.
   * @param k  The key being searched for.
   * @param v1 The current value at the key.
   * @param v2 The new value at the key.
   */
  public void set(K k, V v1, V v2){
    map.set(k,v1,v2);
    for(Pair<K,V> p : order){
      if(p.equals(k,v1)){
        p.setValue(v2);
      }
    }
  }
  /**
   * The size of the map.
   * @return Number of entries in the map.
   */
  public int size(){
    return order.size();
  }
  /**
   * Removes the entry with stated key.
   * @param  k The key to be removed
   * @return   The value stored at that key.
   */
  public V remove(K k){
    for(Pair<K,V> p : order){
      if(p.equalsKey(k)){
        order.remove(p);
        break;
      }
    }
    return map.remove(k);
  }
  /**
   * Removes the entry with stated key and value.
   * @param  k The key to be removed.
   * @param  v The value at the key.
   * @return   True if found and removed, false othwersise.
   */
  public boolean remove(K k, V v){
    for(Pair<K,V> p : order){
      if(p.equals(k,v)){
        order.remove(p);
        break;
      }
    }
    return map.remove(k,v);
  }
  /**
   * Removes all entries with stated key.
   * @param k The key to be removed.
   */
  public void removeAll(K k){
    for(Pair<K,V> p : order){
      if(p.equalsKey(k)){
        order.remove(p);
      }
    }
    map.removeAll(k);
  }
  /**
   * Creates a string representation of the map.
   * @return The string representation.
   */
  public String toString(){
    return order.toString();
  }
  /**
   * Creates an iterator for the map.
   * @return The iterator.
   */
  @Override
  public Iterator<Pair<K,V>> iterator() {
    return order.iterator();
  }
}
