package ds.list;
public interface iList<E> {
  public void add(E e);
  public E get(int index);
  public int size();
  public boolean isEmpty();
  public void clear();
  public int indexOf(E e);
  public boolean contains(E e);
  public E remove(int index);
  public E remove(E e);
  public String toString();
}
