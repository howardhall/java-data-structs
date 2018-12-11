public class Queue<E> {
  private LinkedList<E> data;
  public Queue(){
    data = new LinkedList<E>();
  }
  public void push(E e){
    data.addLast(e);
  }
  public E pull(){
    return data.removeFirst();
  }
  public E peek(){
    if(this.isEmpty()){
      return null;
    }
    return data.first();
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
