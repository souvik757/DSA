package HEAP.Problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
public class _128_LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] arr ;
        arr = new int[]{
                100,4,200,1,3,2
        } ;
        Arrays.sort(arr) ;
        System.out.println(Arrays.toString(arr)) ;
        System.out.println(solve_128.longestConsecutive(arr));
        arr = new int[]{
                0,3,7,2,5,8,4,6,0,1
        } ;
        Arrays.sort(arr) ;
        System.out.println(Arrays.toString(arr)) ;
        System.out.println(solve_128.longestConsecutive(arr));

    }
}
class solve_128 {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0 ;
        int count = 1 ;
        int maxCount = 1 ; // minimum possible consecutive numbers has to be 1
        Queue<Integer> minHeap = new PriorityQueue<>() ;
        for (int val : nums)
            minHeap.offer(val) ;
        int top = minHeap.remove() ;
        while (!minHeap.isEmpty()){
            int temp = minHeap.remove() ;
            if(top == temp)
                continue ;
            else if(top == temp - 1)
                count ++ ;
            else
                count = 1 ;
            top = temp ;
            maxCount = Math.max(maxCount , count) ;
        }
        return maxCount ;
    }
}