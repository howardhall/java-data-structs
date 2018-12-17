package src.util;
import java.lang.Comparable;
public class TreeNode<E extends Comparable<E>> implements Comparable<E>{
  private E data;
  private TreeNode<E> left;
  private TreeNode<E> right;
  public TreeNode(E e){
    this.data = e;
    this.left = null;
    this.right = null;
  }
  public E get(){
    return data;
  }
  public void set(E e){
    this.data = e;
  }
  public TreeNode<E> getLeft(){
    return this.left;
  }
  public TreeNode<E> getRight(){
    return this.right;
  }
  public void setLeft(E e){
    this.setLeft(new TreeNode<E>(e));
  }
  public void setRight(E e){
    this.setRight(new TreeNode<E>(e));
  }
  public void setLeft(TreeNode<E> tn){
    this.left = tn;
  }
  public void setRight(TreeNode<E> tn){
    this.right = tn;
  }
  public int compareTo(E e){
    return this.data.compareTo(e);
  }
}
