public class Stack<E> {
  private LinkedList<E> data;
  public Stack(){
    data = new LinkedList<E>();
  }
  public void push(E e){
    data.addFirst(e);
  }
  public E pop(){
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
    return data.toString("Stack (",")");
  }
}
