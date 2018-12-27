package src.util;
public class RBTreeNode<E extends Comparable<E>> {
  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private E data;
  private RBTreeNode<E> left;
  private RBTreeNode<E> right;
  private boolean colour; // British spelling is better, FIGHT ME.
  //private int size;
  public RBTreeNode(E e, boolean c){
    data = e;
    colour = c;
    left = null;
    right = null;
  }
  public boolean isRed(){
    return colour;
  }
  public int size(int in){
    if(left != null){
      in += left.size();
    }
    if(right != null){
      in += right.size();
    }
    return in;
  }
  public int size(){
    return size(0);
  }
  public E get(){
    return data;
  }
  public void set(E e){
    data = e;
  }
  public RBTreeNode<E> getLeft(){
    return left;
  }
  public RBTreeNode<E> getRight(){
    return right;
  }
  public void setLeft(E e){
    setLeft(new RBTreeNode<E>(e,RED));
  }
  public void setRight(E e){
    setRight(new RBTreeNode<E>(e,RED));
  }
  public void setLeft(RBTreeNode<E> n){
    left = n;
  }
  public void setRight(RBTreeNode<E> n){
    right = n;
  }
  public boolean getColour(){
    return colour;
  }
  public void setColour(boolean c){
    colour = c;
  }
  public String toString(){
    String colourString = (colour)?"Red}":"Black}";
    return "{"+data.toString()+":"+colourString;
  }
  public void flip(){
    colour = !colour;
  }
  public void flipColors(){
    flip();
    if(left != null){
      left.flip();
    }
    if(right != null){
      right.flip();
    }
  }
}
