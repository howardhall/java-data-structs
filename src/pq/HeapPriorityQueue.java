package src.pq;
import src.list.ArrayList;
import src.util.Pair;
import java.util.Iterator;
public class HeapPriorityQueue<K extends Comparable<K>,V> {
  private ModdedArrayList<Pair<K,V>> data;
  private int k;
  public HeapPriorityQueue(){
    this(2,3);
  }
  public HeapPriorityQueue(int k){
    this(k,3);
  }
  public HeapPriorityQueue(int k, int d){
    if(k < 2 || d < 0){
      System.out.println("Throw an exception");
      //TODO actually setup exceptions
      return;
    }
    this.k = k;
    int s = (int)(Math.pow(k,d+1)-1)/(k-1);
    this.data = new ModdedArrayList<Pair<K,V>>(s,k);
  }
  public void swap(int index, int index2){
    Pair<K,V> p = this.data.get(index);
    this.data.set(index,this.data.get(index2));
    this.data.set(index2,p);
  }
  public void add(K k, V v){
    Pair<K,V> next = new Pair<K,V>(k,v);
    this.data.add(next);
    this.bubbleUp(this.data.size() -1);
  }
  private void bubbleUp(int index){
    int parent = this.getParent(index);
    while(parent != index && this.data.get(index).getKey().compareTo(this.data.get(parent).getKey()) < 0){
      this.swap(index,parent);
      index = parent;
      parent = this.getParent(index);
    }
  }
  private void heapify(int index){
    int base = this.getChild(index,1);
    int min = index;
    for(int i=base;i<=base+this.k;i++){
      if(i < this.data.size() && this.data.get(i).getKey().compareTo(this.data.get(min).getKey()) < 0){
        min = i;
      }
    }
    if(min != index){
      this.swap(index,min);
      this.heapify(min);
    }
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
  // O(n) as linearsearch, not O(log n)
  public void updateKey(K k, V v){
    Pair<K,V> p;
    for(int i=0;i<this.data.size();i++){
      p = this.data.get(i);
      if(p.equalsValue(v)){
        K prev = p.getKey();
        p.setKey(k);
        if(p.getKey().compareTo(prev) < 0){
          this.bubbleUp(i);
        } else {
          this.heapify(i);
        }
      }
    }
  }
  public void updateKey(K k1, K k2, V v){
    Pair<K,V> p;
    for(int i=0;i<this.data.size();i++){
      p = this.data.get(i);
      if(p.equals(k1,v)){
        K prev = p.getKey();
        p.setKey(k2);
        if(p.getKey().compareTo(prev) < 0){
          this.bubbleUp(i);
        } else {
          this.heapify(i);
        }
      }
    }
  }
  public int getParent(int i){
    return (i-1)/k;
  }
  public int getChild(int node, int child){
    if(node < 0 || node > data.size() || child < 1 || child > k){
      System.out.println("Throw an exception");
      return -1;
    }
    return (k*node)+child;
  }
  public V root(){
    return this.data.get(0).getValue();
  }
  public int getK(){
    return this.k;
  }
  public V peek(){
    return this.data.get(0).getValue();
  }
  public String toString(){
    String result = "";
    int limit = 1;
    int index = 0;
    for(Pair<K,V> p : this.data){
      result += p.getValue().toString() + "\t";
      index++;
      if(index >= limit){
        result += "\n";
        limit *= this.k;
        index = 0;
      }
    }
    return result;
  }
  public int size(){
    return this.data.size();
  }
  public boolean isEmpty(){
    return this.data.isEmpty();
  }
  private class ModdedArrayList<E> extends ArrayList<E>{
    // The modification is that array resizes on every new level of the tree
    private int growthFactor;
    public ModdedArrayList(){
      super();
      this.growthFactor = 2;
    }
    public ModdedArrayList(int i, int g){
      super(i);
      this.growthFactor = g;
    }
    public void extend(){
      this.extend(this.capacity*this.growthFactor+1);
    }
  }
}
