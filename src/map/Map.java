package src.map;
import java.util.Iterator;
import src.util.Pair;
public abstract class Map<K,V> implements Iterable<Pair<K,V>>, iMap<K,V> {
  public boolean isEmpty(){
    return this.size() == 0;
  }
}
