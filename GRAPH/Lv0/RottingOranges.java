import java.util.Queue ;
import java.util.LinkedList ;
public class RottingOranges {
    public static void main(String[] args) {
        solution994 object = new solution994() ;
        System.out.println(object.orangesRotting(new int[][]{
                {2 , 1 , 0} ,
                {1 , 1 , 0} ,
                {0 , 1 , 1}
        }));
        System.out.println(object.orangesRotting(new int[][]{
                {2 , 1 , 1} ,
                {0 , 1 , 1} ,
                {1 , 0 , 1}
        }));
        System.out.println(object.orangesRotting(new int[][]{
                {0 , 2}
        }));
    }
}
class solution994 {
    public int orangesRotting(int[][] grid) {
        int[] delrow = new int[]{-1,0,1, 0} ;// possible row changes    :::
        int[] delcol = new int[]{ 0,1,0,-1} ;// possible column changes :::
        int MaxTime = Integer.MIN_VALUE ;// Minimized variable to find max time :::
        int fresh = 0 ; // initial number of fresh oranges :::
        Queue<Pair<Integer,Integer,Integer>> queue = new LinkedList<>() ;
        for (int i = 0 ; i < grid.length ; i ++) {
            for (int j = 0 ; j < grid[0].length ; j ++) {
                if (grid[i][j] == 2)
                    queue.add(new Pair<>(i,j,0)) ;
                if (grid[i][j] == 1)
                    fresh ++ ;
            }
        }
        if (fresh == 0)
            return 0 ;
        // traversing the grid and fill the queue :::
        while (!queue.isEmpty()) {
            Pair<Integer,Integer,Integer> current = queue.poll() ;
            MaxTime = Math.max(MaxTime, current.time) ;
            for (int i = 0 ; i < 4 ; i ++) {
                int nextrow = current.row + delrow[i] ;
                int nextcol = current.column + delcol[i] ;
                if(nextrow < 0 || nextrow >= grid.length || nextcol < 0 || nextcol >= grid[0].length
                        || grid[nextrow][nextcol] == 2 || grid[nextrow][nextcol] == 0)
                    continue ;
                grid[nextrow][nextcol] = 2 ;
                queue.add(new Pair<>(nextrow,nextcol, current.time+1)) ;
                fresh-- ;
            }
        }
        return (fresh==0) ? MaxTime : -1 ;
    }
    class Pair<R,C,T> {
        R row ;
        C column ;
        T time ;
        public Pair(R row , C column , T time) {
            this.row = row ;
            this.column = column ;
            this.time = time ;
        }
    }
}
