package Search;
public class SequentialSearchST<Key,Value> {
    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    private Node first;
    public void put(Key k,Value v){
        for(Node n = first;n!=null;n=n.next){
            if(k.equals(n.key)){
                n.val = v;
                return;
            }
        }
        first = new Node(k,v,first);
    }
    public Value get(Key k){
        for(Node n = first;n!=null;n=n.next){
            if(k.equals(n.key)){
                return n.val;
            }
        }
        return null;
    }
    public int size(){
        int n=0;
        Node x = first;
        while(x!=null){
            n++;
            x = x.next;
        }
        return n;
    }
    public void delete(Key k){
        if(first.key.equals(k)) {
            first.key = null;
            first.val = null;
            first = first.next;
            return;
        }
        Node x = first;
        while(x.next!=null){
            if(x.next.key.equals(k)){
                x.next.key=null;
                x.next.val=null;
                x.next = x.next.next;
            }
            x = x.next;
        }

    }
}
