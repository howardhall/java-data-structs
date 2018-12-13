import java.lang.Comparable;
public interface iPriorityQueue<K extends Comparable<K>,V> {
  public void add(K k, V v);
  public V peek();
  public V remove();
  public boolean contains(K k);
  public boolean contains(V v);
  public boolean contains(K k, V v);
  public int size();
  public boolean isEmpty();
}
