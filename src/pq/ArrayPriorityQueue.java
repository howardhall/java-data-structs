package src.priorityqueue;
import src.list.ArrayList;
import src.util.Pair;
import java.lang.Comparable;
public class ArrayPriorityQueue<K extends Comparable<K>,V> implements iPriorityQueue<K,V> {
  private ArrayList<Pair<K,V>> data;
  public ArrayPriorityQueue(){
    this.data = new ArrayList<Pair<K,V>>();
  }
  public void add(K k, V v){
    Pair<K,V> item = new Pair<K,V>(k,v);
    this.data.add(item);
  }
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
    return this.size() == 0;
  }
  public String toString(){
    return this.data.toString("PriorityQueue [","]");
  }
}
