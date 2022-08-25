package Base;

import java.util.Iterator;

//import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        if(N==a.length){
            resize(a.length*2);
        }
        a[N++] = item;
    }
    public Item pop(){
        if(N>0) {
            Item item = a[--N];
            a[N] = null;
            if(N==a.length/4)
                resize(a.length/2);
            return item;
        }
        else
            return null;
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    public class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext(){
            return  i>0;
        }
        public Item next(){
            return a[--i];
        }
        public void remove(){}
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> s;
        s = new ResizingArrayStack<String>();
        s.push("hello");
        s.push("My");
        s.push("name");
        //s.pop();
        //s.pop();
        s.push("is");
        //s.pop();
        s.push("Lumos");
        System.out.println(s.size());
        for(String a:s){
            System.out.println(a);
        }
    }
}
