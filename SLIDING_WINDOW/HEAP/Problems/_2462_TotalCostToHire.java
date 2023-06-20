package HEAP.Problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class _2462_TotalCostToHire {
    public static void main(String[] args) {
        SOLVE_2462 object = new SOLVE_2462() ;
        System.out.println(object.totalCost
                (new int[]{17,12,10,2,7,2,11,20,8} , 3 , 4)
        );
        System.out.println(object.totalCost
                (new int[]{1,2,4,1} , 3 , 3)
        );
    }
}
class SOLVE_2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length ;
        int leftBound  = candidates ;
        int rightBound = n - candidates - 1 ;
        Queue<Integer> minHeap1 = new PriorityQueue<>() ;
        Queue<Integer> minHeap2 = new PriorityQueue<>() ;
        for (int i = 0 ; i < candidates ; i ++)
            minHeap1.offer(costs[i]) ;
        for (int i = n - 1 ; i >= Math.max(candidates , n - candidates) ; i --)
            minHeap2.offer(costs[i]) ;
        long answer = 0 ;
        while (k > 0) {
            if(!minHeap1.isEmpty() && !minHeap2.isEmpty()){
                if(minHeap1.peek() <= minHeap2.peek()){
                    answer += minHeap1.poll() ;

                    if(leftBound <= rightBound)
                        minHeap1.add(costs[leftBound++]) ;
                }
                else{
                    answer += minHeap2.poll() ;
                    if(leftBound <= rightBound)
                        minHeap2.add(costs[rightBound--]) ;
                }
            }
            else if(!minHeap1.isEmpty())
                answer += minHeap1.poll() ;
            else
                answer += minHeap2.poll() ;
            k -- ;
        }

        return answer ;
    }
}