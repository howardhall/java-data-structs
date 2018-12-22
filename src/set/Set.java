package src.set;
import java.util.Iterator;
public abstract class Set<E> implements iSet<E>, Iterable<E> {
  public boolean isEmpty(){
    return this.size() == 0;
  }
}
