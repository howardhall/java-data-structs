package src.util;
public class GraphEdge<W> {
  private W weight;
  private int dest;
  public GraphEdge(){
    this(-1,null);
  }
  public GraphEdge(int e, W w){
    dest = e;
    weight = w;
  }
  public boolean equals(int d){
    return dest == d;
  }
  public W getWeight(){
    return weight;
  }
  public int getDest(){
    return dest;
  }
}
