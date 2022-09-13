package Search;

import Tool.StdIn;

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
    public static void main(String[] args) {
        BST<String,Integer> st = new BST<String,Integer>();
        for(int i=0;!StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        System.out.println(st.min());
    }
}
