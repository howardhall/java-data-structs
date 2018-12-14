public class Deque<E> {
  private LinkedList<E> data;
  public Deque(){
    data = new LinkedList<E>();
  }
  public void push(E e){
    data.addLast(e);
  }
  public E pull(){
    return data.removeL();
  }
  public E pop(){
    return data.removeLast();
  }
  public E peekFirst(){
    if(this.isEmpty()){
      return null;
    }
    return data.first();
  }
  public E peekLast(){
    if(this.isEmpty()){
      return null;
    }
    return data.last();
  }
  public boolean isEmpty(){
    return data.isEmpty();
  }
  public int size(){
    return data.size();
  }
  public String toString(){
    return data.toString("Queue (",")");
  }
}
