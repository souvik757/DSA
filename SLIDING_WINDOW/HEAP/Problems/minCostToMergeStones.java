package HEAP.Problems;
import java.util.* ;
public class minCostToMergeStones {
    public static void main(String[] args) {
        _solve_ object = new _solve_() ;
        System.out.println(object.mergeStones(new int[]{3,2,4,1} , 2));
        System.out.println(object.mergeStones(new int[]{3,2,4,1} , 3));
        System.out.println(object.mergeStones(new int[]{3,5,1,2,6} , 3));
    }
}
class _solve_ {
    public int mergeStones(int[] stones, int k) {
        int minCost = 0 ;
        Queue<Integer> minheap = new PriorityQueue<>() ;
        for (int val : stones)
            minheap.add(val) ;
        while (minheap.size() >= k){
            int count = k ;
            int sum = 0 ;
            while (count-->0){
                sum += minheap.poll() ;
            }
            minCost += sum ;
            minheap.offer(sum) ;
        }

        return (minheap.size() != 1) ? -1 : minCost ;
    }
}