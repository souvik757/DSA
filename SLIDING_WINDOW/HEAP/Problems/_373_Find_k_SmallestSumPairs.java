package HEAP.Problems;

import java.util.*;

public class _373_Find_k_SmallestSumPairs {
    public static void main(String[] args) {
        SOLVE_373 object = new SOLVE_373() ;
        List<List<Integer>> answer = new ArrayList<>() ;
        answer = object.kSmallestPairs(new int[]{1,7,11} , new int[]{2,4,6} , 3) ;
        for (List<Integer> val : answer)
            System.out.print(val);
    }
}
class SOLVE_373 {
    public List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        Queue<int[]> minheapSum = new PriorityQueue<>((a,b)->((a[0]+a[1]) - (b[0]+b[1]))) ;

        for (int i = 0 ; i < num1.length ; i ++){
            for (int j = 0 ; j < num2.length ; j ++)
                minheapSum.add(new int[]{num1[i] , num2[j]}) ;
        }

        while (k > 0 && !minheapSum.isEmpty()) {
            List<Integer> pairs = new ArrayList<>() ;
            pairs.add(minheapSum.peek()[0]);
            pairs.add(minheapSum.peek()[1]);
            minheapSum.remove() ;
            answer.add(new ArrayList<>(pairs));
            k -- ;
        }

        return answer ;
    }
}