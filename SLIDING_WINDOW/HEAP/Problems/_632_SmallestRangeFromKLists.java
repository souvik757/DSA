package HEAP.Problems;

import java.util.* ;

public class _632_SmallestRangeFromKLists {
    public static void main(String[] args) {
        solve_632 object = new solve_632() ;
    }
}
class node{
    int val ;
    int i ;
    int j;
    int size ;
    public node(int val, int i, int j, int size) {
        this.val = val;
        this.i = i ;
        this.j = j;
        this.size = size;
    }
}
class solve_632 {
    /**
     * Algorithm follows the style of
     * " merge k sorted lists "
     * 1st step . store first elements of each list to the queue(minheap)
     * 2nd step . update starting & ending range
     * @param nums
     * @return smallest range
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int maxVal = Integer.MIN_VALUE ;
        int minVal = Integer.MAX_VALUE ;

        Queue<node> minHeap = new PriorityQueue<>((a,b)->a.val-b.val) ;
        int i = 0 ;
        for (List<Integer> list : nums){
            int j = 0 ;
            int size = list.size() ;
            for (int val : list){
                if(j == 0){
                    maxVal = Math.max(maxVal , val) ;
                    minVal = Math.min(minVal , val) ;
                    node element = new node(val , i , j , size) ;
                    minHeap.offer(element) ;
                }
                j++ ;
            }
            i++ ;
        }


        int startRange = minVal ;
        int endRange = maxVal ;

        while (!minHeap.isEmpty()){
            node temp = minHeap.poll() ;
            minVal = temp.val ;

            if(maxVal-minVal < endRange-startRange){
                startRange = minVal ;
                endRange = maxVal ;
            }

            if(temp.j + 1 < temp.size){
                maxVal = Math.max(maxVal , nums.get(temp.i).get(temp.j+1)) ;
                minHeap.offer(new node(nums.get(temp.i).get(temp.j+1) ,temp.i ,temp.j+1 ,temp.size)) ;
            }
            else
                break ;
        }

        return new int[]{startRange,endRange};
    }
}