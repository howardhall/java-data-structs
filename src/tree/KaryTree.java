package src.tree;
import src.list.ArrayList;
import java.lang.Comparable;
public class KaryTree<E extends Comparable<E>> implements iTree<E> {
  private ModdedArrayList<E> data;
  private int k;
  public KaryTree(){
    this(2,3);
  }
  public KaryTree(int k){
    this(k,3);
  }
  public KaryTree(int k, int d){
    if(k < 2 || d < 0){
      System.out.println("Throw an exception");
      //TODO actually setup exceptions
      return;
    }
    this.k = k;
    int s = (int)(Math.pow(k,d+1)-1)/(k-1);
    this.data = new ModdedArrayList<E>(s,k);
  }
  public void swap(int index, int index2){
    E e = this.data.get(index);
    this.data.set(index,this.data.get(index2));
    this.data.set(index2,e);
  }
  public void add(E e){
    this.data.add(e);
    this.bubbleUp(this.data.size() -1);
  }
  private void bubbleUp(int index){
    int parent = this.getParent(index);
    while(parent != index && this.data.get(index).compareTo(this.data.get(parent)) < 0){
      this.swap(index,parent);
      index = parent;
      parent = this.getParent(index);
    }
  }
  private void heapify(int index){
    int base = this.getChild(index,1);
    int min = index;
    for(int i=base;i<=base+this.k;i++){
      if(i < this.data.size() && this.data.get(i).compareTo(this.data.get(min)) < 0){
        min = i;
      }
    }
    if(min != index){
      this.swap(index,min);
      this.heapify(min);
    }
  }
  public E remove(){
    if(this.data.size() == 0){
      return null;
    } else if (this.data.size() == 1){
      return this.data.remove(0);
    }
    E e = this.data.get(0);
    this.data.set(0,this.data.removeLast());
    this.heapify(0);
    return e;
  }
  public boolean contains(E e){
    for(E item : this.data){
      if(item.equals(e)){
        return true;
      }
    }
    return false;
  }
  // O(n) as linearsearch, not O(log n)
  public void update(E e1, E e2){
    E e;
    for(int i=0;i<this.data.size();i++){
      e = this.data.get(i);
      if(e.equals(e1)){
        E prev = e;
        e = e2;
        if(e.compareTo(prev) < 0){
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
  public E root(){
    return this.data.get(0);
  }
  public String toString(){
    String result = "";
    int limit = 1;
    int index = 0;
    for(E e : this.data){
      result += e.toString() + "\t";
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
