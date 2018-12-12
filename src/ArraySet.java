import java.util.Iterator;
public class ArraySet<E> implements iSet<E>{
  private ArrayList<E> data;
  public ArraySet(){
    this.clear();
  }
  public void add(E e){
    if(!this.contains(e)){
      this.data.add(e);
    }
  }
  public void clear(){
    this.data = new ArrayList<E>();
  }
  public boolean contains(E e){
    return this.data.contains(e);
  }
  public boolean isEmpty(){
    return this.data.isEmpty();
  }
  public int size(){
    return this.data.size();
  }
  public boolean remove(E e){
    return this.data.remove(e) == null;
  }
  public String toString(){
    return this.data.toString("{","}");
  }
}
