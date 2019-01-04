package src.graph;
import src.list.ArrayList;
import src.util.GraphNode;
import src.util.GraphEdge;
import src.pq.HeapPriorityQueue;
import src.queue.Queue;
import src.queue.Stack;
public class ListGraph<T> extends Graph<T> {
  private WeightedListGraph<T,Boolean> data;
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
    this.data = new WeightedListGraph<T,Boolean>(s,d);
    directed = d;
  }
  public int addNode(T t){
    return this.data.addNode(t);
  }
  public void addEdge(int n1, int n2){
    this.data.addEdge(n1,n2,true);
  }
  public boolean containsNode(T t){
    return this.data.containsNode(t);
  }
  public boolean containsEdge(int n1, int n2){
    return this.data.containsEdge(n1,n2);
  }
  public T getNode(int n){
    return this.data.getNode(n).get();
  }
  public boolean getEdge(int n1, int n2){
    return this.data.getEdge(n1,n2);
  }
  public T removeNode(int n){
    return this.data.removeNode(n).get();
  }
  public boolean removeEdge(int n1, int n2){
    return this.data.removeEdge(n1,n2);
  }
  public int nodeCount(){
    return this.data.nodeCount();
  }
  public int edgeCount(){
    return this.data.edgeCount();
  }
  public int getIndex(T t){
    return this.data.getIndex(t);
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
        for(int next : this.data.getNode(current).children()){
          q.push(next);
        }
      }
    }
    ArrayList<T> result = new ArrayList<T>(disc.size());
    for(int n : disc){
      result.add(getNode(n));
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
        for(int next : this.data.getNode(current).children()){
          q.push(next);
        }
      }
    }
    ArrayList<T> result = new ArrayList<T>(disc.size());
    for(int n : disc){
      result.add(getNode(n));
    }
    return result;
  }
}
