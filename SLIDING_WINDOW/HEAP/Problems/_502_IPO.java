package HEAP.Problems;

import java.util.Queue ;
import java.util.PriorityQueue ;
public class _502_IPO {
    public static void main(String[] args) {
        SOLVE_502 object = new SOLVE_502() ;
        System.out.println(object.findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));     // 4
        System.out.println(object.findMaximizedCapital(3,0,new int[]{1,2,3},new int[]{0,1,2}));     // 6
        System.out.println(object.findMaximizedCapital(3,0,new int[]{1,4,5,2},new int[]{0,1,1,2})); // 10
    }
}
class SOLVE_502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // PriorityQueue<int[]{profit,capital}>
        int len = profits.length ;
        Queue<int[]> maxheap = new PriorityQueue<>((a,b)->(b[0] - a[0])) ; // prioritizes based on max profit
        Queue<int[]> minheap = new PriorityQueue<>((a,b)->(a[1] - b[1])) ; // prioritizes based on min capital
        for (int i = 0 ; i < len ; i ++)
            minheap.offer(new int[]{profits[i],capital[i]});
        while (k-->0){
            while (!minheap.isEmpty() && minheap.peek()[1] <= w)
                maxheap.offer(minheap.poll()) ;
            if(maxheap.isEmpty()) break ;
            w += maxheap.poll()[0] ;
        }
        return w ;
    }
}