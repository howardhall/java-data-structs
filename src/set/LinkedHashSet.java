package src.set;
import src.list.LinkedList;
import java.util.Iterator;
public class LinkedHashSet<E> extends Set<E>  {
  private HashSet<E> set;
  private LinkedList<E> order;
  public LinkedHashSet(){
    this(17);
  }
  public LinkedHashSet(int s){
    set = new HashSet<E>(s);
    order = new LinkedList<E>();
  }
  public void add(E e){
    set.add(e);
    order.addLast(e);
  }
  public void clear(){
    set.clear();
    order.clear();
  }
  public boolean contains(E e){
    return set.contains(e);
  }
  public int size(){
    return order.size();
  }
  public boolean remove(E e){
    order.remove(e);
    return set.remove(e);
  }
  public String toString(){
    return order.toString();
  }
  @Override
  public Iterator<E> iterator(){
    return order.iterator();
  }
}
