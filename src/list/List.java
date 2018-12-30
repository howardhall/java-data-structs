package src.list;
import java.util.Iterator;
/**
 * Parent abstract class implemting the iList interface
 * @author Howard Hall-Benn
 * @since v1.0
 */
public abstract class List<E> implements iList<E>, Iterable<E> {
  protected int size;
  /**
   * Gets the size of the list.
   * @return The size of the list.
   */
  public int size(){
    return this.size;
  }
  /**
   * Checks if the list is currently empty.
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty(){
    return this.size == 0;
  }
}
