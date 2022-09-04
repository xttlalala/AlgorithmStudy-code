package Tool;

public class StopWatch {
    private final long start;
    public StopWatch(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }

//    public static void main(String[] args) {
////        int N = Integer.parseInt(args[0]);
//        int N = 10000000;
//        int[] a = new int[N];
//        for(int i=0;i<N;i++){
//            a[i] = StdRandom.uniformInt(-1000000,1000000);
//        }
//        Stopwatch timer = new Stopwatch();
//        for(int i=0;i<N;i++){
//            System.out.print(i+" ");
//        }
//        double time = timer.elapsedTime();
//        System.out.println("It need "+ time +"second.");
//    }
}

