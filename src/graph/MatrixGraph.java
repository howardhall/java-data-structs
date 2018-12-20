package src.graph;
import src.map.ArrayList;
public class MatrixGraph<T,W extends Number> {
  private ArrayList<T> V;
  private ArrayList<ArrayList<W>> E;
  private int size;
  private boolean directed;
  public MatrixGraph(){
    this(10,false);
  }
  public MatrixGraph(int size){
    this(size,false);
  }
  public MatrixGraph(boolean directed){
    this(10,directed);
  }
  public MatrixGraph(int size,boolean directed){
    this.V = new ArrayList<T>(size);
    this.E = new ArrayList<ArrayList<W>>(size);
    for(ArrayList<W> set : this.E){
      set = new ArrayList<W>(size);
    }
    this.size = 0;
    this.directed = directed;
  }
  public int addNode(T t){
    this.ensureCapacity(++this.size);
    this.V.add(t);
    return this.size - 1;
  }
  public void addEdge(int n1, int n2, W weight){
    if(n1 < 0 || n2 < 0 || n1 > this.size || n2 > this.size){
      return;
      //TODO exception
    }
    this.E.get(n1).set(n2,weight);
    if(!this.directed){
      this.E.get(n2).set(n1,weight);
    }
  }
  public boolean containsNode(T t){
    return this.V.contains(t);
  }
  public boolean containsEdge(int n1, int n2){
    return this.E.get(n1).get(n2) != null;
  }
  public int getNode(T t){
    return this.V.indexOf(t);
  }
  public W getEdge(int n1, int n2){
    return this.E.get(n1).get(n2);
  }
  public T removeNode(int i);
  public W removeEdge(int n1, int n2)
  public ensureCapacity(int size){
    this.V.ensureCapacity(size);
    this.E.ensureCapacity(size);
    for(ArrayList<W> w : this.E){
      w.ensureCapacity(size);
    }
  }
}
