package SumPair;

import java.util.Arrays;
import java.util.Map ;
import java.util.HashMap ;
public class _1_2Sum {
    public static void main(String[] args) {
        solve_1 obj = new solve_1() ;
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2,7,11,15},9))) ;
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3,2,4},6))) ;
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3,3},6))) ;
    }
}
class solve_1 {
    public int[] twoSum(int[] num, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>() ;
        for (int i = 0 ; i < num.length ; i ++)
            indexMap.put(num[i], i) ;
        for (int i = 0 ; i < num.length ; i ++){
            int val = num[i] ;
            if(indexMap.containsKey(target-val)){
                int j = indexMap.get(target-val) ;
                if(i == j)
                    continue ;
                return new int[]{i,j} ;
            }
        }

        return new int[]{-1,-1} ;
    }
}