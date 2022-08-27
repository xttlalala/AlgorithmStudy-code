package Base;

import java.util.Iterator;

public class LinkedlistBag<Item> implements Iterable<Item> {
    private Node first;
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node oldFirest = first;
        first = new Node();
        first.item = item;
        first.next = oldFirest;
    }
    public Iterator<Item> iterator(){
        return new LinkedlistIterator();
    }
    private class LinkedlistIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedlistBag<String> bag = new LinkedlistBag<String>();
        bag.add("My");
        bag.add("My2");
        bag.add("My3");
        bag.add("My4");
        bag.add("My5");
        bag.add("My6");
        bag.add("My7");
        for(String b:bag){
            System.out.print(b+" ");
        }
    }
}
