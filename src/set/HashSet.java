package ds.set;
import ds.list.LinkedList;
public class HashSet<E> implements iSet<E>{
  private LinkedList<E>[] data;
  private int buckets;
  public HashSet(){
    this(17);
  }
  public HashSet(int c){
    @SuppressWarnings("unchecked")
    LinkedList<E>[] tmp = new LinkedList[c];
    this.data = tmp;
    this.buckets = c;
    this.clear();
  }
  public void add(E e){
    int target = e.hashCode() % this.buckets;
    if(!data[target].contains(e)){
      data[target].add(e);
    }
  }
  public void clear(){
    for(int i=0;i<this.buckets;i++){
      this.data[i] = new LinkedList<E>();
    }
  }
  public boolean contains(E e){
    int target = e.hashCode() % this.buckets;
    return data[target].contains(e);
  }
  public boolean isEmpty(){
    return this.size() == 0;
  }
  public int size(){
    int size = 0;
    for(LinkedList<E> item : this.data){
      size += item.size();
    }
    return size;
  }
  public boolean remove(E e){
    int target = e.hashCode() % this.buckets;
    return this.data[target].remove(e) == null;
  }
  public String toString(){
    String result = "{";
    for(LinkedList<E> list : this.data){
      for(E item : list){
        result += item.toString() + ", ";
      }
    }
    result = result.substring(0, result.length() -2);
    return result + "}";
  }
}
