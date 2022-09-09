package Sort;

import Tool.StdIn;

public class Heapsort {
    public static void sort(Comparable[] a){
        int N = a.length-1;
        System.out.println(N);
        for(int k = N/2;k>=1;k--){
            sink(a,k,N);
        }
        while(N>1){
            exch(a,N--,1);
            sink(a,1,N);
        }
    }
    private static void sink(Comparable[] a,int k,int N){
        while(2*k<=N){
            int j = 2*k;
            if(j<N&&less(a,j,j+1)){
                j++;
            }
            if(!less(a,k,j)) break;;
            exch(a,k,j);
            k=j;
        }
    }
    private static boolean less(Comparable[] a,int i,int j){
        return a[i].compareTo(a[j])<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for(int i=1;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    private static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a,i,i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        String[] b = new String[a.length+1];
        b[0]=null;
        for(int i=1;i<b.length;i++)
            b[i]=a[i-1];
        sort(b);
        assert isSorted(b);
        show(b);

    }
}
