package src.map;
import src.list.LinkedList;
import src.util.Pair;
import java.util.Iterator;
/**
 * Map implementation using a HashTable of key-value pair.
 * Keys are hashed for fast searching.
 * Elements do not remain in order.
 * @author Howard Hall-Benn
 * @since v1.1
 */
public class HashMap<K,V> extends Map<K,V> {
  private LinkedList<Pair<K,V>>[] data;
  private int buckets;
  /**
   * Default constructor creating 31 buckets.
   */
  public HashMap(){
    this(31);
  }
  /**
   * constructor creating specified number of buckets.
   * @param c Number of buckets to be created.
   */
  public HashMap(int c){
    @SuppressWarnings("unchecked")
    LinkedList<Pair<K,V>>[] tmp = new LinkedList[c];
    this.data = tmp;
    this.buckets = c;
    this.clear();
  }
  /**
   * Adds a new entry to the map.
   * @param k The key to be added.
   * @param v The value to be added.
   */
  public void add(K k, V v){
    int target = k.hashCode() % this.buckets;
    Pair<K,V> elem = new Pair<K,V>(k,v);
    this.data[target].add(elem);
  }
  /**
   * Gets the entry with the specified key.
   * @param  k The key being searched for.
   * @return   The value stored with that key
   */
  public V get(K k){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
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
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
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
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
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
    for(int i=0;i<this.buckets;i++){
      this.data[i] = new LinkedList<Pair<K,V>>();
    }
  }
  /**
   * Sets the value at a specified key.
   * @param k The key being searched for.
   * @param v The value to be stored.
   */
  public void set(K k, V v){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
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
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
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
    int size = 0;
    for(LinkedList<Pair<K,V>> bucket : this.data){
      size += bucket.size();
    }
    return size;
  }
  /**
   * Removes the entry with stated key.
   * @param  k The key to be removed
   * @return   The value stored at that key.
   */
  public V remove(K k){
    int target = k.hashCode() % this.buckets;
    int count = 0;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equalsKey(k)){
        Pair<K,V> result = this.data[target].remove(count);
        return result.getValue();
      }
      count++;
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
    int target = k.hashCode() % this.buckets;
    int count = 0;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equals(k,v)){
        this.data[target].remove(count);
        return true;
      }
      count++;
    }
    return false;
  }
  /**
   * Removes all entries with stated key.
   * @param k The key to be removed.
   */
  public void removeAll(K k){
    int target = k.hashCode() % this.buckets;
    int count = 0;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equalsKey(k)){
        this.data[target].remove(count);
      } else {
        count++;
      }
    }
  }
  /**
   * Creates a string representation of the map.
   * @return The string representation.
   */
  public String toString(){
    String result = "HashMap ("+this.buckets+"):";
    for(LinkedList<Pair<K,V>> list : this.data){
      result += "\n\t"+list.toString();
    }
    return result;
  }
  /**
   * NOT IMPLEMENTED, PLANNED FOR 1.3.
   * Creates an iterator for the hashmap.
   * @return The iterator.
   * @since v1.3
   */
  @Override
  public Iterator<Pair<K,V>> iterator() {
    return null;
  }
}
