package src.map;
import src.list.ArrayList;
import src.util.Pair;
import java.util.Iterator;
public class ArrayMap<K,V> extends Map<K,V> {
  private ArrayList<Pair<K,V>> data;
  public ArrayMap(){
    this.clear();
  }
  public void add(K k, V v){
    this.data.add(new Pair<K,V>(k,v));
  }
  public V get(K k){
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        return elem.getValue();
      }
    }
    return null;
  }
  public boolean contains(K k){
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        return true;
      }
    }
    return false;
  }
  public boolean contains(K k, V v){
    for(Pair<K,V> elem : this.data){
      if(elem.equals(k,v)){
        return true;
      }
    }
    return false;
  }
  public void clear(){
    this.data = new ArrayList<Pair<K,V>>();
  }
  public void set(K k, V v){
    for(Pair<K,V> elem : this.data){
      if(elem.equalsKey(k)){
        elem.setValue(v);
      }
    }
  }
  public void set(K k, V v1, V v2){
    for(Pair<K,V> elem : this.data){
      if(elem.equals(k,v1)){
        elem.setValue(v2);
      }
    }
  }
  public int size(){
    return this.data.size();
  }
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
  public String toString(){
    String result = "ArrayMap : [";
    for(Pair<K,V> elem : data){
      result += elem.toString() + ", ";
    }
    result = result.substring(0,result.length()-2);
    return result + "]";
  }
  @Override
  public Iterator<Pair<K,V>> iterator() {
    return this.data.iterator();
  }
}
