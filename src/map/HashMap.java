package src.map;
import src.list.LinkedList;
import src.util.Pair;
public class HashMap<K,V> implements iMap<K,V> {
  private LinkedList<Pair<K,V>>[] data;
  private int buckets;
  public HashMap(){
    this(31);
  }
  public HashMap(int c){
    @SuppressWarnings("unchecked")
    LinkedList<Pair<K,V>>[] tmp = new LinkedList[c];
    this.data = tmp;
    this.buckets = c;
    this.clear();
  }
  public void add(K k, V v){
    int target = k.hashCode() % this.buckets;
    Pair<K,V> elem = new Pair<K,V>(k,v);
    this.data[target].add(elem);
  }
  public V get(K k){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equalsKey(k)){
        return elem.getValue();
      }
    }
    return null;
  }
  public boolean contains(K k){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equalsKey(k)){
        return true;
      }
    }
    return false;
  }
  public boolean contains(K k, V v){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equals(k,v)){
        return true;
      }
    }
    return false;
  }
  public void clear(){
    for(int i=0;i<this.buckets;i++){
      this.data[i] = new LinkedList<Pair<K,V>>();
    }
  }
  public void set(K k, V v){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equalsKey(k)){
        elem.setValue(v);
      }
    }
  }
  public void set(K k, V v1, V v2){
    int target = k.hashCode() % this.buckets;
    for(Pair<K,V> elem : this.data[target]){
      if(elem.equals(k,v1)){
        elem.setValue(v2);
      }
    }
  }
  public boolean isEmpty(){
    return this.size() == 0;
  }
  public int size(){
    int size = 0;
    for(LinkedList<Pair<K,V>> bucket : this.data){
      size += bucket.size();
    }
    return size;
  }
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

  public String toString(){
    String result = "HashMap ("+this.buckets+"):";
    for(LinkedList<Pair<K,V>> list : this.data){
      result += "\n\t"+list.toString();
    }
    return result;
  }
}
