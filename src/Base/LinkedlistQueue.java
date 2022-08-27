package Base;

import Tool.StdIn;

import java.util.Queue;

public class LinkedlistQueue<Item>{
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        if(!isEmpty()){
            Item item = first.item;
            first = first.next;
            N--;
            if(first==null){
                last = null;
            }
            return item;
        }
        else
            return null;
    }

    public static void main(String[] args) {
        LinkedlistQueue<String> q = new LinkedlistQueue<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                q.enqueue(item);
            }
            else if(!q.isEmpty())
                System.out.print(q.dequeue()+" ");
        }
        System.out.println("("+q.size()+" left on queue)");
    }
}
