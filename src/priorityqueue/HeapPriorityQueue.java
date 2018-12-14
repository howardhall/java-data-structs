package ds.priorityqueue;
import ds.list.ArrayList;
import ds.util.Pair;
import java.lang.Comparable;
public class HeapPriorityQueue<K extends Comparable<K>,V> implements iPriorityQueue<K,V> {
  private ModdedArrayList<Pair<K,V>> data;
  public HeapPriorityQueue(){
    this.data = new ModdedArrayList<Pair<K,V>>(7);
  }
  public void add(K k, V v){
    Pair<K,V> next = new Pair<K,V>(k,v);
    this.data.add(next);
    this.bubbleUp(this.data.size() -1);
  }
  private void bubbleUp(int index){
    int parent = this.parent(index);
    while(parent != index && this.data.get(index).getKey().compareTo(this.data.get(parent).getKey()) < 0){
      this.swap(index,parent);
      index = parent;
      parent = this.parent(index);
    }
  }
  private void heapify(int index){
    int left = this.left(index);
    int right = this.right(index);
    int min = -1;
    if(left < this.data.size() && this.data.get(left).getKey().compareTo(this.data.get(index).getKey()) < 0){
      min = left;
    } else {
      min = index;
    }
    if (right < this.data.size() && this.data.get(right).getKey().compareTo(this.data.get(min).getKey()) < 0){
      min = right;
    }
    if(min != index){
      this.swap(index,min);
      this.heapify(min);
    }
  }
  private void swap(int index, int index2){
    Pair<K,V> tmp = this.data.get(index);
    this.data.set(index,this.data.get(index2));
    this.data.set(index2,tmp);
  }
  private int parent(int i){
    return (i-1)/2;
  }
  private int left(int i){
    return 2*i+1;
  }
  private int right(int i){
    return 2*i+2;
  }
  public V peek(){
    return this.data.get(0).getValue();
  }
  public V remove(){
    if(this.data.size() == 0){
      return null;
    } else if (this.data.size() == 1){
      return this.data.remove(0).getValue();
    }
    Pair<K,V> min = this.data.get(0);
    this.data.set(0,this.data.removeLast());
    this.heapify(0);
    return min.getValue();
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
    return this.data.toString("HeapPriorityQueue : [","]");
  }
  private class ModdedArrayList<E> extends ArrayList<E>{
    public ModdedArrayList(){
      super();
    }
    public ModdedArrayList(int i){
      super(i);
    }
    public void extend(){
      this.extend(this.capacity*2+1);
    }
  }
}
