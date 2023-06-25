package HEAP.Problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class kth_maximum_sum_subarray {
    public static void main(String[] args) {
        SOLVE_kth_max_sum object = new SOLVE_kth_max_sum() ;
        System.out.println(object.kth_maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4} , 2));
    }
}
class SOLVE_kth_max_sum {
    public int kth_maxSubArray(int[] nums , int k) {

        Queue<Integer> minheap = new PriorityQueue<>() ;
        for(int i = 0 ; i < nums.length ; i ++){
            int sum = 0 ;
            for (int j = i ; j < nums.length ; j ++){
                sum += nums[j] ;
                if (minheap.size() < k)
                    minheap.offer(sum) ;
                else {
                    if (sum > minheap.peek()){
                        minheap.poll() ;
                        minheap.offer(sum) ;
                    }
                }
            }
        }
        return minheap.peek() ;
    }
}