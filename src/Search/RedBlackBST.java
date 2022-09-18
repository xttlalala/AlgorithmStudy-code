package Search;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        boolean color;
        public Node(Key key, Value value, boolean color, int N) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.N = N;
        }
    }
    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color==RED;
    }
    public int size(){
        return size(root);
    }
    public int size(Node x){
        if(x==null) return 0;
        else return x.N;
    }
    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }
    Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.right)+size(h.left)+1;
        return x;
    }
    
}
