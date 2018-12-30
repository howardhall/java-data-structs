package src.util;
/**
 * Key value pair object, used in maps.
 */
public class Pair<K,V> {
  private K key;
  private V value;
  /**
   * Constructor with specfied key and value.
   * @param k Key.
   * @param v Value.
   */
  public Pair(K k,V v){
    this.key = k;
    this.value = v;
  }
  /**
   * Constructor with specfied key only.
   * @param k Key.
   */
  public Pair(K k){
    this(k,null);
  }
  /**
   * Return The key of this object.
   * @return The key.
   */
  public K getKey(){
    return this.key;
  }
  /**
   * Returns the value of this object.
   * @return The value.
   */
  public V getValue(){
    return this.value;
  }
  /**
   * Sets the key of this object.
   * @param k New Key.
   */
  public void setKey(K k){
    this.key = k;
  }
  /**
   * Sets the value of this object.
   * @param v New value.
   */
  public void setValue(V v){
    this.value = v;
  }
  /**
   * Sets the key and value of this object.
   * @param k New key.
   * @param v New value.
   */
  public void set(K k, V v){
    this.setKey(k);
    this.setValue(v);
  }
  /**
   * Checks this objects key matches a specfied key.
   * @param  k The key to be compared against.
   * @return   True if equal, false otherwise.
   */
  public boolean equalsKey(K k){
    return this.key.equals(k);
  }
  /**
   * Checks this objects value matches a specfied value.
   * @param  v The value to be compared against.
   * @return   True if equal, false otherwise.
   */
  public boolean equalsValue(V v){
    return this.value.equals(v);
  }
  /**
   * Checks this objects key and value matches a specfied key and value.
   * @param  k The key to be compared against.
   * @param  v The value to be comapred against.
   * @return   True if equal, false otherwise.
   */
  public boolean equals(K k, V v){
    return this.equalsKey(k) && this.equalsValue(v);
  }
  /**
   * Creates a string reprenting the Pair.
   * @return String representation of this pair.
   */
  public String toString(){
    return "{"+this.key.toString()+":"+this.value.toString()+"}";
  }
}
