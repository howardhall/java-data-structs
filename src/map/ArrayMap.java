package src.map;
import src.list.ArrayList;
import src.util.Pair;
import java.util.Iterator;
/**
 * Map implementation using an ArrayList of key-value pair.
 * Elements remain in the order they were inserted in.
 * Performance penalty when the ArrayList resizes.
 * @author Howard Hall-Benn
 * @since v1.0
 */
public class ArrayMap<K,V> extends Map<K,V> {
  private ArrayList<Pair<K,V>> data;
  /**
   * Default constructor creating emtpy map.
   */
  public ArrayMap(){
    this.clear();
  }
  /**
   * Adds a new entry to the map.
   * @param k The key to be added.
   * @param v The value to be added.
   */
  public void add(K k, V v){
    this.data.add(new Pair<K,V>(k,v));
  }
  /**
   * Gets the entry with the specified key.
   * @param  k The key being searched for.
   * @return   The value stored with that key
   */
  public V get(K k){
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        return elem.getValue();
      }
    }
    return null;
  }
  /**
   * Checks the map contains specified key.
   * @param  k The key being searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(K k){
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        return true;
      }
    }
    return false;
  }
  /**
   * Checks the map contains a stated value under a specified key.
   * @param  k The key being searched for.
   * @param  v The value being searched for.
   * @return   True if found and equal, false othwersise.
   */
  public boolean contains(K k, V v){
    for(Pair<K,V> elem : this.data){
      if(elem.equals(k,v)){
        return true;
      }
    }
    return false;
  }
  /**
   * Clears the map.
   */
  public void clear(){
    this.data = new ArrayList<Pair<K,V>>();
  }
  /**
   * Sets the value at a specified key.
   * @param k The key being searched for.
   * @param v The value to be stored.
   */
  public void set(K k, V v){
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        elem.setValue(v);
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
    for(Pair<K,V> elem : this.data){
      if(elem.equals(k,v1)){
        elem.setValue(v2);
      }
    }
  }
  /**
   * The size of the map.
   * @return Number of entries in the map.
   */
  public int size(){
    return this.data.size();
  }
  /**
   * Removes the entry with stated key.
   * @param  k The key to be removed
   * @return   The value stored at that key.
   */
  public V remove(K k){
    int index = 0;
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        this.data.remove(index);
        return elem.getValue();
      } else {
        index++;
      }
    }
    return null;
  }
  /**
   * Removes the entry with stated key and value.
   * @param  k The key to be removed.
   * @param  v The value at the key.
   * @return   True if found and removed, false othwersise.
   */
  public boolean remove(K k, V v){
    int index = 0;
    for(Pair<K,V> elem : this.data){
      if(elem.equals(k,v)){
        this.data.remove(index);
        return true;
      } else {
        index++;
      }
    }
    return false;
  }
  /**
   * Removes all entries with stated key.
   * @param k The key to be removed.
   */
  public void removeAll(K k){
    int index = 0;
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        this.data.remove(index);
      } else {
        index++;
      }
    }
  }
  /**
   * Creates a string representation of the map.
   * @return The string representation.
   */
  public String toString(){
    String result = "ArrayMap : [";
    for(Pair<K,V> elem : data){
      result += elem.toString() + ", ";
    }
    result = result.substring(0,result.length()-2);
    return result + "]";
  }
  /**
   * Creates an iterator for the map.
   * @return The iterator.
   */
  @Override
  public Iterator<Pair<K,V>> iterator() {
    return this.data.iterator();
  }
}
