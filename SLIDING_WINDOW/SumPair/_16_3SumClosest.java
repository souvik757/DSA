package SumPair;

import java.util.Arrays;

public class _16_3SumClosest {
    public static void main(String[] args) {
        solve_16 obj = new solve_16() ;
        System.out.println(obj.threeSumClosest(new int[]{-1,2,1,-4} ,1)) ;
        System.out.println(obj.threeSumClosest(new int[]{ 0,0,0   } ,1)) ;
    }
}
class solve_16 {
    public int threeSumClosest(int[] num, int target) {

        int result = num[0] + num[1] + num[num.length-1] ;
        Arrays.sort(num) ;

        for (int i = 0 ; i < num.length - 2 ; i ++){
            int s = i + 1 ;
            int e = num.length - 1 ;
            while (s < e){
                int currentSum = num[i] + num[s] + num[e] ;
                if (currentSum < target)
                    s ++ ;
                else
                    e -- ;
                if(Math.abs(currentSum-target) < Math.abs(result-target))
                    result = currentSum ;
            }
        }

        return result ;
    }
}