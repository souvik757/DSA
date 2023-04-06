public class CountSubIslands {
    public static void main(String[] args) {
        solutionG6 object = new solutionG6() ;
        int[][] grid1 = new int[][]{ {1,1,0,0} , {0,1,0,1} , {0,1,0,1} , {0,1,0,0} } ;
        int[][] grid2 = new int[][]{ {1,1,0,0} , {0,0,0,1} , {0,0,0,0} , {0,1,0,0} } ;
        System.out.println(object.countSubIslands(grid1,grid2)) ;
    }
}
class solutionG6{
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for(int i = 0 ; i < grid1.length ; i++){
            for(int j = 0 ; j < grid1[0].length ; j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1) {
                    shrunk(i,j,grid2);
                }
            }
        }
        int count = 0 ;
        for(int i = 0 ; i < grid1.length ; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if(grid2[i][j] == 1){
                    count++ ;
                    shrunk(i,j,grid2);
                }
            }
        }

        return count ;
    }

    private void shrunk(int i , int j ,int[][] grid) {
        if(grid[i][j] != 1) return ;
        grid[i][j] = 0 ;
        int[] delRow = new int[]{-1,0,1,0} ;
        int[] delCol = new int[]{0,1,0,-1} ;
        for(int index = 0 ; index < 4 ; index++){
            int row = index + delRow[index] ;
            int col = j + delCol[index] ;
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length)
                shrunk(row,col,grid);
        }
    }
}
