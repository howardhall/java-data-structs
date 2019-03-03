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
  public W getEdge(int n1, int n2){
    if(n1 > this.size || n1 < 0 || n2 > this.size || n2 < 0){
      return null;
    }
    @SuppressWarnings("unchecked")
    W result = (W) this.E[n1][n2];
    return result;
  }
  public void removeNode(int n){
  }
  public W removeEdge(int n1, int n2){
    W result = this.getEdge(n1,n2);
    this.E[n1][n2] = null;
    return result;
  }
  public int nodeCount(){
    return this.size;
  }
  public int edgeCount(){
    int count = 0;
    for(Object[] o1 : this.E){
      for(Object o2 : o1){
        if(o2 != null){
          count += 1;
        }
      }
    }
    if(this.directed){
      return count/2;
    }
    return count;
  }
  public int getIndex(T t){
    return 0;
  }
  public void expand(){

  }
  // public ArrayList<T> DFS(int s)
  // public ArrayList<T> BFS(int s)
}
