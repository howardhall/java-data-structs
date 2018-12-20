package src.graph;
import src.util.GraphNode;
import src.map.HashMap;
/* BROKEN
public class ListGraph<E> {
  private HashMap<Integer,GraphNode<E>> V;
  private int size;
  private boolean directed;
  public ListGraph(){
    this(false);
  }
  public ListGraph(boolean directed){
    this.directed = directed;
    this.size == 0;
    this.V = new ArrayList<GraphNode<E>>();
  }
  public void addNode(GraphNode<E> n){
    this.V.add(this.size++,n);
  }
  public void addEdge(GraphNode<E> n1, GraphNode<E> n2){
    n1.addChild(n2);
    if(!this.directed){
      n2.addChild(n1);
    }
  }
  public boolean containsNode(GraphNode<E> n){
    return this.V.contains(n);
  }
  public boolean containsEdge(GraphNode<E> n1, GraphNode<E> n2){
    return n1.hasChild(n2);
  }
  public void removeNode(GraphNode<E> n){
    this.V.remove(n);
  }
  public void removeEdge(GraphNode<E> n1, GraphNode<E> n2){
    n1.removeChild(n2);
    if(!this.directed){
      n2.removeChild(n1);
    }
  }
  public int nodeCount(){
    return this.V.size();
  }
  public int edgeCount(){
    int size = 0;
    for(GraphNode<E> n : this.V){
      size += n.degree();
    }
    return size;
  }
}
*/
