package src.util;
import src.util.GraphEdge;
import src.list.ArrayList;
public class GraphNode<T,W extends Number> {
  private T data;
  private ArrayList<GraphEdge<W>> E;
  public GraphNode(){
    this(null);
  }
  public GraphNode(T t){
    data = t;
    E = new ArrayList<GraphEdge<W>>();
  }
  public void addEdge(int e, W w){
    E.add(new GraphEdge<W>(e,w));
  }
  public W getEdge(int n){
    for(GraphEdge<W> w : E){
      if(w.equals(n)){
        return w.getWeight();
      }
    }
    return null;
  }
  public boolean hasEdge(int d){
    for(GraphEdge<W> w : E){
      if(w.equals(d)){
        return true;
      }
    }
    return false;
  }
  public W removeEdge(int n){
    for(GraphEdge<W> w : E){
      if(w.equals(n)){
        E.remove(w);
        return w.getWeight();
      }
    }
    return null;
  }
  public int degree(){
    return E.size();
  }
  public boolean equal(T t){
    return data.equals(t);
  }
}
