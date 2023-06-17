package HEAP.Problems;

import java.util.PriorityQueue;
public class _2336_SmallestNumber {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet() ;
        smallestInfiniteSet.addBack(2);
        smallestInfiniteSet.popSmallest()  ;
        smallestInfiniteSet.popSmallest()  ;
        smallestInfiniteSet.popSmallest()  ;
        smallestInfiniteSet.addBack(1);
        smallestInfiniteSet.popSmallest()  ;
        smallestInfiniteSet.popSmallest()  ;
        smallestInfiniteSet.popSmallest()  ;
    }
}
class SmallestInfiniteSet {
    int size = 1 ;
    private PriorityQueue<Integer> priorityQueue ;
    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>() ;
    }
    public int popSmallest() {
        if(priorityQueue.isEmpty())
            return size++ ;
        return priorityQueue.poll() ;
    }
    public void addBack(int num) {
        if(num >= size || priorityQueue.contains(num))
            return ;
        priorityQueue.add(num) ;
    }
}