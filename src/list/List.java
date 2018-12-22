package src.list;
import java.util.Iterator;
public abstract class List<E> implements iList<E>, Iterable<E> {
  protected int size;
  public int size(){
    return this.size;
  }
  public boolean isEmpty(){
    return this.size == 0;
  }
}
