package HEAP.Problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2542_MaxSubSeqScore {
    public static void main(String[] args) {
        SOLVE_2542 object = new SOLVE_2542() ;
        System.out.println(object.maxScore
                (new int[]{1,3,3,2} , new int[]{2,1,3,4} , 3)
        );
        System.out.println(object.maxScore
                (new int[]{1,4,6,7,8,9} , new int[]{6,10,12,4,1,2} , 3)
        );
    }
}
// solve = SUM(num1(0--->k)) + MAX(num2(0,1,...k))
class SOLVE_2542 {
    public long maxScore(int[] num1, int[] num2, int k) {
        long answer = 0 ;

        // step 1 : make pair (num1 , num2) and sort them according to decreasing order of num2 elements
        int[][] pairs = new int[num1.length][2] ;
        for (int i = 0 ; i < num1.length ; i ++)
            pairs[i] = new int[]{num1[i] , num2[i]} ;
        Arrays.sort(pairs , (a,b) -> b[1] - a[1]) ;

        // step 2 : find sum of num1 elements up to kth index and add them to a minheap
        long topSum = 0 ;
        Queue<Integer> minheap = new PriorityQueue<>() ;
        for (int i = 0 ; i < k ; i ++){
            topSum += pairs[i][0] ;
            minheap.add(pairs[i][0]) ;
        }

        // step 3 : find solve for 1st k elements
        answer = topSum * pairs[k-1][1] ;

        // step 4 : traverse the heap for the rest elements , popping the smallest element to get the max solve
        for (int i = k ; i < pairs.length ; i ++) {
            topSum += ( pairs[i][0] - minheap.poll()) ;
            minheap.add(pairs[i][0]) ;
            answer = Math.max(answer , topSum * pairs[i][1]) ;
        }

        return answer ;
    }
}