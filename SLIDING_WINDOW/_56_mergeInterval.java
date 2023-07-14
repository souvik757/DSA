import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _56_mergeInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {10,12},
                {1,3} ,
                {3,5} ,
                {2,4}
        } ;
        solve_56 object = new solve_56() ;
        int[][] ans = object.merge(intervals) ;
        for (int[] arr : ans)
            System.out.println(Arrays.toString(arr));
    }
}
class solve_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>() ;
        Arrays.sort(intervals , (a,b)->a[0]-b[0]);
        int start = intervals[0][0] ;
        int end   = intervals[0][1] ;
        for (int[] top : intervals){
            if(top[0] <= end)
                end = Math.max(end , top[1]) ;
            else{
                answer.add(new int[]{start,end});
                start = top[0] ;
                end   = top[1] ;
            }
        }
        answer.add(new int[]{start,end});

        return answer.toArray(new int[0][0]) ;
    }
}