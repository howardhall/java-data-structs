package src.graph;
public interface iGraph<T> {
  public int addNode(T t);
  public boolean containsNode(T t);
  public boolean containsEdge(int n1, int n2);
  public int nodeCount();
  public int edgeCount();
  public int getIndex(T t);
}
