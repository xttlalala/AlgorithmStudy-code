package Base;


public class LinkedlistStack<Item>  {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return  N;
    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public void write(Node first){
        for(Node d = first;d!=null;d=d.next){
            System.out.println(d.item);
        }
    }
    public static void main(String[] args) {
        LinkedlistStack<String> s;
        s = new LinkedlistStack<>();
        s.push("hello");
        s.push("My");
        s.push("name");
        //s.pop();
        //s.pop();
        s.push("is");
       //s.pop();
        s.push("Lumos");
        System.out.println(s.size());
        s.write(s.first);
//        for(String a:s){
//           System.out.println(a);
//        }
    }
}
