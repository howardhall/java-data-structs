package src.map;
import src.list.LinkedList;
import src.util.Pair;
import java.util.Iterator;
public class LinkedHashMap<K,V> extends Map<K,V> {
  private HashMap<K,V> map;
  private LinkedList<Pair<K,V>> order;
  public LinkedHashMap(){
    this(31);
  }
  public LinkedHashMap(int s){
    map = new HashMap<K,V>(s);
    order = new LinkedList<Pair<K,V>>();
  }
  public void add(K k, V v){
    map.add(k,v);
    order.addLast(new Pair<K,V>(k,v));
  }
  public V get(K k){
    return map.get(k);
  }
  public boolean contains(K k){
    return map.contains(k);
  }
  public boolean contains(K k, V v){
    return map.contains(k,v);
  }
  public void clear(){
    map.clear();
    order.clear();
  }
  public void set(K k, V v){
    map.set(k,v);
    for(Pair<K,V> p : order){
      if(p.equalsKey(k)){
        p.setValue(v);
      }
    }
  }
  public void set(K k, V v1, V v2){
    map.set(k,v1,v2);
    for(Pair<K,V> p : order){
      if(p.equals(k,v1)){
        p.setValue(v2);
      }
    }
  }
  public int size(){
    return order.size();
  }
  public V remove(K k){
    for(Pair<K,V> p : order){
      if(p.equalsKey(k)){
        order.remove(p);
        break;
      }
    }
    return map.remove(k);
  }
  public boolean remove(K k, V v){
    for(Pair<K,V> p : order){
      if(p.equals(k,v)){
        order.remove(p);
        break;
      }
    }
    return map.remove(k,v);
  }
  public void removeAll(K k){
    for(Pair<K,V> p : order){
      if(p.equalsKey(k)){
        order.remove(p);
      }
    }
    map.removeAll(k);
  }
  public String toString(){
    return order.toString();
  }
  @Override
  public Iterator<Pair<K,V>> iterator() {
    return order.iterator();
  }
}
