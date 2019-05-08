package src.tree;
import java.lang.Comparable;
import src.util.RBTreeNode;
public class RedBlackBinaryTree<E extends Comparable<E>> {
  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private RBTreeNode<E> root;
  private int size;
  public RedBlackBinaryTree(){
    this.clear();
  }
  public void add(E e){
    this.root = this.addToSubTree(e,this.root);
    this.size++;
  }
  private RBTreeNode<E> addToSubTree(E e,RBTreeNode<E> n){
    if(n == null){
      return new RBTreeNode<E>(e,RED);
    }
    if(n.get().compareTo(e) > 0){
      n.setLeft(this.addToSubTree(e,n.getLeft()));
    } else {
      n.setRight(this.addToSubTree(e,n.getRight()));
    }
    return n;
  }
  public E remove(){
    return removeMin();
  }
  public E removeMin(){
    RBTreeNode<E> n = root;
    while(n.getLeft() != null){
      n = n.getLeft();
    }
    E e = n.get();
    if(this.root.getLeft().isBlack() && this.root.getRight().isBlack()){
      root.setColour(RED);
    }
    root = this.removeMin(root);
    root.setColour(BLACK);
    return e;
  }
  private RBTreeNode<E> removeMin(RBTreeNode<E> n){
    if(n.getLeft() == null){
      return null;
    }
    if(n.getLeft().isBlack() && n.getLeft().getLeft().isBlack()){
      n = this.redLeft(n);
    }
    n.setLeft(this.removeMin(n.getLeft()));
    return this.balance(n);
  }
  public E removeMax(){
    RBTreeNode<E> n = root;
    while(n.getRight() != null){
      n = n.getRight();
    }
    E e = n.get();
    if(this.root.getLeft().isBlack() && this.root.getRight().isBlack()){
      root.setColour(RED);
    }
    root = this.removeMax(root);
    return e;
  }
  private RBTreeNode<E> removeMax(RBTreeNode<E> n){
    if(n.getLeft().isRed()){
      n = this.rotateRight(n);
    }
    if(n.getRight() == null){
      return null;
    }
    if(n.getRight().isBlack() && n.getRight().getLeft().isBlack()){
      n = this.redRight(n);
    }
    n.setRight(this.removeMax(n.getRight()));
    return this.balance(n);
  }
  public void clear(){
    this.root = null;
    this.size = 0;
  }
  public int size(){
    return this.size;
  }
  public boolean isEmpty(){
    return this.size == 0;
  }
  public boolean contains(E e){
    RBTreeNode<E> curr = root;
    while(curr != null){
      if(e.compareTo(curr.get()) == 0){
        return true;
      } else if(e.compareTo(curr.get()) < 0){
        curr = curr.getLeft();
      } else {
        curr = curr.getRight();
      }
    }
    return false;
  }
  private RBTreeNode<E> balance(RBTreeNode<E> n){
    if(n.getLeft() == null || n.getRight() == null || n.getLeft().getLeft() == null){
      return n;
    }
    if(n.getRight().isRed()){
      n = this.rotateLeft(n);
    }
    if(n.getLeft().isRed() && n.getLeft().getLeft().isRed()){
      n = this.rotateRight(n);
    }
    if(n.getLeft().isRed() && n.getRight().isRed()){
      n.flipColors();
    }
    return n;
  }
  public RBTreeNode<E> rootNode(){
    return root;
  }
  public E root(){
    return this.root.get();
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
  public String preOrder(RBTreeNode<E> n){
    if(n == null){
      return "";
    }
    String s = "";
    s += n.get().toString() + ", ";
    s += this.preOrder(n.getLeft());
    s += this.preOrder(n.getRight());
    return s;
  }
  public String inOrder(RBTreeNode<E> n){
    if(n == null){
      return "";
    }
    String s = "";
    s += this.inOrder(n.getLeft());
    s += n.get().toString()+ ", ";
    s += this.inOrder(n.getRight());
    return s;
  }
  public String postOrder(RBTreeNode<E> n){
    if(n == null){
      return "";
    }
    String s = "";
    s += this.postOrder(n.getLeft());
    s += this.postOrder(n.getRight());
    s += n.get().toString() + ", ";
    return s;
  }
  private RBTreeNode<E> redLeft(RBTreeNode<E> n){
    n.flipColors();
    if(n.getRight().getLeft().isRed()){
      n.setRight(this.rotateRight(n.getRight()));
      n = this.rotateLeft(n);
      n.flipColors();
    }
    return n;
  }
  private RBTreeNode<E> redRight(RBTreeNode<E> n){
    n.flipColors();
    if(n.getLeft().getLeft().isRed()){
      n = this.rotateRight(n);
      n.flipColors();
    }
    return n;
  }
  private RBTreeNode<E> rotateLeft(RBTreeNode<E> n){
    RBTreeNode<E> x = n.getLeft();
    n.setLeft(x.getRight());
    x.setRight(n);
    x.setColour(x.getRight().getColour());
    x.getRight().setColour(RED);
    return x;
  }
  private RBTreeNode<E> rotateRight(RBTreeNode<E> n){
    RBTreeNode<E> x = n.getRight();
    if(x != null){
      n.setRight(x.getLeft());
      x.setLeft(n);
      x.setColour(x.getLeft().getColour());
      x.getLeft().setColour(RED);
    }
    return x;
  }
  private RBTreeNode<E> moveLeft(RBTreeNode<E> n){
    n.flipColors();
    if(n.getRight().getLeft().getColour() == RED){
      n.setRight(rotateRight(n.getRight()));
      n = rotateLeft(n);
      n.flipColors();
    }
    return n;
  }
  private RBTreeNode<E> moveRight(RBTreeNode<E> n){
    n.flipColors();
    if(n.getLeft().getRight().getColour() == RED){
      n.setLeft(rotateLeft(n.getLeft()));
      n = rotateRight(n);
      n.flipColors();
    }
    return n;
  }
}
