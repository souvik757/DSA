import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        solutionG5 object = new solutionG5() ;
        System.out.println(object.numEnclaves(new int[][]{{0,0,0,1,1} , {0,0,1,1,0} , {0,1,0,0,0} , {0,1,1,0,0} , {0,0,0,1,1}}));
    }
}
class solutionG5{
    public int numEnclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length] ;
        Queue<solve.Pair> queue = new LinkedList<>() ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 || i == grid.length-1 || j == 0 || j == grid[0].length-1){
                    if(grid[i][j] == 1) {
                        solve.Pair boundary = new solve.Pair(i, j);
                        queue.add(boundary);
                        visited[i][j] = 1;
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            int row = queue.peek().first ;
            int col = queue.peek().second ;
            queue.remove() ;

            int[] delRow = new int[]{-1,0,1,0} ;
            int[] delCol = new int[]{0,1,0,-1} ;
            for(int i = 0 ; i < 4 ; i++){
                int R = row + delRow[i] ;
                int C = col + delCol[i] ;
                if(R >= 0 && R < grid.length && C >= 0 && C < grid[0].length && visited[R][C] == 0 && grid[R][C] == 1){
                    solve.Pair valid = new solve.Pair(R,C) ;
                    queue.add(valid) ;
                    visited[R][C] = 1 ;
                }
            }
        }

        int count = 0 ;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0)
                    count++ ;
            }
        }
        return count ;
    }
}

