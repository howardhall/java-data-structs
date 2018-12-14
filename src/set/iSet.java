package src.set;
public interface iSet<E> {
  public void add(E e);
  public void clear();
  public boolean contains(E e);
  public boolean isEmpty();
  public int size();
  public boolean remove(E e);
}
