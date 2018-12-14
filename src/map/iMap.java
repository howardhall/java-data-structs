package ds.map;
public interface iMap<K,V> {
  public void add(K k, V v);
  public V get(K k);
  public boolean contains(K k);
  public boolean contains(K k, V v);
  public void clear();
  public void set(K k, V v);
  public void set(K k, V v1, V v2);
  public boolean isEmpty();
  public int size();
  public V remove(K k);
  public boolean remove(K k, V v);
  public void removeAll(K k);
  public String toString();
}
