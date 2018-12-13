import java.lang.Comparable;
public class LinkedPriorityQueue<K extends Comparable<K>,V> implements iPriorityQueue<K,V> {
  private LinkedList<Pair<K,V>> data;
  public LinkedPriorityQueue(){
    this.data = new LinkedList<Pair<K,V>>();
  }
  public void add(K k, V v){
    int index = 0;
    for(Pair<K,V> item : this.data){
      if(item.getKey().compareTo(k) > 0){
        break;
      }
      index++;
    }
    Pair<K,V> next = new Pair<K,V>(k,v);
    this.data.add(index,next);
  }
  public V peek(){
    return this.data.get(0).getValue();
  }
  public V remove(){
    return this.data.removeFirst().getValue();
  }
  public boolean contains(K k){
    for(Pair<K,V> item : this.data){
      if(item.equalsKey(k)){
        return true;
      }
    }
    return false;
  }
  public boolean contains(V v){
    for(Pair<K,V> item : this.data){
      if(item.equalsValue(v)){
        return true;
      }
    }
    return false;
  }
  public boolean contains(K k, V v){
    for(Pair<K,V> item : this.data){
      if(item.equals(k,v)){
        return true;
      }
    }
    return false;
  }
  public int size(){
    return this.data.size();
  }
  public boolean isEmpty(){
    return this.data.isEmpty();
  }
  public String toString(){
    return this.data.toString("PriorityQueue [","]");
  }
}
