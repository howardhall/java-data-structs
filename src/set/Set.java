package src.set;
import java.util.Iterator;
/**
 * Parent abstract class implemting the iSet interface.
 * @author Howard Hall-Benn
 * @since v1.0
 */
public abstract class Set<E> implements iSet<E>, Iterable<E> {
  /**
   * checks if the set is empty.
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty(){
    return this.size() == 0;
  }
}
