package Sort;

import Tool.StdRandom;
import Tool.StopWatch;

public class SortCompare {
    public static double time(String alg,Comparable[] a){
        StopWatch timer = new StopWatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        return timer.elapsedTime();
    }
    //使用某排序算法将T个长度为N的数组排序
    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t=0;t<T;t++){
            for(int i=0;i<N;i++){
                a[i] = StdRandom.uniformDouble();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]) ;
        int T = Integer.parseInt(args[3]) ;
        double t1 = timeRandomInput(alg1,N,T);
        double t2 = timeRandomInput(alg2,N,T);
        boolean result = t1<t2?true:false;
        if(result){
            System.out.println("For "+N+" random Doubles,"+alg1+" is "+(t2/t1)+" times faster than "+alg2);
        }
        else{
            System.out.println("For "+N+" random Doubles,"+alg2+" is "+(t1/t2)+" times faster than "+alg1);
        }
    }
}
