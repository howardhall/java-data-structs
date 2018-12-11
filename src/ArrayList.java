import java.util.Iterator;
public class ArrayList<E> implements Iterable<E>, iList<E>{
  private Object[] data;
  private int size;
  private int capacity;
  public ArrayList(int c){
    this.data = new Object[c];
    this.size = 0;
    this.capacity = c;
  }
  public ArrayList(){
    this(100);
  }
  public void add(E e, int index){
    if(index < 0 ){
      return;
    }
    if(index >= capacity){
      this.extend();
    }
    this.data[index] = e;
    this.size++;
  }
  public void add(E e){
    this.add(e,this.size);
  }
  public E get(int index){
    if(index < 0 || index > this.size){
      return null;
    }
    @SuppressWarnings("unchecked")
    final E e = (E) this.data[index];
    return e;
  }
  public int size(){
    return this.size;
  }
  public void extend(){
    this.extend(this.capacity*2);
  }
  public void extend(int c){
    Object[] temp = new Object[c];
    System.arraycopy(this.data,0,temp,0,this.size);
    this.data = temp;
    this.capacity = c;
  }
  public void clear(){
    this.size = 0;
  }
  public boolean contains(E e){
    return (this.indexOf(e) != -1);
  }
  public int indexOf(E e){
    int index = 0;
    for(int i=0;i<this.size;i++){
      if(this.get(i).equals(e)){
        return i;
      }
    }
    return -1;
  }
  public boolean isEmpty(){
    return this.size == 0;
  }
  public E remove(int index){
    final E e = this.get(index);
    Object[] temp = new Object[this.capacity];
    if(index > 0){
      System.arraycopy(this.data,0,temp,0,index);
    }
    if(index < this.size-1){
      System.arraycopy(this.data,index+1,temp,index,this.size-index-1);
    }
    this.data = temp;
    this.size--;
    return e;
  }
  public E remove(E e){
    final int index = this.indexOf(e);
    if(index == -1){
      return null;
    }
    return this.remove(index);
  }
  public E removeFirst(){
    return this.remove(0);
  }
  
  public void set(E e, int index){
    if(index < 0 || index >= this.size){
      return;
    }
    this.data[index] = e;
  }
  public void removeRange(int start, int end){
    if(end > start || start < 0 || end > this.capacity){
      return;
    }
    for(int i = start;i <= end; i++){
      this.remove(i);
    }
  }
  public void trimToSize(){
    this.extend(this.size);
  }
  public String toString(){
    return this.toString("[","]");
  }
  public String toString(String start, String end){
    if(this.isEmpty()){
      return start+end;
    }
    String result = start;
    for(int i=0;i<this.size-1;i++){
      result += this.get(i).toString();
      result += ", ";
    }
    result += this.get(this.size-1).toString();
    return result + end;
  }
  public Iterator<E> iterator(){
    return new Iter<E>();
  }
  private class Iter<E> implements Iterator<E>{
    private int index;
    public Iter(){
      this.index = 0;
    }
    public boolean hasNext(){
      return (this.index < size);
    }
    public E next(){
      Object data = get(this.index++);
      @SuppressWarnings("unchecked")
      E e = (E) data;
      return e;
    }
  }
}
