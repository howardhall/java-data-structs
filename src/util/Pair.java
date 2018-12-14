package ds.util;
public class Pair<K,V> {
  private K key;
  private V value;
  public Pair(K k,V v){
    this.key = k;
    this.value = v;
  }
  public Pair(K k){
    this(k,null);
  }
  public K getKey(){
    return this.key;
  }
  public V getValue(){
    return this.value;
  }
  public void setKey(K k){
    this.key = k;
  }
  public void setValue(V v){
    this.value = v;
  }
  public void set(K k, V v){
    this.setKey(k);
    this.setValue(v);
  }
  public boolean equalsKey(K k){
    return this.key.equals(k);
  }
  public boolean equalsValue(V v){
    return this.value.equals(v);
  }
  public boolean equals(K k, V v){
    return this.equalsKey(k) && this.equalsValue(v);
  }
  public String toString(){
    return "{"+this.key.toString()+":"+this.value.toString()+"}";
  }
}
