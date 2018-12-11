public class test {
  public static void main(String[] args) {
    StackQueueTest();
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
