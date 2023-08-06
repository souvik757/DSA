import java.util.*;

public class _57_InsertIntervals {
    public static void main(String[] args) {
        int[][] ans =         solve_57.insert(new int[][]{
                {1,2} ,
                {3,5} ,
                {6,7} ,
                {8,10} ,
                {12,16}
        } , new int[]{4,8}) ;
        for (int[] arr : ans)
            System.out.println(Arrays.toString(arr));
    }
}
class solve_57{
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
            return new int[][]{newInterval} ;
        List<int[]> answer = new ArrayList<>() ;
        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]) ;
        for(int[] val : intervals){
            queue.offer(val) ;
        }
        queue.add(newInterval) ;

        assert queue.size() != 0 ;

        int start = queue.peek()[0] ;
        int end = queue.poll()[1] ;
        while (!queue.isEmpty()){
            int[] top = queue.remove() ;
            if(top[0] <= end){
                end = Math.max(end , top[1]) ;
            }
            else {
                answer.add(new int[]{start,end}) ;
                start = top[0] ;
                end = top[1] ;
            }
        }
        answer.add(new int[]{start,end}) ;

        return answer.toArray(new int[0][0]) ;
    }
}