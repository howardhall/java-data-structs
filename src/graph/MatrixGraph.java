package src.graph;
import src.list.ArrayList;
// import java.util.ArrayList;
public class MatrixGraph<T,W> {
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
  public MatrixGraph(int size, boolean directed){
    System.out.println("make");
    this.V = new ArrayList<T>(size);
    this.E = new ArrayList<ArrayList<W>>(size);
    for(int i=0;i<size;i++){
      this.E.add(new ArrayList<W>(size));
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
  public T removeNode(int i){
    this.E.remove(i);
    for(ArrayList<W> w : this.E){
      w.remove(i);
    }
    return this.V.remove(i);
  }
  public W removeEdge(int n1, int n2){
    W w = this.E.get(n1).get(n2);
    this.E.get(n1).set(n2,null);
    return w;
  }
  public void updateNode(int i, T t){
    this.V.set(i,t);
  }
  public void updateWeight(int n1, int n2, W w){
    this.addEdge(n1,n2,w);
  }
  public void ensureCapacity(int size){
    this.V.ensureCapacity(size);
    for(ArrayList<W> w : this.E){
      w.ensureCapacity(size);
    }
    this.E.ensureCapacity(size);
    for(int i=this.size;i<size;i++){
      this.E.add(new ArrayList<W>(size));
    }
  }
  public String toString(){
    String result = "";
    for(int i=0;i<this.size;i++){
      result += this.V.get(i).toString() + " :   ";
      // for(int j=0;j<this.size;j++){
      //   if(!this.E.get(i).get(j).equals(null)){
      //     result += this.V.get(j).toString() + ", ";
      //   }
      // }
      result = result.substring(0,result.length()-2) + "\n";
    }
    return result;
  }
}
