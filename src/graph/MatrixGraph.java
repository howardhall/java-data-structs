package src.graph;
import src.list.ArrayList;
public class MatrixGraph<T> {
  private Object[] V;
  private boolean[][] E;
  private int size;
  private int capacity;
  private boolean directed;
  public MatrixGraph(){
    this(10,false);
  }
  public MatrixGraph(int s){
    this(s,false);
  }
  public MatrixGraph(boolean d){
    this(10,d);
  }
  public MatrixGraph(int s, boolean d){
    capacity = s;
    V = new Object[s];
    E = new boolean[s][s];
    directed = d;
  }
  public int addNode(T t){
    if(size>=capacity){
      expand();
    }
    V[size] = t;
    return size++;
  }
  public void addEdge(int n1, int n2){
    if(n1 == n2){
      return;
    }
    E[n1][n2] = true;
    if(!directed){
      E[n2][n1] = true;
    }
  }
  public boolean containsNode(T t){
    return getIndex(t) != -1;
  }
  public boolean containsEdge(int n1, int n2){
    if(n1 < 0 || n2 < 0 || n1 > size || n2 > size){
      return false;
    }
    return E[n1][n2];
  }
  public T removeNode(int n){
    if(n < 0 || n > size){
      return null;
    }
    @SuppressWarnings("unchecked")
    T t = (T) V[n];
    Object[] v2 = new Object[size-1];
    if(n > 0){
      System.arraycopy(V,0,v2,0,n);
    }
    if(n < size-1){
      System.arraycopy(V,n+1,v2,n,size-n-1);
    }
    V = v2;
    boolean[][] e2 = new boolean[size-1][size-1];
    int k;
    for(int i=0;i<size;i++){
      if(i==n){
        continue;
      }
      for(int j=0;j<size;j++){
        k = (j>n)?j-1:j;
        e2[i][k] = E[i][j];
      }
    }
    E = e2;
    this.size--;
    return t;
  }
  private void expand(){
    expand(size*2);
  }
  private void expand(int s){
    if(s < size){
      return;
    }
    Object[] V2 = new Object[s];
    System.arraycopy(V,0,V2,0,size);
    boolean[][] E2 = new boolean[s][s];
    for(int i=0;i<size;i++){
      System.arraycopy(E[i],0,E2[i],0,size);
    }
    size = s;
  }
  public boolean removeEdge(int n1, int n2){
    if(n1 < 0 || n2 < 0 || n1 > size || n2 > size){
      return false;
    }
    boolean r = E[n1][n2];
    E[n1][n2] = false;
    if(!directed){
      E[n2][n1] = false;
    }
    return r;
  }
  public T getNode(int n){
    if(n < 0 || n > size){
      return null;
    }
    @SuppressWarnings("unchecked")
    T t = (T) V[n];
    return t;
  }
  public int getIndex(T t){
    for(int i=0;i<size;i++){
      if(V[i].equals(t)){
        return i;
      }
    }
    return -1;
  }
  public boolean getEdge(int n1, int n2){
    return containsEdge(n1,n2);
  }
  public int nodeCount(){
    return size;
  }
  public int edgeCount(){
    int s = 0;
    for(boolean[] b2 : E){
      for(boolean b : b2){
        if(b){
          s++;
        }
      }
    }
    return s;
  }
  public String toString(){
    String s = "        |";
    for(Object o : V){
      s += String.format("%8.8s|",o.toString());
    }
    if(size > 0){
      s = s.substring(0,s.length()-2);
    }
    s += "\n";
    for(int i=0;i<size;i++){
      s += String.format("%8.8s|",V[i].toString());
      for(int j=0;j<size;j++){
        if(E[i][j]){
          s += "   ><   |";
        } else {
          s += "        |";
        }
      }
      s += "\n";
    }
    return s;
  }
}
