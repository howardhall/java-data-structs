package src.graph;
import src.list.ArrayList;
import src.util.GraphNode;
import src.util.GraphEdge;
import src.queue.Queue;
import src.queue.Stack;
public class ListGraph<T,W extends Number> {
  private ArrayList<GraphNode<T,W>> V;
  private boolean directed;
  public ListGraph(){
    this(10,false);
  }
  public ListGraph(int s){
    this(s,false);
  }
  public ListGraph(boolean d){
    this(10,d);
  }
  public ListGraph(int s, boolean d){
    V = new ArrayList<GraphNode<T,W>>(s);
    directed = d;
  }
  public int addNode(T t){
    V.add(new GraphNode<T,W>(t));
    return V.size()-1;
  }
  public void addEdge(int n1, int n2, W w){
    if(n1 < 0 || n2 < 0 || n1 > V.size() || n2 > V.size()){
      return;
    }
    V.get(n1).addEdge(n2,w);
    if(!directed){
      V.get(n2).addEdge(n1,w);
    }
  }
  public boolean containsNode(T t){
    for(GraphNode<T,W> n : V){
      if(n.equal(t)){
        return true;
      }
    }
    return false;
  }
  public boolean containsEdge(int n1, int n2){
    if(n1 < 0 || n2 < 0 || n1 > V.size() || n2 > V.size()){
      return false;
    }
    return V.get(n1).hasEdge(n2);
  }
  public GraphNode<T,W> removeNode(int n){
    return V.remove(n);
  }
  public W removeEdge(int n1, int n2){
    if(n1 < 0 || n2 < 0 || n1 > V.size() || n2 > V.size()){
      return null;
    }
    if(!directed){
      V.get(n2).removeEdge(n1);
    }
    return V.get(n1).removeEdge(n2);
  }
  public GraphNode<T,W> getNode(int n){
    if(n < 0 || n > V.size()){
      return null;
    }
    return V.get(n);
  }
  public int getIndex(T t){
    for(int i=0;i<V.size();i++){
      if(V.get(i).equal(t)){
        return i;
      }
    }
    return -1;
  }
  public W getEdge(int n1, int n2){
    if(n1 < 0 || n2 < 0 || n1 > V.size() || n2 > V.size()){
      return null;
    }
    return V.get(n1).getEdge(n2);
  }
  public int nodeCount(){
    return V.size();
  }
  public int edgeCount(){
    int size = 0;
    for(GraphNode<T,W> t : V){
      size += t.degree();
    }
    return size;
  }
  public ArrayList<T> DFS(int s){
    ArrayList<Integer> disc = new ArrayList<Integer>();
    Stack<Integer> q = new Stack<Integer>();
    q.push(s);
    int current;
    while(!q.isEmpty()){
      current = q.pop();
      if(!disc.contains(current)){
        disc.add(current);
        for(int next : getNode(current).children()){
          q.push(next);
        }
      }
    }
    ArrayList<T> result = new ArrayList<T>(disc.size());
    for(int n : disc){
      result.add(getNode(n).get());
    }
    return result;
  }
  public ArrayList<T> BFS(int s){
    //TODO switch to linkedhashset
    ArrayList<Integer> disc = new ArrayList<Integer>();
    Queue<Integer> q = new Queue<Integer>();
    q.push(s);
    int current;
    while(!q.isEmpty()){
      current = q.pull();
      if(!disc.contains(current)){
        disc.add(current);
        for(int next : getNode(current).children()){
          q.push(next);
        }
      }
    }
    ArrayList<T> result = new ArrayList<T>(disc.size());
    for(int n : disc){
      result.add(getNode(n).get());
    }
    return result;
  }
}
