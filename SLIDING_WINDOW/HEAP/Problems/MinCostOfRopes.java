package HEAP.Problems;

import java.util.Queue ;
import java.util.PriorityQueue ;

public class MinCostOfRopes {
    public static void main(String[] args) {
        solution object = new solution() ;
        System.out.println(object.MinCost(new int[]{4,3,2,6}));
        System.out.println(object.MinCost(new int[]{4,3,2,6,2,9}));
    }
}
class solution {
    public long MinCost(int[] ropes){
        long cost = 0 ;
        Queue<Integer> minheap = new PriorityQueue<>() ; // minheap
        // hence , usually priority queue inserts elements in ascending order , i.e, smallest-element at the top .
//      Queue<Integer> minheap = new PriorityQueue<>(Comparator.reverseOrder()) ; // maxheap i.e, largest-element at the top .
        for (int val : ropes) minheap.offer(val) ;
        while (minheap.size() > 1){
            int x = minheap.poll() ;
            int y = minheap.poll() ;
            int sum = x + y ;
            cost += sum ;
            minheap.offer(sum) ;
        }

        return cost ;
    }
}