package Problems;

import java.util.Map ;
import java.util.HashMap ;
public class _1_TwoSum {
    public int[] twoSum(int[] num, int target) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for (int i = 0 ; i < num.length ; i ++)
            map.put(num[i] , i) ;
        for (int i = 0 ; i < num.length ; i ++){
            int val = num[i] ;
            if(map.containsKey(target-val)) {
                int j = map.get(target - val) ;
                if(i == j)
                    continue ;
                return new int[]{i, j};
            }
        }

        return new int[]{-1,-1} ;
    }
}
