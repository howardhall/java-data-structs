package src.graph;
public abstract class Graph<T> implements iGraph<T> {
  protected boolean directed;
  public boolean isDirected(){
    return directed;
  }
  public abstract void addEdge(int n1, int n2);
  public abstract T getNode(int n);
  public abstract boolean getEdge(int n1, int n2);
  public abstract T removeNode(int n);
  public abstract boolean removeEdge(int n1, int n2);
}
