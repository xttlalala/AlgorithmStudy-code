package Base;
import Tool.In;
import Tool.StdIn;
import java.util.Arrays;


public class BinarySearch {
    public static int rank(int key,int[] a){
        int lo = 0;
        int hi = a.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(key<a[mid])
                hi = mid-1;
            else if(key>a[mid])
                lo = mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("WhiteList's numbers are:");
//        int[] whitelist = {45,34,78,23,98,12};
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        System.out.println(Arrays.toString(whitelist));
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whitelist)<0)
                System.out.println("NumberList's "+key+" is not in whiteList");
        }
    }
}
