package Sort;

import Tool.StdIn;
import Tool.Transaction;

import java.sql.SQLOutput;
import java.util.Stack;

public class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;//不使用pq[0]
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1,N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }
    private void swim(int k){
        while(k>1&&less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N&&less(j,j+1)){
                j++;
            }
            if(!less(k,j)) break;;
            exch(k,j);
            k=j;
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
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M+1);
        while (StdIn.hasNextLine()){
            //为下一行输入创建一个元素并放入优先队列中
            Transaction t =new Transaction(StdIn.readLine());
            pq.insert(t);//插入后进行有序化
            if(pq.size()>M){//有序化后再弹出最大元素（所以应该建立M+2大小的有限序列)
                pq.delMax();
            }
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()){
            stack.push(pq.delMax());
        }
        for(Transaction t:stack)
            System.out.println(t);
    }
}
