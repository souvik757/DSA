package SumPair;

import java.util.Arrays;

public class _167_TwoSumSortedInputArray {
    public static void main(String[] args) {
        solve_167 obj = new solve_167() ;
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2,3,4},6)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{-1,0},-1)));
    }
}
class solve_167 {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0 ;
        int e = numbers.length-1;
        while (s < e) {
            if(numbers[s]+numbers[e] < target)
                s ++ ;
            else if(numbers[s]+numbers[e] > target)
                e -- ;
            else
                return new int[]{s+1,e+1} ;
        }

        return new int[]{-1,-1} ;
    }
}