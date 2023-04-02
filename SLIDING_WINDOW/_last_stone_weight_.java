import java.util.Comparator;
import java.util.PriorityQueue;

public class _last_stone_weight_ {
    public static void main(String[] args) {
        question result = new question() ;
        System.out.println(result.lastStoneWeight(new int[]{9,10,1,7,3}));
        System.out.println(result.lastStoneWeight(new int[]{7,4,8}));
        System.out.println(result.lastStoneWeight(new int[]{1}));
    }
}
class question{
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()) ;
        for(int i : stones)
            maxHeap.add(i) ;
        while (maxHeap.size() != 1){
            //System.out.println(maxHeap);
            int X = maxHeap.remove() ;
            int Y = maxHeap.remove() ;
            if(X==Y)  maxHeap.add(0) ;
            if(X!=Y)  maxHeap.add(Math.abs(Y-X)) ;
        }
        return maxHeap.peek() ;
    }
}
