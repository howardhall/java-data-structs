public class test {
  public static void main(String[] args) {
    SetTest();
  }
  public static void SetTest(){
    ArraySet<Integer> s = new ArraySet<Integer>();
    for(int i=0;i<40;i++){
      s.add(i%15);
    }
    s.remove(12);
    s.remove(6);
    System.out.println(s.contains(5));
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
    Stack<Double> s = new Stack<Double>();
    Queue<Double> q = new Queue<Double>();
    double[] vals = {1.0, 2.0, 3.0, 4.0};
    for(double item : vals){
      s.push(item);
      q.push(item);
    }
    System.out.println(s.peek());
    System.out.println(q.peek());
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
}
