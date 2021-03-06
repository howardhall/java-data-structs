package src;
import src.list.*;
import src.map.*;
import src.pq.*;
import src.queue.*;
import src.set.*;
import src.tree.*;
import src.util.*;
import src.graph.*;
public class test {
  public static void main(String[] args) {
    GraphTest();
  }
  public static void RedBlackBinarySearchTreeTest(){
    RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<Integer>();
    //final int[] nums = {5,3,7,2,4,6,8};
    final int[] nums = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
    for(int i : nums){
      tree.add(i);
    }
    System.out.println(tree.removeMax());
  }
  public static void LinkedHashSetTest(){
    LinkedHashSet<String> s = new LinkedHashSet<String>(12);
    for(int i=0;i<144;i+=6){
      s.add(String.valueOf(i));
    }
    System.out.println(s);
    for(String q : s){
      System.out.println("item");
    }
    System.out.println(s.size());
  }
  public static void GraphTest2(){
    MatrixGraph<String> g = new MatrixGraph<String>(12);
    for(int i=0;i<12;i++){
      g.addNode("Node "+String.valueOf(i));
    }
    g.addEdge(1,3);
    g.addEdge(5,3);
    g.addEdge(1,1);
    g.addEdge(1,7);
    g.addEdge(2,9);
    g.addEdge(2,0);
    g.addEdge(0,7);
    System.out.println(g.getEdge(3,1));
    System.out.println(g);
  }
  public static void GraphTest(){
    ListGraph<String> g = new ListGraph<String>(15,true);
    for(int i=0;i<12;i++){
      g.addNode("Node "+String.valueOf(i));
    }
    g.addEdge(1,8);
    g.addEdge(1,3);
    g.addEdge(5,3);
    g.addEdge(8,4);
    g.addEdge(6,4);
    g.addEdge(6,11);
    g.addEdge(1,1);
    g.addEdge(1,7);
    g.addEdge(2,9);
    g.addEdge(2,0);
    g.addEdge(0,7);
    System.out.println(g.BFS(1));
    System.out.println(g.DFS(1));
  }
  public static void BinaryTreeTest(){
    BinarySearchTree<Integer> tree =  new BinarySearchTree<Integer>();
    for(int i=5;i<15;i++){
      tree.add(i%10);
    }
    System.out.println(tree.toString(1));
    System.out.println(tree.toString(2));
    System.out.println(tree.toString(3));
  }
  public static void PQtest(){
    ArrayPriorityQueue<Short,String> pq = new ArrayPriorityQueue<Short,String>(2);
    pq.add((short) 4,"first");
    pq.add((short) 12,"second");
    pq.add((short) 99,"tenth");
    pq.add((short) 65,"ninth");
    pq.add((short) 41,"sixth");
    pq.add((short) 51,"seventh");
    pq.add((short) 19,"third");
    pq.add((short) 36,"fifth");
    pq.add((short) 22,"fourth");
    pq.add((short) 64,"eighth");
    //pq.updateKey((short)0, "fifth");
    System.out.println("\n\n"+pq+"\n\n");
    while(!pq.isEmpty()){
      System.out.println(pq.remove());
    }
     HeapPriorityQueue<Integer,String> pq2 = new HeapPriorityQueue<Integer,String>(4);
    for(int i=1;i<13;i++){
      pq2.add(i%7,String.valueOf(i%7));
    }
    System.out.println(pq2);
  }
  public static void SetTest(){
    Set<Integer> s = new HashSet<Integer>(5);
    Set<Integer> t = new ArraySet<Integer>();
    for(int i=0;i<40;i++){
      s.add(i%15);
      t.add(i%22);
    }
    s.remove(12);
    s.remove(6);
    System.out.println(s.contains(5));
    s.add(5);
    System.out.println(s);
    System.out.println(t);
  }
  public static void ArrayMapTest(){
    ArrayMap<Double,String> map = new ArrayMap<Double,String>();
    for(int i=0;i<241;i++){
      map.add((double) i%60,String.valueOf(i));
    }
    System.out.println(map);
    System.out.println(map.size());
    map.remove(29.0);
    System.out.println(map.size());
    for(int i=0;i<5;i++){
      System.out.println(map.remove(12.0));
    }
    System.out.println(map.get(1.0));
    map.set(30.0,"hey guys");
    System.out.println(map);
    System.out.println(map.get(30.0));
  }
  public static void HashmapTest(){
    Map<Integer,String> map = new LinkedHashMap<Integer,String>();
    for(int i=0;i<241;i++){
      map.add(i%50,String.valueOf(i));
    }
    System.out.println(map);
    System.out.println(map.size());
    map.removeAll(29);
    System.out.println(map.size());
    for(int i=0;i<5;i++){
      System.out.println(map.remove(12));
    }
    System.out.println(map.get(1));
    map.set(30,"hey guys");
    System.out.println(map);
    System.out.println(map.get(30));
    for(Pair<Integer,String> p : map){
      System.out.println(p);
    }

  }
  public static void StackQueueTest(){
    Deque<Double> s = new Deque<Double>();
    Deque<Double> q = new Deque<Double>();
    double[] vals = {1.0, 2.0, 3.0, 4.0};
    for(double item : vals){
      s.push(item);
      q.push(item);
    }
    System.out.println(s.pop());
    System.out.println(q.pull());
  }
  public static void ArrayListTest(){
    List<String> al = new ArrayList<String>();
    List<String> ll = new LinkedList<String>();
    for(int i=0;i<35;i++){
      String text = String.valueOf(i);
      al.add("ArrayList : "+text);
      ll.add("LinkedList : "+text);
    }
    //System.out.println(al.remove(3));
    System.out.println(al);
    al.add("lmao");
    //al.removeRange(2,12);
    System.out.println(al.get(0));
    System.out.println(al);
    System.out.println(al.size());
    System.out.println(al.indexOf("lmao"));
    for(String s : ll){
      System.out.println(s);
    }
  }
}
