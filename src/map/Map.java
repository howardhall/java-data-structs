package src.map;
import java.util.Iterator;
import src.util.Pair;
/**
 * Parent abstract class implemting the iMap interface
 * @author Howard Hall-Benn
 * @since v1.0
 */
public abstract class Map<K,V> implements Iterable<Pair<K,V>>, iMap<K,V> {
  /**
   * Checks if the map is empty.
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty(){
    return this.size() == 0;
  }
}
