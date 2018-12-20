public interface iGraph<E> {
  public void addNode(E e);
  public void addEdge(E e1, E e2);
  public boolean containsNode(E e);
  public boolean containsEdge(E e1, E e2);
  public void removeNode(E e);
  public void removeEdge(E e1, E e2);
  public int nodeCount();
  public int edgeCount();
  //public ArrayList<Pair<GraphNode<E>,Integer>> dijkstra(); weighted.
}
