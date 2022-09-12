package Search;

import Tool.Queue;
import Tool.StdIn;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int N;
    public BinarySearchST(){
        this(INIT_CAPACITY);
    }
    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    public int size(){
        return N;
    }
    private void resize(int capacity){
        Key[] temk = (Key[]) new Comparable[capacity];
        Value[] temv = (Value[]) new Object[capacity];
        for(int i=0;i<N;i++){
            temk[i] = keys[i];
            temv[i] = values[i];
        }
        keys = temk;
        values = temv;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i<N&&key.compareTo(keys[i])==0) return values[i];
        else return null;
    }
    public void put(Key key,Value value){
        if(value==null){
            delete(key);
            return;
        }
        int i = rank(key);
        if(i<N&&key.compareTo(keys[i])==0){
            values[i] = value;
        }
        else{
            if(N==keys.length)
                resize(2*(keys.length));
            for(int j=N;j>i;j--){
                keys[j] = keys[j-1];
                values[j] = values[j-1];
            }
            keys[i] = key;
            values[i] = value;
            N++;
        }
    }
    public boolean contains(Key key){
        int i = rank(key);
        if(i<N&&key.compareTo(keys[i])==0)
            return true;
        else
            return false;
    }
    //基于有序数组的二分查找:返回表中小于key的键的数量；
    public int rank(Key key){
        int lo = 0;
        int hi = N-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp<0) hi = mid-1;
            else if(cmp>0) lo = mid+1;
            else return mid;
        }
        return lo;
    }
    public Key min(){
        return keys[0];
    }
    public Key max(){
        return keys[N-1];
    }
    public Key select(int k){
        return keys[k];
    }
    public Key ceiling(Key key){//大于等于key的最小键
        int i = rank(key);
        if(i==N)
            throw new NoSuchElementException("argument to ceiling() is too large");
        else
        return keys[i];
    }
    public Key floor(Key key){//小于等于key的最大键
        int i = rank(key);
        if(i<N&&key.compareTo(keys[i])==0) return keys[i];
        if(i==0)
            throw new NoSuchElementException("argument to floor() is too small");
        else return keys[--i];
    }
    public void delete(Key key){
        if(isEmpty()) return ;
        int i = rank(key);
        if(i<N&&key.compareTo(keys[i])==0){
            for(int j = i;j<N-1;j++){
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            N--;
            if(N>0&&N==keys.length/4){
                resize(keys.length/2);
            }
            keys[N] = null;
            values[N] = null;
            return;
        }
        else{
            return;
        }
    }
    public Iterable<Key> keys(){
       return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> q = new Queue<Key>();
        for(int i=rank(lo);i<rank(hi);i++){
            q.enqueue(keys[i]);
        }
        if(contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }
    public static void main(String[] args) {
        BinarySearchST<String,Integer> st;
        st = new BinarySearchST<>();
        for(int i=0;!StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        for(String s:st.keys())
            System.out.println(s+" "+st.get(s));
    }
}
