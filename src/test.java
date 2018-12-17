package src;
import src.pq.HeapPriorityQueue;
import src.tree.BinarySearchTree;
public class test {
  public static void main(String[] args) {
    BinaryTreeTest();
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
    HeapPriorityQueue<Short,String> pq = new HeapPriorityQueue<Short,String>(2);
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
    pq.updateKey((short)0, "fifth");
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
  /*
  public static void SetTest(){
    HashSet<Integer> s = new HashSet<Integer>(5);
    for(int i=0;i<40;i++){
      s.add(i%15);
    }
    s.remove(12);
    s.remove(6);
    System.out.println(s.contains(5));
    s.add(5);
    System.out.println(s);
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
    HashMap<Integer,String> map = new HashMap<Integer,String>();
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
    ArrayList<String> al = new ArrayList<String>();
    LinkedList<String> ll = new LinkedList<String>();
    for(int i=0;i<5;i++){
      String text = String.valueOf(i);
      al.add("ArrayList : "+text);
      ll.add("LinkedList : "+text);
    }
    System.out.println(al.remove(3));
    System.out.println(al);
    al.add("lmao");
    System.out.println(al.get(0));
    System.out.println(al);
    System.out.println(al.size());
    System.out.println(al.indexOf("lmao"));
  }
  */
}
