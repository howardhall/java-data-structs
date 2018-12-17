package src.tree;
public interface iTree<E> {
  public void add(E e);
  public E remove();
  public boolean contains(E e);
  public void update(E e1, E e2);
  public E root();
  public String toString();
}
