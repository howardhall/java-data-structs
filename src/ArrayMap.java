public class ArrayMap<K,V>{
  private ArrayList<Pair<K,V>> data;
  public ArrayMap(){
    this.data = new ArrayList<Pair<K,V>>();
  }
  public void add(K k, V v){
    this.data.add(new Pair<K,V>(k,v));
  }
  public V get(K k){
    return null;
  }
  public boolean contains(K k){
    return false;
  }
  public boolean contains(K k, V v){
    return false;
  }
  public void clear(){

  }
  public void set(K k, V v){

  }
  public void set(K k, V v1, V v2){

  }
  public boolean isEmpty(){
    return false;
  }
  public int size(){
    return -1;
  }
  public V remove(K k){
    return null;
  }
  public boolean remove(K k, V v){
    return false;
  }
  public void removeAll(K k){

  }
  public String toString(){
    String result = "ArrayMap : [";
    for(Pair<K,V> elem : data){
      result += elem.toString() + ", ";
    }
    result = result.substring(0,result.length()-2);
    return result + "]";
  }
}
