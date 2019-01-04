package src.graph;
import src.list.ArrayList;
public class WeightedMatrixGraph<T,W> extends WeightedGraph<T,W> {
  private Object[] V;
  private Object[][] E;
  private int size;
  private int capacity;
  public WeightedMatrixGraph(){
    this(10,false);
  }
  public WeightedMatrixGraph(int s){
    this(s,false);
  }
  public WeightedMatrixGraph(boolean d){
    this(10,d);
  }
  public WeightedMatrixGraph(int s, boolean d){
    capacity = s;
    V = new Object[s];
    E = new Object[s][s];
    directed = d;
  }
  public int addNode(T t){
    if(size>=capacity){
      expand();
    }
    V[size] = t;
    return size++;
  }
  public void addEdge(int n1, int n2, W w){
    if(n1 == n2){
      return;
    }
    E[n1][n2] = w;
    if(!directed){
      E[n2][n1] = w;
    }
  }
  public boolean containsNode(T t){
    return getIndex(t) != -1;
  }
  //TODO Check false == null, (change is not true)
  public boolean containsEdge(int n1, int n2){
    if(n1 < 0 || n2 < 0 || n1 > size || n2 > size){
      return false;
    }
    return E[n1][n2] != null;
  }
  public GraphNode<T,W> getNode(int n){}
  public W getEdge(int n1, int n2);
  public GraphNode<T,W> removeNode(int n);
  public W removeEdge(int n1, int n2);
  public int nodeCount();
  public int edgeCount();
  public int getIndex(T t);
  // public ArrayList<T> DFS(int s)
  // public ArrayList<T> BFS(int s)
}
