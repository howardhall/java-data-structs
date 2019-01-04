package src.graph;
public abstract class WeightedGraph<T,W> implements iGraph<T> {
  protected boolean directed;
  public boolean isDirected(){
    return directed;
  }
  public abstract void addEdge(int n1, int n2, W w);
  public abstract W getEdge(int n1, int n2);
  public abstract W removeEdge(int n1, int n2);
}
