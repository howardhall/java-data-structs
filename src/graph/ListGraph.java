package src.graph;
import src.list.ArrayList;
import src.util.GraphNode;
import src.util.GraphEdge;
public class ListGraph<T,W extends Number> {
  private ArrayList<GraphNode<T,W>> V;
  private boolean directed;
  public ListGraph(){
    this(10,false);
  }
  public ListGraph(int s){
    this(s,false);
  }
  public ListGraph(boolean d){
    this(10,d);
  }
  public ListGraph(int s, boolean d){
    V = new ArrayList<GraphNode<T,W>>(s);
    directed = d;
  }
  public int addNode(T t){
    V.add(new GraphNode<T,W>(t));
    return V.size()-1;
  }
  public void addEdge(int n1, int n2, W w){
    V.get(n1).addEdge(n2,w);
    if(!directed){
      V.get(n2).addEdge(n1,w);
    }
  }
  public boolean containsNode(T t){
    for(GraphNode<T,W> n : V){
      if(n.equal(t)){
        return true;
      }
    }
    return false;
  }
  public boolean containsEdge(int n1, int n2){
    return V.get(n1).hasEdge(n2);
  }
  public GraphNode<T,W> removeNode(int n){
    return V.remove(n);
  }
  public W removeEdge(int n1, int n2){
    if(!directed){
      V.get(n2).removeEdge(n1);
    }
    return V.get(n1).removeEdge(n2);
  }
  public GraphNode<T,W> getNode(int n){
    return V.get(n);
  }
  public int getIndex(T t){
    for(int i=0;i<V.size();i++){
      if(V.get(i).equal(t)){
        return i;
      }
    }
    return -1;
  }
  public W getEdge(int n1, int n2){
    return V.get(n1).getEdge(n2);
  }
  public int nodeCount(){
    return V.size();
  }
  public int edgeCount(){
    int size = 0;
    for(GraphNode<T,W> t : V){
      size += t.degree();
    }
    return size;
  }
}
