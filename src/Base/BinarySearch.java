package Base;
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
        System.out.println(1);
        int[] whitelist = {45,34,78,23,98,12};
        Arrays.sort(whitelist);
        System.out.println(Arrays.toString(whitelist));
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whitelist)<0)
                System.out.println("没找到");
            else
                System.out.println("找到了");
        }
    }
}
