package HEAP.Problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class _41_firstMissingPositiove {
    public static void main(String[] args) {
        System.out.println(solve_41.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(solve_41.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(solve_41.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
class solve_41 {
    public static int firstMissingPositive(int[] nums) {
        Queue<Integer> minheap = new PriorityQueue<>() ;
        for (int val : nums){
            if(val > 0)
                minheap.add(val) ;
        }
        // System.out.println(minheap);
        int missing = 1 ;
        while(!minheap.isEmpty()){
            int top = minheap.poll() ;
            if(top == missing)
                missing++ ;
            else if(top > missing)
                break ;
        }

        return missing ;
    }
}