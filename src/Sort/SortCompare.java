package Sort;

import Tool.StdRandom;
import Tool.StopWatch;
//SortCpmpare这类程序对于渐进式的算法研究十分重要。每一步，我们都能用这类程序来了解
//新的或是改进过的算法的性能是否产生了预期的进步。
public class SortCompare {
    public static double time(String alg,Comparable[] a){
        StopWatch timer = new StopWatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sort(a);
        if(alg.equals("MergeBU")) MergeBU.sort(a);
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
        System.out.println("For "+N+" random Doubles,");
        System.out.println(alg1+"'s time is "+t1+"s.");
        System.out.println(alg2+"'s time is "+t2+"s.");
        boolean result = t1<t2?true:false;
        if(result){
            System.out.println(alg1+" is "+(t2/t1)+" times faster than "+alg2);
        }
        else{
            System.out.println(alg2+" is "+(t1/t2)+" times faster than "+alg1);
        }
    }
}
