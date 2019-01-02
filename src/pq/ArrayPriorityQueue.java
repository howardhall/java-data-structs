package src.pq;
import src.list.ArrayList;
import src.util.Pair;
import java.lang.Comparable;
/**
 * Priority Queue implemented using an ArrayList.
 * Lowest Priority is found by using selection sort on removal.
 * Elements are stored in the order they are inserted in.
 * @author Howard Hall-Benn
 * @since v1.1
 */
public class ArrayPriorityQueue<K extends Comparable<K>,V> implements iPriorityQueue<K,V> {
  private ArrayList<Pair<K,V>> data;
  /**
   * Constructor to create ArrayList with a default capacity of 10.
   */
  public ArrayPriorityQueue(){
    this.data = new ArrayList<Pair<K,V>>();
  }
  /**
   * Constructor to create ArrayList with specified default capacity.
   * @param s The initial capacity of the ArrayList.
   */
  public ArrayPriorityQueue(int s){
    this.data = new ArrayList<Pair<K,V>>(s);
  }
  /**
   * Adds an element to the Priority Queue.
   * @param k The Priority of the item being added.
   * @param v The item itself.
   */
  public void add(K k, V v){
    Pair<K,V> item = new Pair<K,V>(k,v);
    this.data.add(item);
  }
  /**
   * Selection sorts the lowest priority item and returns it.
   * @return The item with the lowest priority.
   */
  public V peek(){
    if(this.isEmpty()){
      return null;
    }
    int min = 0;
    for(int i=1;i<this.data.size();i++){
      if(this.data.get(i).getKey().compareTo(this.data.get(min).getKey()) < 0){
        min = i;
      }
    }
    return this.data.get(min).getValue();
  }
  /**
   * Selection sorts the lowest priority item and removes it.
   * @return The item with the lowest priority.
   */
  public V remove(){
    if(this.isEmpty()){
      return null;
    }
    int min = 0;
    for(int i=1;i<this.data.size();i++){
      if(this.data.get(i).getKey().compareTo(this.data.get(min).getKey()) < 0){
        min = i;
      }
    }
    return this.data.remove(min).getValue();
  }
  /**
   * Check if there is an item with a specified priority.
   * @param  k The priority being searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(K k){
    for(Pair<K,V> item : this.data){
      if(item.equalsKey(k)){
        return true;
      }
    }
    return false;
  }
  /**
   * Check if there is an item with a specified value.
   * @param  v The item being searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(V v){
    for(Pair<K,V> item : this.data){
      if(item.equalsValue(v)){
        return true;
      }
    }
    return false;
  }
  /**
   * Check if there is an item with a specified priority and value.
   * @param  k The priority being searched for.
   * @param  v The item being searched for.
   * @return   True if found, false otherwise.
   */
  public boolean contains(K k, V v){
    for(Pair<K,V> item : this.data){
      if(item.equals(k,v)){
        return true;
      }
    }
    return false;
  }
  /**
   * Number of items in the priority queue.
   * @return the size.
   */
  public int size(){
    return this.data.size();
  }
  /**
   * If the priority queue is empty.
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty(){
    return this.size() == 0;
  }
  /**
   * String representation of the priority queue.
   * @return String with the elements in the order they were inserted in.
   */
  public String toString(){
    return this.data.toString("PriorityQueue [","]");
  }
}
