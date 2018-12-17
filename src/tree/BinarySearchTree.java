package src.tree;
import java.lang.Comparable;
import src.util.TreeNode;
public class BinarySearchTree<E extends Comparable<E>> implements iTree<E> {
  private TreeNode<E> root;
  private int size;
  public BinarySearchTree(){
    this.root = null;
    this.size = 0;
  }
  public BinarySearchTree(E e){
    this.root = new TreeNode<E>(e);
    this.size = 1;
  }
  public void add(E e){
    this.root = this.addToSubTree(e,this.root);
  }
  private TreeNode<E> addToSubTree(E e,TreeNode<E> n){
    if(n == null){
      return new TreeNode<E>(e);
    }
    if(n.get().compareTo(e) > 0){
      n.setLeft(this.addToSubTree(e,n.getLeft()));
    } else {
      n.setRight(this.addToSubTree(e,n.getRight()));
    }
    return n;
  }
  public E remove(){
    return null;
  }
  public E remove(E e){
    TreeNode<E> ptr = root;
    while(ptr != null){
      if(ptr.compareTo(e) > 0){
        ptr = ptr.getLeft();
      } else if(ptr.compareTo(e) < 0){
        ptr = ptr.getRight();
      } else {
        TreeNode<E> target = ptr;
        TreeNode<E> ptr2;
        ptr2 = target.getRight();
        if(ptr2 != null){
          while(ptr2.getLeft() != null){
            ptr2 = ptr2.getLeft();
          }
        }
        target = ptr2;
        target.setLeft(ptr.getLeft());
        target.setRight(ptr.getRight());
        return ptr.get();
      }
    }
    return null;
  }
  public boolean contains(E e){
    TreeNode<E> ptr = root;
    while(ptr != null){
      if(ptr.compareTo(e) > 0){
        ptr = ptr.getLeft();
      } else if(ptr.compareTo(e) < 0){
        ptr = ptr.getRight();
      } else {
        return true;
      }
    }
    return false;
  }
  public void update(E e1, E e2){
    return;
  }
  public E root(){
    return this.root.get();
  }
  public void print(){
    this.printNode(this.root);
  }
  private void printNode(TreeNode<E> n){
    if(n == null){
      return;
    }
    this.printNode(n.getLeft());
    System.out.println(n.get());
    this.printNode(n.getRight());
  }
  public String toString(){
    return this.toString(2);
  }
  public String toString(int i){
    String s;
    if( i == 1){
      s = "Pre order: "+this.preOrder(this.root);
    } else if (i == 2){
      s = "In order: "+ this.inOrder(this.root);
    } else if (i == 3){
      s = "Post order: "+ this.postOrder(this.root);
    } else {
      s = "Exception  ";
    }
    return s.substring(0,s.length()-2);
  }
  public String preOrder(TreeNode<E> n){
    if(n == null){
      return "";
    }
    String s = "";
    s += n.get().toString() + ", ";
    s += this.preOrder(n.getLeft());
    s += this.preOrder(n.getRight());
    return s;
  }
  public String inOrder(TreeNode<E> n){
    if(n == null){
      return "";
    }
    String s = "";
    s += this.inOrder(n.getLeft());
    s += n.get().toString()+ ", ";
    s += this.inOrder(n.getRight());
    return s;
  }
  public String postOrder(TreeNode<E> n){
    if(n == null){
      return "";
    }
    String s = "";
    s += this.postOrder(n.getLeft());
    s += this.postOrder(n.getRight());
    s += n.get().toString() + ", ";
    return s;
  }
}
