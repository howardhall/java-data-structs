package src.util;
import src.list.ArrayList;
public class GraphNode<E> {
  private E data;
  private ArrayList<GraphNode<E>> adjacent;
  //private ArrayList<Integer> weights;
  public GraphNode(E e){
    this.data = e;
    this.adjacent = new ArrayList<GraphNode<E>>();
  }
  public E get(){
    return this.data;
  }
  public void set(E e){
    this.data = e;
  }
  public GraphNode<E> getChild(int index){
    return this.adjacent.get(index);
  }
  public int degree(){
    return this.adjacent.size();
  }
  public int size(){
    return this.degree();
  }
  // public boolean equals(E e){
  //   return this.data.equals(e);
  // }
  public GraphNode<E> getChild(E e){
    for(GraphNode<E> item : this.adjacent){
      if(item.equals(e)){
        return item;
      }
    }
    return null;
  }
  public boolean hasChild(GraphNode<E> n){
    return this.adjacent.contains(n);
  }
  public void addChild(GraphNode<E> n){
    this.adjacent.add(n);
  }
  public GraphNode<E> removeChild(GraphNode<E> n){
    return this.adjacent.remove(n);
  }
}
