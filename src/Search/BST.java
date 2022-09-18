package Search;

import Tool.Queue;
import Tool.StdIn;

import java.util.Iterator;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;
        public Node(Key key,Value value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    public int size(){
        return size(root);
    }
    public int size(Node x){
        if(x==null) return 0;
        else return x.N;
    }
    //外部调用的put方法，需要返回根结点给root
    private void put(Key key,Value value){
        root = put(root, key,value);
    }
    private Node put(Node x,Key key,Value value){
        if(x==null)
            return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if(cmp<0)
            x.left = put(x.left, key,value);
        else if(cmp>0)
            x.right = put(x.right,key,value);
        else
            x.value = value;
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        if(x==null) return  null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if(cmp>0) return get(x.right,key);
        else return x.value;
    }
    //自己书写，且通过了简单测试的方法
//    public Key min(){
//        return min(root);
//    }
//    private Key min(Node x){
//        if(x.left==null) return x.key;
//        else
//            return min(x.left);
////        Key key = x.key;
////        if(x.left!=null) key = min(x.left);
////        return key;
//    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }
    public Key floor(Key key){
        Node x = floor(root,key);
        if(x==null) return null;
        return x.key;
    }
    private Node floor(Node x,Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp<0) return floor(x.left,key);
        Node t = floor(x.right, key);
        if(t!=null) return t;
        else return x;
    }
    public Key ceiling(Key key){
        Node x = ceiling(root,key);
        if(x==null) return null;
        return  x.key;
    }
    private Node ceiling(Node x,Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp>0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if(t==null) return x;
        else return t;
    }
    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x,int k){
        if(x==null) return null;
        int t = size(x.left);
        if(k==t) return x;
        else if(k<t) return select(x.left, k);
        else return select(x.right, k-t-1);
    }
    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node x,Key key){
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp==0) return size(x.left);
        else if(cmp<0) return rank(x.left,key);
        else {
            int t = size(x.left);
            return rank(x.right,key)+t+1;
        }
    }
    public void show(){
        show(root);
        System.out.println();
    }
    public int show(Node x){
        if(x==null) return 0;
        if(show(x.left)==0){
            System.out.print(x.key+" ");
        }
        show(x.right);
        return 0;
    }
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if(x.right==null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left)+size(x.right)+1;//别忘了加1
        return x;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node x,Key key){
        if(x==null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(x.left, key);
        else if(cmp>0) x.right = delete(x.right,key);
        else {
            if(x.right==null) return x.left;
            if(x.left==null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }
    public void keys(Node x,Queue<Key> queue,Key lo,Key hi){
        if(x==null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo<0) keys(x.left,queue,lo,hi);
        if(cmplo<=0&&cmphi>=0) queue.enqueue(x.key);
        if(cmphi>0) keys(x.right,queue,lo,hi);
    }
    public static void main(String[] args) {
        BST<String,Integer> st = new BST<String,Integer>();
        for(int i=0;!StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        System.out.println(st.min());
        System.out.println(st.max());
        System.out.println(st.floor("D"));
        System.out.println(st.ceiling("D"));
        System.out.println(st.select(5));
        System.out.println(st.rank("A"));
        st.show();
        //st.deleteMin();;
        //st.show();
        st.delete("P");
        for(String s:st.keys())
            System.out.println(s+" "+st.get(s));
    }
}
