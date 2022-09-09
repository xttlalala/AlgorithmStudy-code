package Sort;

import Tool.StdIn;
import Tool.Transaction;

import java.util.Stack;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private  int N = 0;
    public MinPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMin(){
        Key min = pq[1];
        exch(1,N);
        pq[N] = null;
        N--;
        sink(1);
        return min;
    }
    private void swim(int k){
        while(k>1&&less(k,k/2)){
            exch(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N&&less(j+1,j)){
                j++;
            }
            if(!less(j,k))break;
            exch(k,j);
            k = j;
        }
    }
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
        while (StdIn.hasNextLine()){
            Transaction t = new Transaction(StdIn.readLine());
            pq.insert(t);
            if(pq.size()>M){
                pq.delMin();
            }
        }
        System.out.println(pq.size());
        Stack<Transaction> stack = new Stack<Transaction>();
        while(!pq.isEmpty()){
            stack.push(pq.delMin());
        }
//        int i =1;
//        for(Transaction t:stack){
//            System.out.println((i++)+":"+t);
//        }
//        System.out.println("--------------------");
        int j =1;
        while(stack.size()>0){
            System.out.println((j++)+":"+stack.pop());
        }
    }
}
