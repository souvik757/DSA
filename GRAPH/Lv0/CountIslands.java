public class CountIslands {
    public static void main(String[] args){
        solution012 object = new solution012() ;
        int[][] grid = new int[][]{{1,1,0,0,0} , {1,1,0,0,0} , {0,0,1,0,0} , {0,0,0,1,1}} ;
        System.out.println(object.numIslands(grid)) ;
    }
}
class solution012 {
    public int numIslands(int[][] grid) {
        int count = 0 ;
        int n = grid.length ;
        if(n == 0) return 0 ;
        int m = grid[0].length ;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    count++ ;
                    _apply_bfs_(i,j,grid,new int[]{-1,0,1,0}, new int[]{0,1,0,-1});
                }
            }
        }
        return count ;
    }

    private void _apply_bfs_(int i, int j, int[][] grid, int[] delRow , int[] delCol) {
        if(grid[i][j] != 1)
            return ;
        grid[i][j] = 0 ;
        for(int index = 0 ; index < 4 ; index++){
            int row = i + delRow[index] ;
            int col = j + delCol[index] ;
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length)
                _apply_bfs_(row,col,grid,delRow,delCol);
        }
    }
}
