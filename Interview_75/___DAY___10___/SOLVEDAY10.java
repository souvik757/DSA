import java.util.ArrayList;
import java.util.List;
import java.util.Queue ;
import java.util.LinkedList ;
public class SOLVEDAY10 {
    // QUES 994 . Rotting Oranges :::
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
        if (fresh == 0) // there is no fresh oranges to rot :::
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
    // QUES 417 . Pacific Antartaka water flow :::
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>() ;
        boolean[][] pacific = new boolean[heights.length][heights[0].length] ;
        boolean[][] atlantic = new boolean[heights.length][heights[0].length] ;


        for(int i = 0 ; i < heights.length ; i ++){
            for(int j = 0 ; j < heights[0].length ; j ++){
                if(i == 0 || j == 0)
                    verify_reach(i,j,heights,pacific,0);
                if(i == heights.length-1 || j == heights[0].length-1)
                    verify_reach(i,j,heights,atlantic,0) ;
            }
        }

        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[0].length ; j++){
                List<Integer> pairs = new ArrayList<>() ;
                boolean verify = pacific[i][j] && atlantic[i][j] ;
                if(verify) {
                    pairs.add(i);
                    pairs.add(j);
                    answer.add(new ArrayList<>(pairs)) ;
                }
            }
        }
        return answer ;
    }

    private void verify_reach(int r, int c, int[][] heights, boolean[][] ocean , int previous) {
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length ||
                ocean[r][c] || heights[r][c] <= previous)
            return ;

        ocean[r][c] = true ;

        int[] delRow = new int[]{-1,0,1,0} ;
        int[] delCol = new int[]{0,1,0,-1} ;

        for(int index = 0 ; index < 4 ; index++)
            verify_reach(r + delRow[index],c + delCol[index],heights,ocean,heights[r][c]);
    }
}
